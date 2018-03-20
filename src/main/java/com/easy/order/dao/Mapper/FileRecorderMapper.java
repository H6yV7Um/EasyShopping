package com.easy.order.dao.Mapper;

import com.easy.order.dao.bean.FileRecorder;
import com.easy.order.dao.bean.ShopOrder;

import java.util.List;

public interface FileRecorderMapper {
        List<FileRecorder> findAllOrders();
        FileRecorder findOrderById(String id);

        int  add(FileRecorder Order);
        int  delete(String id);
        int update(FileRecorder Order);
        }