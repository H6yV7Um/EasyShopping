package com.easy.human.controller;

import com.alibaba.fastjson.JSON;
import com.easy.human.dao.RoleDao;
import com.easy.human.dao.bean.Role;
import com.easy.human.service.RoleService;
import com.easy.human.service.RoleService;
import com.easy.spring.response.MBYResponseViewModel;
import com.easy.spring.response.MBYViewModel;
import com.easy.spring.response.ResponseMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.MediaTypes;

import java.util.Map;

@Controller(value = "RoleController")
@RequestMapping(value = "/api/v1/Role")
public class RoleController {
//    ShopCartDao  dao=new ShopCartDao();

//    @Autowired

    RoleService RoleService =new RoleService();

    @RequestMapping(value = "/list", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel list( ) throws Exception {

        String result= RoleService.list();
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
        return mbyViewModel;
}
    @RequestMapping(value = "/get")
    @ResponseBody
    public MBYViewModel get(@RequestParam Map params) throws Exception  {
        String msg=(String) params.get("msg");

        Role order=  JSON.parseObject(msg, Role.class);
        Role Role  = RoleService.get(order.getId());
        boolean flag=false;
        if (Role!=null){
            flag=true;

        }

        ResponseMsg responseMsg=new ResponseMsg();
        responseMsg.setSuccess(flag);
        if (Role!=null){
            responseMsg.setData(Role);
        }
        String result=JSON.toJSONString(responseMsg);

        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
        return mbyViewModel;
    }
    @RequestMapping(value = "/add")
    @ResponseBody
    public MBYViewModel add(@RequestParam Map params) throws Exception  {
        String msg=(String) params.get("msg");

        String reuslt= RoleService.add(msg);
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
    public String update(@RequestParam Map params) throws Exception  {
        String msg=(String) params.get("msg");
        Role order=  JSON.parseObject(msg, Role.class);
        String result=RoleDao.update(order);

        return result;
    }
    @RequestMapping(value = "/remove")
    @ResponseBody
    public MBYViewModel remove(@RequestParam Map params) throws Exception  {
        String msg=(String) params.get("msg");
        Role Role=  JSON.parseObject(msg, Role.class);
        String result= RoleDao.remove(Role);
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);

        return mbyViewModel;
    }

}