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
    public String lateorder(Model model) {
        model.addAttribute("message", "Введите номер заказа:");
        return "lateorder";
    }

    @RequestMapping(value = "/lateorder", method = RequestMethod.POST)
    public String lateorderAdd(@RequestParam String ordernumber, Model model) {
        int id = Integer.parseInt(ordernumber.replace("-", ""));
        try {
            orderService.addLateOrder(id);
        } catch (Exception e) {
            model.addAttribute("message", "Вы ввели неверный номер заказа!");
            return "lateorder";
        }
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
