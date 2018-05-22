package easy.order.dao;

import com.alibaba.fastjson.JSON;
import easy.common.dao.SqlSessionFactoryUtil;
import easy.human.dao.bean.User;
import easy.order.dao.Mapper.OrderMapper;
import easy.order.dao.bean.ShopRecorder;
import easy.spring.response.ResponseMsg;
import easy.order.dao.bean.ShopOrder;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * Title: ShopCartDao
 *
 * @author chenxiaochan
 */
public class OrderDao {


    public static  String  add(ShopOrder order) throws IOException {
        boolean flag=false;

        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
        OrderMapper studentMapper = sqlSession.getMapper(OrderMapper.class);

//       String id= UUID.randomUUID().toString();
//       order.setId(id);
//        TimeUtil.get
        order.setCreateTime(new Timestamp(System.currentTimeMillis())+"");

        int count=studentMapper.add(order);
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
        String msg="添加成功";
          if (count>0){
            flag=true;
        }else{
              msg="添加失败";
          }
        ResponseMsg responseMsg=new ResponseMsg();
        responseMsg.setSuccess(flag);
        responseMsg.setMsg(msg);
        String result= JSON.toJSONString(responseMsg);

        return  result;
    }
    public static  String  update(ShopOrder order) throws IOException {
        boolean flag=false;
        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
        OrderMapper studentMapper = sqlSession.getMapper(OrderMapper.class);

        int count=studentMapper.update(order);
        sqlSession.commit();

        // 释放资源
        sqlSession.close();
        if (count>0){
            flag=true;
        }

        ResponseMsg responseMsg=new ResponseMsg();
        responseMsg.setSuccess(flag);
        String result=JSON.toJSONString(responseMsg);

        return  result;
    }
    public static  String  remove(ShopOrder order) throws IOException {
        boolean flag=false;
        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
        OrderMapper studentMapper = sqlSession.getMapper(OrderMapper.class);

        int count=studentMapper.delete(order.getId());
        sqlSession.commit();

        // 释放资源
        sqlSession.close();
        if (count>0){
            flag=true;
        }

        ResponseMsg responseMsg=new ResponseMsg();
        responseMsg.setSuccess(flag);
        String result=JSON.toJSONString(responseMsg);
        return  result;
    }
    public static  List<ShopOrder>  list() throws IOException {
        boolean flag=false;

        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();

        OrderMapper studentMapper = sqlSession.getMapper(OrderMapper.class);
        List<ShopOrder> userList = studentMapper.findAllOrders();

        // 释放资源
        sqlSession.close();
        flag=true;

//        ResponseMsg responseMsg=new ResponseMsg();
//        responseMsg.setSuccess(flag);
//        responseMsg.setData(userList);
//        String result=JSON.toJSONString(responseMsg);
         return  userList;
    }
    public static  List<ShopRecorder>  listByStatus(int  status) throws IOException {
        boolean flag=false;

        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();

        OrderMapper studentMapper = sqlSession.getMapper(OrderMapper.class);
        List<ShopRecorder> userList = studentMapper.listByStatus(status);

        // 释放资源
        sqlSession.close();

         return  userList;
    }

    public static  List<ShopRecorder>  getMyOrder( User user) throws IOException {
        boolean flag=false;

        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();

        OrderMapper studentMapper = sqlSession.getMapper(OrderMapper.class);
        String id=user.getId();
        List<ShopRecorder> orderList = studentMapper.getPayList(id);
//        List<ShopRecorder> userList =new ArrayList<ShopRecorder>();

        // 释放资源
        sqlSession.close();

         return  orderList;
    }
    public static  ShopOrder  get(String id) throws IOException {
        boolean flag=false;
        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();

        OrderMapper studentMapper = sqlSession.getMapper(OrderMapper.class);
        ShopOrder order = studentMapper.findOrderById(id);
        // 释放资源
        sqlSession.close();

//        String resultOrde=JSON.toJSONString(easy.order);
//        if (order!=null){
//            flag=true;
//
//        }
//
//        ResponseMsg responseMsg=new ResponseMsg();
//        responseMsg.setSuccess(flag);
//        if (order!=null){
//            responseMsg.setData(order);
//
//        }
//        String result=JSON.toJSONString(responseMsg);

         return  order;
    }
}