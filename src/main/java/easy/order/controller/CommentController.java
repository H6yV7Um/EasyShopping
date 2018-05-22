package easy.order.controller;

import com.alibaba.fastjson.JSON;
import easy.order.dao.GoodsDao;
import easy.order.dao.OrderDao;
import easy.order.dao.bean.Comment;
import easy.order.dao.bean.Goods;
import easy.order.dao.bean.ShopOrder;
import easy.order.service.CommentService;
import easy.spring.response.MBYResponseViewModel;
import easy.spring.response.MBYViewModel;
import easy.spring.response.MbyRespnseUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.MediaTypes;

import java.util.List;
import java.util.Map;

@Controller(value = "commentController")
@RequestMapping(value = "/api/v1/comment")
public class CommentController {
//    ShopCartDao  dao=new ShopCartDao();

//    @Autowired
CommentService commentService =new CommentService();

    @RequestMapping(value = "/list", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel list( ) throws Exception {

        String result= commentService.list();
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
        return mbyViewModel;
}
    @RequestMapping(value = "/getOrderedList", produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel getOrderedList( ) throws Exception {

        String result= commentService.getOrderedList();
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);
        return mbyViewModel;
}
    @RequestMapping(value = "/get" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel get(@RequestParam("msg") String  msg ) throws Exception {

        Comment order=  JSON.parseObject(msg, Comment.class);
        Comment goods  = commentService.get(order.getId());

        return  MbyRespnseUtils.get(goods);
    }
    @RequestMapping(value = "/add" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel add(@RequestParam("msg") String  msg) throws Exception  {

        String reuslt= commentService.add(msg);
//        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",reuslt);

        return MbyRespnseUtils.get(reuslt);
    }
    @RequestMapping(value = "/update" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public String update(@RequestParam("msg") String  msg) throws Exception  {
        ShopOrder order=  JSON.parseObject(msg, ShopOrder.class);
        String result=OrderDao.update(order);

        return result;
    }
    @RequestMapping(value = "/remove" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel remove(@RequestParam Map params) throws Exception  {
        String msg=(String) params.get("msg");

        Comment order=  JSON.parseObject(msg, Comment.class);
        String result=CommentService.remove(order);
        MBYViewModel mbyViewModel=new MBYResponseViewModel("200",result);

        return mbyViewModel;
    }
    @RequestMapping(value = "/search" ,produces = MediaTypes.JSON_UTF_8)
    @ResponseBody
    public MBYViewModel search (@RequestParam Map params) throws Exception  {
          String msg=(String) params.get("msg");
        List<Goods> goodsList= GoodsDao.search(msg);
//        List<Goods> goodsList= GoodsDao.search(order.getName());

        return MbyRespnseUtils.get(goodsList);
    }
}