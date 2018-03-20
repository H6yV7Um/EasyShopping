package com.easy.shop.controller;

import com.alibaba.fastjson.JSON;
import com.easy.common.jpush.JpushManger;
import com.easy.shop.dao.ShopCartDao;
import com.easy.shop.dao.bean.ShopCart;
import com.easy.shop.service.ShopCartService;
import com.easy.spring.response.MBYResponseViewModel;
import com.easy.spring.response.MBYViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.MediaTypes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller(value = "shopCartController")
@RequestMapping(value = "/api/v1/shopCart")
public class ShopCartController {
//    ShopCartDao  dao=new ShopCartDao();

//    @Autowired
    ShopCartService orderService=new ShopCartService();

    @RequestMapping(value = "/list", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel list( ) throws Exception {

        String result=orderService.list();
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
        return mbyViewModel;
}
    @RequestMapping(value = "/getOrderedList", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel getOrderedList( ) throws Exception {

        String result=orderService.getOrderedList();
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
        return mbyViewModel;
}
    @RequestMapping(value = "/get")
    @ResponseBody
    public MBYViewModel get(@RequestParam("msg") String  msg ) throws Exception {

        ShopCart order=  JSON.parseObject(msg, ShopCart.class);
        String result  = orderService.get(order.getId());
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
        return mbyViewModel;
    }
    @RequestMapping(value = "/add")
    @ResponseBody
    public MBYViewModel add(@RequestParam("msg") String  msg) throws Exception  {

        String reuslt=orderService.add(msg);
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",reuslt);

        return mbyViewModel;
    }
    @RequestMapping(value = "/update")
    @ResponseBody
    public String update(@RequestParam("msg") String  msg) throws Exception  {
        ShopCart order=  JSON.parseObject(msg, ShopCart.class);
        String result= ShopCartDao.update(order);

        return result;
    }
    @RequestMapping(value = "/remove")
    @ResponseBody
    public MBYViewModel remove(@RequestParam("msg") String  msg) throws Exception  {
        ShopCart order=  JSON.parseObject(msg, ShopCart.class);
        String result= ShopCartDao.remove(order);
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);

        return mbyViewModel;
    }
    @RequestMapping(value = "/pay")
    @ResponseBody
    public MBYViewModel pay(@RequestParam("msg") String  msg) throws Exception  {
        ShopCart order=  JSON.parseObject(msg, ShopCart.class);
        String result= ShopCartDao.remove(order);
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);

        return mbyViewModel;
    }

}