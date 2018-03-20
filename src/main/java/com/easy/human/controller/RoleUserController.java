package com.easy.human.controller;

import com.alibaba.fastjson.JSON;
import com.easy.human.dao.RoleUserDao;
import com.easy.human.dao.bean.RoleUser;
import com.easy.human.service.RoleUserService;
import com.easy.spring.response.MBYResponseViewModel;
import com.easy.spring.response.MBYViewModel;
import com.easy.spring.response.ResponseMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.MediaTypes;

@Controller(value = "RoleUserController")
@RequestMapping(value = "/api/v1/RoleUser")
public class RoleUserController {
//    ShopCartDao  dao=new ShopCartDao();

//    @Autowired

    RoleUserService RoleUserService =new RoleUserService();

    @RequestMapping(value = "/list", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel list( ) throws Exception {

        String result= RoleUserService.list();
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
        return mbyViewModel;
}
    @RequestMapping(value = "/get")
    @ResponseBody
    public MBYViewModel get(@RequestParam("msg") String  msg ) throws Exception {

        RoleUser order=  JSON.parseObject(msg, RoleUser.class);
        RoleUser RoleUser  = RoleUserService.get(order.getId());
        boolean flag=false;
        if (RoleUser!=null){
            flag=true;

        }

        ResponseMsg responseMsg=new ResponseMsg();
        responseMsg.setSuccess(flag);
        if (RoleUser!=null){
            responseMsg.setData(RoleUser);
        }
        String result=JSON.toJSONString(responseMsg);

        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
        return mbyViewModel;
    }
    @RequestMapping(value = "/add")
    @ResponseBody
    public MBYViewModel add(@RequestParam("msg") String  msg) throws Exception  {

        String reuslt= RoleUserService.add(msg);
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",reuslt);
//        Map<String, String> parm=new HashMap<String, String>();
//        parm.put("msg","有新的订单");
//
//        Collection<String> aliases=new ArrayList<String>();
//        aliases.add("ldh");
//        JpushManger.jpushAndroid(parm,true,aliases);
        return mbyViewModel;
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public String update(@RequestParam("msg") String  msg) throws Exception  {
        RoleUser order=  JSON.parseObject(msg, RoleUser.class);
        String result=RoleUserDao.update(order);

        return result;
    }
    @RequestMapping(value = "/remove")
    @ResponseBody
    public MBYViewModel remove(@RequestParam("msg") String  msg) throws Exception  {
        RoleUser RoleUser=  JSON.parseObject(msg, RoleUser.class);
        String result= RoleUserDao.remove(RoleUser);
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);

        return mbyViewModel;
    }

}