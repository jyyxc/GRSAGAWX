package com.jyyx.example.springbootdemo.controller.weixin;

import com.jyyx.example.springbootdemo.domain.ExceptionMsg;
import com.jyyx.example.springbootdemo.domain.Response;
import com.jyyx.example.springbootdemo.entity.hr.Employee;
import com.jyyx.example.springbootdemo.entity.weixin.base.WxUser;
import com.jyyx.example.springbootdemo.entity.weixin.util.CoreUtil;
import com.jyyx.example.springbootdemo.service.hr.EmployeeService;
import com.jyyx.example.springbootdemo.service.weixin.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping(value="bind")
public class BindController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private WxService wxService;

    @RequestMapping(value = "goBind")
    public String goRoleList(
            HashMap<String,Object> map,
            HttpServletRequest request
    ) throws Exception {
        return "weixin/bind";
    }


    @RequestMapping(value="saveBind")
    @ResponseBody
    Response saveBind(
            @RequestParam(value = "employeeName")String employeeName,
            @RequestParam(value = "telephone")String telephone,
            @RequestParam(value = "idCard")String idCard
    )throws Exception{
        HashMap<String,String> paramSet = new HashMap<>();
        paramSet.put("employeeName",employeeName);
        paramSet.put("telephone",telephone);
        paramSet.put("idCard",idCard);
        paramSet.put("openId",CoreUtil.open_id);
        Employee employee = employeeService.queryEmployeeByBindParam(paramSet);
        if(employee != null){
            //说明员工表里有此人，可以进行绑定
            paramSet.put("employeeId",employee.getId());
            WxUser wxUser = wxService.queryWxUserByParamSet(paramSet);
            if(wxUser != null){
                //说明已经绑定过了
                return new Response(ExceptionMsg.ALREADYBIND);
            }else{
                wxUser = new WxUser();
                wxUser.setOpenId(CoreUtil.open_id);
                wxUser.setIdCard(idCard);
                wxUser.setEmployeeId(employee.getId());
                wxUser.setTelephone(telephone);
                wxUser.setName(employeeName);
                if(wxService.saveBind(wxUser) >= 1)
                    return new Response(ExceptionMsg.SUCCESS);
            }
        }else{
            //说明员工表里无此人，不可以进行绑定
            return new Response(ExceptionMsg.NOEMPLOYEE);
        }
        return new Response(ExceptionMsg.FAILED);
    }

}
