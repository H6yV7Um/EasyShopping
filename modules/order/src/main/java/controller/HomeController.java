package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.OrderService;

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