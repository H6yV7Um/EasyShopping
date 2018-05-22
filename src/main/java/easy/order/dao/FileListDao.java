package easy.order.dao;

import com.alibaba.fastjson.JSON;
import easy.common.dao.SqlSessionFactoryUtil;
import easy.order.dao.Mapper.FileRecorderMapper;
import easy.order.dao.bean.FileRecorder;
import easy.spring.response.ResponseMsg;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class FileListDao {
    public static  String  add(FileRecorder order) throws IOException {
        boolean flag=false;

        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
        FileRecorderMapper studentMapper = sqlSession.getMapper(FileRecorderMapper.class);

//        String id= UUID.randomUUID().toString();
//        order.setId(id);

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
    public static  String  update(FileRecorder order) throws IOException {
        boolean flag=false;
        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
        FileRecorderMapper studentMapper = sqlSession.getMapper(FileRecorderMapper.class);

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

    public static FileRecorder getFileRecorderById(String id){
        SqlSession sqlSession = SqlSessionFactoryUtil.getSession();

        FileRecorderMapper studentMapper = sqlSession.getMapper(FileRecorderMapper.class);
        FileRecorder order = studentMapper.findOrderById(id);
        // 释放资源
        sqlSession.close();
        return order;
    }
    public static  String  get(String id) throws IOException {
        boolean flag=false;

        FileRecorder order =getFileRecorderById(id);
        if (order!=null){
            flag=true;
        }
        ResponseMsg responseMsg=new ResponseMsg();
        responseMsg.setSuccess(flag);
        if (order!=null){
            responseMsg.setData(order);
        }
        String result=JSON.toJSONString(responseMsg);
        return  result;
    }
}
