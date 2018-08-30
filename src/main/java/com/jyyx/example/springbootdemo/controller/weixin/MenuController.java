package com.jyyx.example.springbootdemo.controller.weixin;

import com.jyyx.example.springbootdemo.domain.ExceptionMsg;
import com.jyyx.example.springbootdemo.domain.Response;
import com.jyyx.example.springbootdemo.entity.weixin.menu.Button;
import com.jyyx.example.springbootdemo.entity.weixin.menu.ComplexButton;
import com.jyyx.example.springbootdemo.entity.weixin.menu.ViewButton;
import com.jyyx.example.springbootdemo.entity.weixin.menu.WeixinMenu;
import com.jyyx.example.springbootdemo.entity.weixin.util.TokenUtil;
import com.jyyx.example.springbootdemo.entity.weixin.util.WeixinUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "wxmenu")
public class MenuController {

    /**
     * 创建菜单
     * @author  jyyx
     */

    @RequestMapping(value="createMenu",method = RequestMethod.GET)
    public Response createMenu()throws Exception{
        //如果token对象不为空
        if(null != TokenUtil.accessToken){
            //调用创建菜单接口
            int result = WeixinUtil.createMenu(getMenu());
            //判断菜单创建结果
            if(0 == result){
                return new Response(ExceptionMsg.SUCCESS);
            }else{
                return new Response(ExceptionMsg.FAILED);
            }
        }
        return new Response(ExceptionMsg.FAILED);
    }

    /**
     * 组装菜单数据
     * @author jyyx
     */

    private static WeixinMenu getMenu(){
        ViewButton btn1 = new ViewButton();
        btn1.setName("门店销售");
        btn1.setType("view");
        btn1.setUrl("http://www.asddf.com");

        ViewButton btn2 = new ViewButton();
        btn2.setName("在途数据");
        btn2.setType("view");
        btn2.setUrl("http://www.asddf.com");

        ViewButton btn3 = new ViewButton();
        btn3.setName("库存分析");
        btn3.setType("view");
        btn3.setUrl("http://www.asddf.com");

        ViewButton btn4 = new ViewButton();
        btn4.setName("门店报账");
        btn4.setType("view");
        btn4.setUrl("http://www.asddf.com");

        ViewButton btn5 = new ViewButton();
        btn5.setName("员工管理");
        btn5.setType("view");
        btn5.setUrl("http://store.grsaga.net/employee/goMpEmployeeList");

        ViewButton btn6 = new ViewButton();
        btn6.setName("员工入职");
        btn6.setType("view");
        btn6.setUrl("http://store.grsaga.net/employee/goAddEmployee");

        ViewButton btn7 = new ViewButton();
        btn7.setName("设备状况");
        btn7.setType("view");
        btn7.setUrl("http://www.asddf.com");

        ViewButton btn8 = new ViewButton();
        btn8.setName("知识库");
        btn8.setType("view");
        btn8.setUrl("http://www.asddf.com");

        ViewButton btn9 = new ViewButton();
        btn9.setName("信息反馈");
        btn9.setType("view");
        btn9.setUrl("http://www.asddf.com");

        ViewButton btn10 = new ViewButton();
        btn10.setName("全部应用");
        btn10.setType("view");
        btn10.setUrl("http://store.grsaga.net/center/goCenter");

        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("基础报表");
        mainBtn1.setSub_button(new Button[]{btn1,btn2,btn3});

        ComplexButton mainBtn2 = new ComplexButton();
        mainBtn2.setName("数据维护");
        mainBtn2.setSub_button(new Button[]{btn4,btn5,btn6});

        ComplexButton mainBtn3 = new ComplexButton();
        mainBtn3.setName("运维专用");
        mainBtn3.setSub_button(new Button[]{btn10,btn7,btn8,btn9});

        WeixinMenu menu = new WeixinMenu();
        menu.setButton(new Button[]{mainBtn1,mainBtn2,mainBtn3});
        return menu;
    }


}
