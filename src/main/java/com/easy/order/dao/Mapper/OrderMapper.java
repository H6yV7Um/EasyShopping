package com.easy.order.dao.Mapper;

import com.easy.human.dao.bean.User;
import com.easy.order.dao.bean.ShopOrder;
import com.easy.order.dao.bean.ShopRecorder;

import java.util.List;

public interface OrderMapper {
        List<ShopOrder> findAllOrders();
        List<ShopRecorder> listByStatus(int  status);
        List<ShopRecorder> getMyOrder(String userId);
        ShopOrder findOrderById(String id);

        int  add(ShopOrder Order);
        int  delete(String id);
        int update(ShopOrder Order);
        }