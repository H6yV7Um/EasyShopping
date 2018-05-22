package easy.order.dao.Mapper;

import easy.order.dao.bean.ShopOrder;
import easy.order.dao.bean.ShopRecorder;

import java.util.List;

public interface OrderMapper {
        List<ShopOrder> findAllOrders();
        List<ShopRecorder> listByStatus(int  status);
        List<ShopRecorder> getPayList(String id);
        ShopOrder findOrderById(String id);

        int  add(ShopOrder Order);
        int  delete(String id);
        int update(ShopOrder Order);
        }