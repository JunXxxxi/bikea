package xyz.bikea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.bikea.mapper.OrderMapper;
import xyz.bikea.pojo.Order;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderMapper orderMapper;
    @RequestMapping("order2.html")
    public String order(Model model){
        List<Order> orderList = orderMapper.queryOrderList();
        List<Integer> numOrder = orderMapper.queryNumOrder();
        List<Integer> income = orderMapper.queryIncome();
        model.addAttribute("orderList",orderList);
        model.addAttribute("numO",numOrder);
        model.addAttribute("income",income);
        return "order2";
    }
}
