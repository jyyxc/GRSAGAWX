package com.jyyx.example.springbootdemo.controller.hr;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyyx.example.springbootdemo.domain.ExceptionMsg;
import com.jyyx.example.springbootdemo.domain.Response;
import com.jyyx.example.springbootdemo.entity.base.Role;
import com.jyyx.example.springbootdemo.entity.hr.Store;
import com.jyyx.example.springbootdemo.entity.weixin.util.CoreUtil;
import com.jyyx.example.springbootdemo.service.BasePermissionService;
import com.jyyx.example.springbootdemo.service.hr.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "store")
public class StoreController {


    @Autowired
    private BasePermissionService basePermissionService;

    @Autowired
    private StoreService storeService;

    @RequestMapping(value = "goStoreList")
    public String goStoreList(
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
        List<Store> storeList = storeService.queryStoreList(paramSet);
        PageInfo<Store> p = new PageInfo<Store>(storeList);
        //分页
        map.put("page",p);
        //访问权限
        map.put("permission",flag);
        //操作权限
        map.put("doPermission",doPermission);
        map.put("storeList",storeList);
        return "hr/store";
    }

    @RequestMapping(value="/getStoreList")
    @ResponseBody
    List<Store> getStoreList(
            @RequestParam(value="keyword")String keyword
    ) throws Exception{
        HashMap<String,Object> paramSet = new HashMap<>();
        paramSet.put("keyword",keyword);
        return   storeService.queryStoreList(paramSet);
    }


    @RequestMapping(value = "goMpStoreList")
    public String goMpStoreList(
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
        return "mp/store";
    }



    /**
     * 保存新增或修改
     * @param storeId
     * @param storeName
     * @param storeAddress
     * @param storeType
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "saveStore")
    @ResponseBody
    public Response saveStore(
            @RequestParam(value ="storeId",defaultValue = "" )String storeId,
            @RequestParam(value = "storeName")String storeName,
            @RequestParam(value = "storeAddress")String storeAddress,
            @RequestParam(value = "storeType")int storeType
    )throws Exception{
        Store store = new Store();
        store.setId(storeId);
        store.setStoreName(storeName);
        store.setStoreAddress(storeAddress);
        store.setStoreType(storeType);
        if(storeService.addOrEditStore(store) >= 1){
            return new Response(ExceptionMsg.SUCCESS);
        }
        return new Response(ExceptionMsg.FAILED);
    }

    @RequestMapping(value = "goAddStore")
    public String goAddStore(
            HttpServletRequest request,
            HashMap<String,Object> map) throws Exception {
        //拿到访问路径uri
        String uri = request.getRequestURI();
        //拿到权限返回的map集合
        HashMap<String,Object> resultMap = basePermissionService.queryPermissionByOpenId(CoreUtil.open_id,uri);
        //如果flag==true  返回yes  否则返回no
        String flag = (Boolean)resultMap.get("urlPermission") ? "yes" : "no";
        String doPermission = resultMap.get("doPermission").toString();
        return "mp/addstore";
    }


    /**
     * 根据id查出单条门店数据
     * @param storeId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "queryStoreById")
    @ResponseBody
    Store queryStoreById(
            @RequestParam(value="storeId")String storeId
    )throws Exception{
        Store store = storeService.queryStoreById(storeId);
        return store;
    }

    /**
     * 根据角色id删除
     */
    @RequestMapping(value = "deleteByStoreId")
    @ResponseBody
    Response deleteByStoreId(
            @RequestParam(value="storeId")String storeId
    )throws Exception{
        if(storeService.deleteById(storeId) >= 1){
            return new Response(ExceptionMsg.SUCCESS);
        }else{
            return new Response(ExceptionMsg.FAILED);
        }
    }
}
