package com.easy.order.dao.Mapper;

import com.easy.order.dao.bean.Goods;
import com.easy.order.dao.bean.ShopOrder;

import java.util.List;

public interface GoodsMapper {
        List<Goods> findAllGoods();
        List<Goods> listByStatus(int status);
        Goods get(String id);

        int  add(Goods Order);
        int  delete(String id);
        int update(Goods Order);
        }