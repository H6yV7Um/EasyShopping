package com.easy.order.service;

import com.alibaba.fastjson.JSON;
import com.easy.order.dao.FileListDao;
import com.easy.order.dao.GoodsDao;
import com.easy.order.dao.OrderDao;
import com.easy.order.dao.bean.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    public String add( String  msg) throws Exception  {
        ShopOrderMsg orderMsg=  JSON.parseObject(msg, ShopOrderMsg.class);

        ShopOrder order=  JSON.parseObject(orderMsg.getOrder(), ShopOrder.class);
        String id= UUID.randomUUID().toString();
        order.setId(id);

        OrderDao.add(order);
              Goods goods=  JSON.parseObject(orderMsg.getGoods(), Goods.class);
              String goodsId= UUID.randomUUID().toString();
              goods.setId(goodsId);
              GoodsDao.add(goods);
              order.setGoodsId(goodsId);
        if (order.getType()==1) {
            order.setStatus(3);
        }
              OrderDao.update(order);

              FileRecorder fileRecorder=FileListDao.getFileRecorderById(goods.getImageId());
              fileRecorder.setRefId(goods.getId());
              FileListDao.update(fileRecorder);



        return order.getId();
    }
    public   List<ShopOrder> list()throws Exception  {
        List<ShopOrder> userList = OrderDao.list();

        return userList;
    }
    public void  payOrder(String id)throws Exception  {
        ShopOrder order=OrderDao.get(id);
        order.setStatus(3);
        OrderDao.update(order);
    }
    public   List<ShopRecorder> getOrderedList()throws Exception  {
        List<ShopRecorder> orders= OrderDao.listByStatus(3);
        return orders;
    }

    public ShopOrderMsg get(String id) throws IOException {
        OrderDao  dao=new OrderDao();

        ShopOrder order= dao.get(id);

         Goods goods= GoodsDao.get(order.getGoodsId());

        ShopOrderMsg msg=new ShopOrderMsg();
        msg.setOrder(JSON.toJSONString(order));
        msg.setGoods(JSON.toJSONString(goods));

        return  msg;
    }
}
