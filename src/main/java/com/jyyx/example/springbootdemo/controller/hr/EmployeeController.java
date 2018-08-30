package com.jyyx.example.springbootdemo.controller.hr;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyyx.example.springbootdemo.domain.ExceptionMsg;
import com.jyyx.example.springbootdemo.domain.Response;
import com.jyyx.example.springbootdemo.entity.base.Permission;
import com.jyyx.example.springbootdemo.entity.hr.Department;
import com.jyyx.example.springbootdemo.entity.hr.Employee;
import com.jyyx.example.springbootdemo.entity.weixin.base.WxUser;
import com.jyyx.example.springbootdemo.entity.weixin.util.CoreUtil;
import com.jyyx.example.springbootdemo.service.BasePermissionService;
import com.jyyx.example.springbootdemo.service.hr.DepartmentService;
import com.jyyx.example.springbootdemo.service.hr.EmployeeService;
import com.jyyx.example.springbootdemo.service.base.RolePermissionService;
import com.jyyx.example.springbootdemo.service.weixin.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@Transactional
@RequestMapping(value = "employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RolePermissionService rolePermissionService;

    @Autowired
    private BasePermissionService basePermissionService;

    @Autowired
    private WxService wxService;

    @Autowired
    private DepartmentService departmentService;


    @RequestMapping(value = "goEmployeeList")
    public String goEmployeeList(
            HashMap<String,Object> map,
            HttpServletRequest request,
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "keyword",defaultValue = "")String keyword,
            @RequestParam(value = "dep",defaultValue ="")String dep,
            @RequestParam(value = "status",defaultValue ="")String status
    ) throws Exception {
        //定义查询参数map
        HashMap<String,Object> paramSet = new HashMap<>();
        paramSet.put("page",page);
        paramSet.put("keyword",keyword);
        paramSet.put("dep",dep);
        paramSet.put("status",status);
        //拿到访问路径uri
        String uri = request.getRequestURI();
        //拿到权限返回的map集合
        HashMap<String,Object> resultMap = basePermissionService.queryPermissionByOpenId(CoreUtil.open_id,uri);
        //如果flag==true  返回yes  否则返回no
        Object storeId = resultMap.get("storeId");
        Object storeName = resultMap.get("storeName");
        String flag = (Boolean)resultMap.get("urlPermission") ? "yes" : "no";
        String doPermission = resultMap.get("doPermission").toString();
        //初始化部门下拉框数据
        List<Department> departmentList = departmentService.queryDepartmentList(new HashMap<>());
        //开始分页
        PageHelper.startPage(page,10);
        //员工数据
        List<Employee> employeeList = employeeService.queryEmployeeList(paramSet);
        PageInfo<Employee> p = new PageInfo<Employee>(employeeList);
        //分页
        map.put("page",p);
        //访问权限
        map.put("permission",flag);
        //操作权限
        map.put("doPermission",doPermission);
        //部门下拉框
        map.put("department",departmentList);
        map.put("employeeList",employeeList);
        if(storeId != null && !"".equals(storeId.toString())) {
            map.put("storeId", storeId.toString());
            map.put("storeName", storeName.toString());
        }
        return "hr/employee";
    }

    @RequestMapping(value = "goMpEmployeeList")
    public String goMpEmployeeList(
            HttpServletRequest request,
            HashMap<String,Object> map
    ) throws Exception {
        //拿到访问路径uri
        String uri = request.getRequestURI();
        //拿到权限返回的map集合
        HashMap<String,Object> resultMap = basePermissionService.queryPermissionByOpenId(CoreUtil.open_id,uri);
        //如果flag==true  返回yes  否则返回no
        Object storeId = resultMap.get("storeId");
        Object storeName = resultMap.get("storeName");
        String flag = (Boolean)resultMap.get("urlPermission") ? "yes" : "no";
        String doPermission = resultMap.get("doPermission").toString();
        if(storeId != null && !"".equals(storeId.toString())) {
            map.put("storeId", storeId.toString());
            map.put("storeName", storeName.toString());
        }
        return "mp/employee";
    }

    @RequestMapping(value = "goAddEmployee")
    public String goAddEmployee(
            HttpServletRequest request,
            HashMap<String,Object> map) throws Exception {
        //拿到访问路径uri
        String uri = request.getRequestURI();
        //拿到权限返回的map集合
        HashMap<String,Object> resultMap = basePermissionService.queryPermissionByOpenId(CoreUtil.open_id,uri);
        //如果flag==true  返回yes  否则返回no
        Object storeId = resultMap.get("storeId");
        Object storeName = resultMap.get("storeName");
        String flag = (Boolean)resultMap.get("urlPermission") ? "yes" : "no";
        String doPermission = resultMap.get("doPermission").toString();
        if(storeId != null && !"".equals(storeId.toString())) {
            map.put("storeId", storeId.toString());
            map.put("storeName", storeName.toString());
        }
        return "mp/addemployee";
    }



    @RequestMapping(value = "goEmployeeDetail")
    public String goEmployeeDetail(
            HashMap<String,Object> map,
            @RequestParam(value = "employeeId")String employeeId
    ) throws Exception {
        map.put("employeeId",employeeId);
        return "mp/employeedetail";
    }

    @RequestMapping(value="/getEmployeeList")
    @ResponseBody
    List<Employee> getEmployeeList(
            @RequestParam(value = "keyword",defaultValue = "")String keyword,
            @RequestParam(value = "dep",defaultValue ="")String dep,
            @RequestParam(value = "status",defaultValue ="")String status
    ) throws Exception{
        HashMap<String,Object> paramSet = new HashMap<>();
        paramSet.put("keyword",keyword);
        paramSet.put("dep",dep);
        paramSet.put("status",status);
        return   employeeService.queryEmployeeList(paramSet);
    }

    /**
     * 保存数据
     * @param employeeId
     * @param employeeName
     * @param age
     * @param idCard
     * @param telephone
     * @param position
     * @param sex
     * @param departmentId
     * @param departmentName
     * @param storeId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "saveEmployee")
    @ResponseBody
    public Response saveEmployee(
            @RequestParam(value ="employeeId",defaultValue = "")String employeeId,
            @RequestParam(value = "employeeName")String employeeName,
            @RequestParam(value = "age")int age,
            @RequestParam(value = "idCard")String idCard,
            @RequestParam(value = "telephone")String telephone,
            @RequestParam(value = "position")String position,
            @RequestParam(value = "sex")int sex,
            @RequestParam(value = "departmentId")int departmentId,
            @RequestParam(value = "departmentName")String departmentName,
            @RequestParam(value = "storeId")String storeId,
            @RequestParam(value = "storeName")String storeName
    )throws Exception{
        Employee employee = new Employee();
        employee.setId(employeeId);
        employee.setEmployeeName(employeeName);
        employee.setAge(age);
        employee.setIdCard(idCard);
        employee.setTelephone(telephone);
        employee.setPosition(position);
        employee.setSex(sex);
        employee.setDepartmentId(departmentId);
        employee.setDepartmentName(departmentName);
        employee.setStoreId(storeId);
        employee.setStoreName(storeName);
        if(storeId != null && !"".equals(storeId)){
            employee.setEmployeeType(1);
        }else{
            employee.setEmployeeType(0);
        }
//        employeeService.addOrEditEmployee(employee);
        if(employeeService.addOrEditEmployee(employee) >= 1){
            return new Response(ExceptionMsg.SUCCESS);
        }
        return new Response(ExceptionMsg.FAILED);
    }

    /**
     * 根据id查出单条员工数据
     * @param employeeId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "queryEmployeeById")
    @ResponseBody
    Employee queryEmployeeById(
            @RequestParam(value="employeeId")String employeeId
    )throws Exception{
        Employee employee = employeeService.queryEmployeeById(employeeId);
        return employee;
    }

    /**
     * 根据员工id删除
     */
    @RequestMapping(value = "deleteByEmployeeId")
    @ResponseBody
    Response deleteByEmployeeId(
        @RequestParam(value="employeeId")String employeeId
    )throws Exception{
        if(employeeService.deleteByEmployeeId(employeeId)>=1){
            return new Response(ExceptionMsg.SUCCESS);
        }else{
            return new Response(ExceptionMsg.FAILED);
        }
    }

    /**
     * 变更员工职位状态
     */
    @RequestMapping(value = "changeStatus")
    @ResponseBody
    Response changeStatus(
        @RequestParam(value="employeeId")String employeeId,
        @RequestParam(value="status")int status
    )throws Exception{
        if(status == 0){
            status = 1;
        }else if(status == 2){
            status = 0;
        }else{
            return new Response(ExceptionMsg.FAILED);
        }
        Employee employee = new Employee();
        employee.setId(employeeId);
        employee.setStatus(status);
        if(employeeService.changeStatus(employee) >= 1){
            return new Response(ExceptionMsg.SUCCESS);
        }
        return new Response(ExceptionMsg.FAILED);

    }
}
