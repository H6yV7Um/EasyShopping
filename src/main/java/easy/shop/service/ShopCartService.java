package easy.shop.service;

import com.alibaba.fastjson.JSON;
import easy.shop.dao.ShopCartDao;
import easy.shop.dao.bean.ShopCart;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
public class ShopCartService {

    public String add( String  msg) throws Exception  {
        ShopCart order=  JSON.parseObject(msg, ShopCart.class);
        String id= UUID.randomUUID().toString();
        order.setId(id);
        ShopCartDao.add(order);

        return order.getId();
    }
    public  String list()throws Exception  {
       String data= ShopCartDao.list();
        return data;
    }
    public  String getOrderedList()throws Exception  {
       String data= ShopCartDao.listByStatus(3);
        return data;
    }

    public String get(String id) throws IOException {
        ShopCartDao dao=new ShopCartDao();
        return  dao.get(id);
    }
}
