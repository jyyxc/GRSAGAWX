package com.jyyx.example.springbootdemo.filter;

import com.jyyx.example.springbootdemo.entity.weixin.util.CoreUtil;
import com.jyyx.example.springbootdemo.service.BasePermissionService;
import com.jyyx.example.springbootdemo.service.base.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 *过滤器 用以实现权限逻辑
 * @author jyyx
 */
@Service
public class PermissionFilter extends HandlerInterceptorAdapter {

    @Autowired
    private RolePermissionService rolePermissionService;

    @Autowired
    private BasePermissionService basePermissionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取拦截的方法地址
        String uri = request.getRequestURI();

        HashMap<String,Object> resultMap = basePermissionService.queryPermissionByOpenId(CoreUtil.open_id,uri);
        //如果flag==true  返回yes  否则返回no
        Boolean flag = (Boolean)resultMap.get("urlPermission");

            if(flag) {
                return flag;
            }else{
//                response.sendRedirect("/error/noPermission");
                request.getRequestDispatcher("/error/noPermission").forward(request,response);

                return true;
            }
    }
}


