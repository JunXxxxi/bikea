package xyz.bikea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.bikea.mapper.OrderMapper;
import xyz.bikea.pojo.Order;
import xyz.bikea.service.RedisService;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderMapper orderMapper;
    @Resource
    private RedisService redisService;

    @RequestMapping("order2.html")
    public String order(Model model){
        List<Order> orderList = (List<Order>) redisService.get("orderList");
        if (orderList == null){
            orderList = orderMapper.queryOrderList();
            redisService.set("orderList",orderList,600);
        }
        List<Integer> numOrder = (List<Integer>) redisService.get("numOrder");
        if (numOrder == null){
            numOrder = orderMapper.queryNumOrder();
            redisService.set("numOrder",numOrder,600);
        }
        List<Integer> income = (List<Integer>) redisService.get("income");
        if (income == null){
            income = orderMapper.queryIncome();
            redisService.set("income",income,600);
        }

        model.addAttribute("orderList",orderList);
        model.addAttribute("numO",numOrder);
        model.addAttribute("income",income);
        return "order2";
    }

    @RequestMapping("order22.html")
    public String order2(Model model){
        List<Order> orderList = (List<Order>) redisService.get("orderList2");
        if (orderList == null){
            orderList = orderMapper.queryOrderList2();
            redisService.set("orderList2",orderList,600);
        }
        List<Integer> numOrder = (List<Integer>) redisService.get("numOrder2");
        if (numOrder == null){
            numOrder = orderMapper.queryNumOrder2();
            redisService.set("numOrder2",numOrder,600);
        }
        List<Integer> income = (List<Integer>) redisService.get("income2");
        if (income == null){
            income = orderMapper.queryIncome2();
            redisService.set("income2",income,600);
        }
        model.addAttribute("orderList2",orderList);
        model.addAttribute("numO2",numOrder);
        model.addAttribute("income2",income);
        return "order22";
    }
}
