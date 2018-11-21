//package com.jyyx.example.springbootdemo.config;
//
//import com.jyyx.example.springbootdemo.entity.base.Permission;
//import com.jyyx.example.springbootdemo.filter.PermissionFilter;
//import com.jyyx.example.springbootdemo.service.base.PermissionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import java.util.HashMap;
//import java.util.List;
//
//@Configuration
//public class PermissionConfig extends WebMvcConfigurerAdapter {
//
//
//    @Autowired
//    public PermissionFilter permissionFilter;
////    public PermissionFilter getPermissionFilter() {
////        return new PermissionFilter();
////    }
//
//    @Autowired
//    private PermissionService permissionService;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
////        try {
////            List<Permission> permissionList = permissionService.queryPermissionList(new HashMap<>());
////            for(Permission p : permissionList){
////                interceptorRegistry.addInterceptor(permissionFilter).addPathPatterns(p.getUri());
////            }
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//        interceptorRegistry.addInterceptor(permissionFilter).addPathPatterns("/Test/test");
//        interceptorRegistry.addInterceptor(permissionFilter).addPathPatterns("/employee/goEmployeeList");
//        interceptorRegistry.addInterceptor(permissionFilter).addPathPatterns("/employee/goMpEmployeeList");
//        interceptorRegistry.addInterceptor(permissionFilter).addPathPatterns("/permission/goPermissionList");
//        interceptorRegistry.addInterceptor(permissionFilter).addPathPatterns("/employeerole/goEmployeeRoleList");
//        interceptorRegistry.addInterceptor(permissionFilter).addPathPatterns("/rolepermission/goRolePermissionList");
//        interceptorRegistry.addInterceptor(permissionFilter).addPathPatterns("/employeerole/goEmployeeRoleList");
//        interceptorRegistry.addInterceptor(permissionFilter).addPathPatterns("/department/goDepartmentList");
//        interceptorRegistry.addInterceptor(permissionFilter).addPathPatterns("/store/goStoreList");
//        super.addInterceptors(interceptorRegistry);
//    }
//}
