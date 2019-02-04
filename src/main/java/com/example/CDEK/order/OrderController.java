package com.example.CDEK.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/lateorder", method = RequestMethod.GET)
    public String lateorder() {
        return "lateorder";
    }

    @RequestMapping(value = "/lateorder", method = RequestMethod.POST)
    public String lateorderAdd(@RequestParam String ordernumber) {
        int id = Integer.parseInt(ordernumber.replace("-", ""));
        orderService.addLateOrder(id);
        return "redirect:/lateorder";
    }

    @RequestMapping("/callcenter")
    public String callcenter(Model model) {
        model.addAttribute("orders", orderService.getAllLateOrders());
        return "callcenter";
    }

    @RequestMapping(value = "/callcenter", method = RequestMethod.POST)
    public String callcenterSearch(@RequestParam String search, Model model) {
        if (search.isEmpty()) return callcenter(model);
        int n = Integer.parseInt(search);
        Object[] orders =  orderService.getAllLateOrders().stream().filter(order -> order.getId() == n).toArray();
        model.addAttribute("orders", orders);
        return "callcenter";
    }
}
