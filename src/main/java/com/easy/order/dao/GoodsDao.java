package com.easy.order.dao;

import com.alibaba.fastjson.JSON;
import com.easy.common.dao.SqlSessionFactoryUtil;
import com.easy.order.dao.Mapper.GoodsMapper;
import com.easy.order.dao.Mapper.OrderMapper;
import com.easy.order.dao.bean.Goods;
import com.easy.order.dao.bean.ShopOrder;
import com.easy.spring.response.ResponseMsg;
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
public class GoodsDao {


    public static  String  add(Goods order) throws IOException {
        boolean flag=false;

        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
        GoodsMapper studentMapper = sqlSession.getMapper(GoodsMapper.class);

//       String id= UUID.randomUUID().toString();
//       order.setId(id);
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
    public static  String  update(Goods order) throws IOException {
        boolean flag=false;
        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
        GoodsMapper studentMapper = sqlSession.getMapper(GoodsMapper.class);

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
    public static  String  remove(Goods order) throws IOException {
        boolean flag=false;
        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
        GoodsMapper studentMapper = sqlSession.getMapper(GoodsMapper.class);

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
    public static  String  list() throws IOException {
        boolean flag=false;

        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();

        GoodsMapper studentMapper = sqlSession.getMapper(GoodsMapper.class);
        List<Goods> userList = studentMapper.findAllGoods();

        // 释放资源
        sqlSession.close();
        flag=true;

        ResponseMsg responseMsg=new ResponseMsg();
        responseMsg.setSuccess(flag);
        responseMsg.setData(userList);
        String result=JSON.toJSONString(responseMsg);
         return  result;
    }
    public static  String  listByStatus(int  status) throws IOException {
        boolean flag=false;

        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();

        GoodsMapper studentMapper = sqlSession.getMapper(GoodsMapper.class);
        List<Goods> userList = studentMapper.listByStatus(status);

        // 释放资源
        sqlSession.close();
        flag=true;

        ResponseMsg responseMsg=new ResponseMsg();
        responseMsg.setSuccess(flag);
        responseMsg.setData(userList);
        String result=JSON.toJSONString(responseMsg);
         return  result;
    }
    public static  Goods  get(String id) throws IOException {
        boolean flag=false;
        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();

        GoodsMapper studentMapper = sqlSession.getMapper(GoodsMapper.class);
        Goods order = studentMapper.get(id);
        // 释放资源
        sqlSession.close();

//        String resultOrde=JSON.toJSONString(com.easy.order);
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
    public static   List<Goods>   search(String key) throws IOException {
        boolean flag=false;
        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
        GoodsMapper studentMapper = sqlSession.getMapper(GoodsMapper.class);

        List<Goods> userList =studentMapper.search(key);
        sqlSession.commit();

        // 释放资源
        sqlSession.close();

        return userList;
//        ResponseMsg responseMsg=new ResponseMsg();
//        responseMsg.setSuccess(flag);
//        String result=JSON.toJSONString(responseMsg);
//        return  result;
    }
}