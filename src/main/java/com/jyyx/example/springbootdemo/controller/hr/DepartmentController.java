package com.jyyx.example.springbootdemo.controller.hr;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyyx.example.springbootdemo.domain.ExceptionMsg;
import com.jyyx.example.springbootdemo.domain.Response;
import com.jyyx.example.springbootdemo.entity.hr.Department;
import com.jyyx.example.springbootdemo.entity.hr.Store;
import com.jyyx.example.springbootdemo.entity.weixin.util.CoreUtil;
import com.jyyx.example.springbootdemo.service.BasePermissionService;
import com.jyyx.example.springbootdemo.service.hr.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value="department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private BasePermissionService basePermissionService;
    /**
     * 拿到部门下拉框数据
     */
    @RequestMapping(value="getDepartmentList")
    @ResponseBody
    List<Department> getDepartmentList()throws Exception{
        List<Department> departmentList = departmentService.queryDepartmentList(new HashMap<>());
        return departmentList;
    }

    @RequestMapping(value = "goDepartmentList")
    public String goDepartmentList(
            HashMap<String,Object> map,
            HttpServletRequest request,
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "keyword",defaultValue = "")String keyword
    ) throws Exception {
        //定义查询参数map
        HashMap<String,Object> paramSet = new HashMap<>();
        paramSet.put("page",page);
        paramSet.put("keyword",keyword);
        //拿到访问路径uri
        String uri = request.getRequestURI();
        //拿到权限返回的map集合
        HashMap<String,Object> resultMap = basePermissionService.queryPermissionByOpenId(CoreUtil.open_id,uri);
        //如果flag==true  返回yes  否则返回no
        String flag = (Boolean)resultMap.get("urlPermission") ? "yes" : "no";
        String doPermission = resultMap.get("doPermission").toString();
        //开始分页
        PageHelper.startPage(page,10);
        //员工数据
        List<Department> departmentList = departmentService.queryDepartmentList(paramSet);
        PageInfo<Department> p = new PageInfo<Department>(departmentList);
        //分页
        map.put("page",p);
        //访问权限
        map.put("permission",flag);
        //操作权限
        map.put("doPermission",doPermission);
        map.put("departmentList",departmentList);
        return "hr/department";
    }


    /**
     * 保存新增或修改
     * @param departmentid
     * @param departmentName
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "saveDepartment")
    @ResponseBody
    public Response saveDepartment(
            @RequestParam(value ="departmentid")String departmentid,
            @RequestParam(value = "departmentName")String departmentName
    )throws Exception{
        Department department = new Department();
        department.setId(departmentid);
        department.setDepartmentName(departmentName);
        if(departmentService.addOrEditDepartment(department) >= 1){
            return new Response(ExceptionMsg.SUCCESS);
        }
        return new Response(ExceptionMsg.FAILED);
    }

    /**
     * 根据id查出单条部门数据
     * @param departmentId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "queryDepartmentById")
    @ResponseBody
    Department queryDepartmentById(
            @RequestParam(value="departmentId")String departmentId
    )throws Exception{
        Department department = departmentService.queryDepartmentById(departmentId);
        return department;
    }

    /**
     * 根据角色id删除
     */
    @RequestMapping(value = "deleteByDepartmentId")
    @ResponseBody
    Response deleteByDepartmentId(
            @RequestParam(value="departmentId")String departmentId
    )throws Exception{
        if(departmentService.deleteById(departmentId) >= 1){
            return new Response(ExceptionMsg.SUCCESS);
        }else{
            return new Response(ExceptionMsg.FAILED);
        }
    }
}
