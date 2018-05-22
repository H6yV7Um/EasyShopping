package easy.common.controller;

import easy.order.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "homeController")
public class HomeController {
//    ShopCartDao  dao=new ShopCartDao();

//    @Autowired
    OrderService orderService=new OrderService();

    @RequestMapping(value = "/home")
    public String home( ) throws Exception {


        return "index.html";
}

}