package com.easy.human.dao;

import com.alibaba.fastjson.JSON;
import com.easy.common.dao.SqlSessionFactoryUtil;
import com.easy.human.dao.bean.Role;
import com.easy.human.dao.mapper.RoleMapper;
import com.easy.spring.response.ResponseMsg;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

/**
 *
 * Title: RoleDao
 *
 * @author chenxiaochan
 */
public class RoleDao {


    public static  boolean  add(Role Role) throws IOException {
        boolean flag=false;

        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
        RoleMapper studentMapper = sqlSession.getMapper(RoleMapper.class);

//       String id= UUID.randomUUID().toString();
//       Role.setId(id);
        int count=studentMapper.add(Role);
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
        String msg="添加成功";
          if (count>0){
            flag=true;
        }else{
              msg="添加失败";
          }
//        ResponseMsg responseMsg=new ResponseMsg();
//        responseMsg.setSuccess(flag);
//        responseMsg.setMsg(msg);
//        String result= JSON.toJSONString(responseMsg);

        return  flag;
    }
    public static  String  update(Role Role) throws IOException {
        boolean flag=false;
        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
        RoleMapper studentMapper = sqlSession.getMapper(RoleMapper.class);

        int count=studentMapper.update(Role);
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
    public static  String  remove(Role Role) throws IOException {
        boolean flag=false;
        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
        RoleMapper studentMapper = sqlSession.getMapper(RoleMapper.class);

        int count=studentMapper.delete(Role.getId());
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

        RoleMapper studentMapper = sqlSession.getMapper(RoleMapper.class);
        List<Role> RoleList = studentMapper.list();
//        for (Role Role:RoleList ) {
//            if (StringUtils.isNotEmpty(Role.getImageName())){
//                Role.setImagUrl(ServiceUtils.URL+"?type=2&"+"name="+Role.getImageName());
//            }
//        }
        // 释放资源
        sqlSession.close();
        flag=true;

        ResponseMsg responseMsg=new ResponseMsg();
        responseMsg.setSuccess(flag);
        responseMsg.setData(RoleList);
        String result=JSON.toJSONString(responseMsg);
         return  result;
    }
    public static  Role  get(String id) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();

        RoleMapper studentMapper = sqlSession.getMapper(RoleMapper.class);
        Role Role = studentMapper.get(id);
        // 释放资源
        sqlSession.close();

//        String resultOrde=JSON.toJSONString(com.easy.Role);

         return  Role;
    }


}