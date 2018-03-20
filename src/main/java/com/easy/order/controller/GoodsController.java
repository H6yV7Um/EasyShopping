package com.easy.order.controller;

import com.alibaba.fastjson.JSON;
import com.easy.common.jpush.JpushManger;
import com.easy.order.dao.OrderDao;
import com.easy.order.dao.bean.Goods;
import com.easy.order.dao.bean.ShopOrder;
import com.easy.order.service.GoodsService;
import com.easy.order.service.OrderService;
import com.easy.spring.response.MBYResponseViewModel;
import com.easy.spring.response.MBYViewModel;
import com.easy.spring.response.MbyRespnseUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.MediaTypes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller(value = "goodsController")
@RequestMapping(value = "/api/v1/goods")
public class GoodsController {
//    ShopCartDao  dao=new ShopCartDao();

//    @Autowired
 GoodsService orderService=new GoodsService();

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
    @RequestMapping(value = "/get" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel get(@RequestParam("msg") String  msg ) throws Exception {

        Goods order=  JSON.parseObject(msg, Goods.class);
        Goods goods  = orderService.get(order.getId());

        return  MbyRespnseUtils.get(goods);
    }
    @RequestMapping(value = "/add" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel add(@RequestParam("msg") String  msg) throws Exception  {

        String reuslt=orderService.add(msg);
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",reuslt);

        return mbyViewModel;
    }
    @RequestMapping(value = "/update" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public String update(@RequestParam("msg") String  msg) throws Exception  {
        ShopOrder order=  JSON.parseObject(msg, ShopOrder.class);
        String result=OrderDao.update(order);

        return result;
    }
    @RequestMapping(value = "/remove" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel remove(@RequestParam("msg") String  msg) throws Exception  {
        ShopOrder order=  JSON.parseObject(msg, ShopOrder.class);
        String result=OrderDao.remove(order);
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);

        return mbyViewModel;
    }
}