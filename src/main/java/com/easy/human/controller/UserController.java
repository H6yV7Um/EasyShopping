package com.easy.human.controller;

import com.alibaba.fastjson.JSON;
import com.easy.human.dao.UserDao;
import com.easy.human.dao.bean.User;
import com.easy.human.service.UserService;
import com.easy.spring.response.MbyRespnseUtils;
import com.easy.spring.response.ResponseMsg;
import com.easy.spring.response.MBYResponseViewModel;
import com.easy.spring.response.MBYViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.MediaTypes;

@Controller(value = "userController")
@RequestMapping(value = "/api/v1/user")
public class UserController {
//    ShopCartDao  dao=new ShopCartDao();

//    @Autowired

    UserService userService =new UserService();

    @RequestMapping(value = "/login" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel login(  @RequestParam("msg") String  msg) throws Exception  {
        User order=  JSON.parseObject(msg, User.class);
        ResponseMsg responseMsg=  userService.login(order);
//        ResponseMsg responseMsg=new ResponseMsg();
//        responseMsg.setSuccess(isExit);
        String result=JSON.toJSONString(responseMsg);

        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);

        return mbyViewModel;
    }
    @RequestMapping(value = "/list", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel list( ) throws Exception {

        String result= userService.list();
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
        return mbyViewModel;
}
    @RequestMapping(value = "/get" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel get(@RequestParam("msg") String  msg ) throws Exception {

        User order=  JSON.parseObject(msg, User.class);
        User user  = userService.get(order.getId());
        boolean flag=false;
        if (user!=null){
            flag=true;

        }

        ResponseMsg responseMsg=new ResponseMsg();
        responseMsg.setSuccess(flag);
        if (user!=null){
            responseMsg.setData(user);
        }
        String result=JSON.toJSONString(responseMsg);

        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
        return mbyViewModel;
    }
    @RequestMapping(value = "/add" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel add(@RequestParam("msg") String  msg) throws Exception  {

        String reuslt= userService.add(msg);
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",reuslt);
//        Map<String, String> parm=new HashMap<String, String>();
//        parm.put("msg","有新的订单");
//
//        Collection<String> aliases=new ArrayList<String>();
//        aliases.add("ldh");
//        JpushManger.jpushAndroid(parm,true,aliases);
        return mbyViewModel;
    }
    @RequestMapping(value = "/register" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel register(@RequestParam("msg") String  msg) throws Exception  {

        boolean isExit= userService.register(msg);



        return MbyRespnseUtils.get(isExit);
    }
    @RequestMapping(value = "/update" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public String update(@RequestParam("msg") String  msg) throws Exception  {
        User order=  JSON.parseObject(msg, User.class);
        String result=UserDao.update(order);

        return result;
    }
    @RequestMapping(value = "/remove" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel remove(@RequestParam("msg") String  msg) throws Exception  {
        User user=  JSON.parseObject(msg, User.class);
        String result= UserDao.remove(user);
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);

        return mbyViewModel;
    }
    @RequestMapping(value = "/checkUserExit" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel checkUserExit(@RequestParam("msg") String  msg) throws Exception  {
        User order=  JSON.parseObject(msg, User.class);
         boolean isExit=  userService.checkUserExit(order);

        return MbyRespnseUtils.get("",isExit);
    }
}