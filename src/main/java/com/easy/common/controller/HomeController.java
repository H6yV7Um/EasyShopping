package com.easy.common.controller;

import com.alibaba.fastjson.JSON;
import com.easy.common.jpush.JpushManger;
import com.easy.order.dao.OrderDao;
import com.easy.order.dao.bean.ShopOrder;
import com.easy.order.service.OrderService;
import com.easy.spring.response.MBYResponseViewModel;
import com.easy.spring.response.MBYViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.MediaTypes;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller(value = "homeController")
public class HomeController {
//    ShopCartDao  dao=new ShopCartDao();

//    @Autowired
    OrderService orderService=new OrderService();

    @RequestMapping(value = "/home")
    public String home( ) throws Exception {


        return "index.html";
}

}