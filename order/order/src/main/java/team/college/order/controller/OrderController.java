package team.college.order.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import team.college.order.model.Order;
import team.college.order.service.OrderServiceImp;

@RestController
@RequestMapping("/order")
public class OrderController {

        @Autowired
        private OrderServiceImp orderServiceImp;

        @PostMapping("/add")
        public void addOrder(@RequestBody Order order) {
                orderServiceImp.addOrder(order);
        }

        @PostMapping("/update")
        public void updateOrder(@RequestBody Order order) {
                orderServiceImp.updateOrder(order);
        }
        
        @GetMapping("/remove")
        public void removeOrder(@RequestParam Integer order_id) {
                orderServiceImp.removeOrder(order_id);
        }
        
        @GetMapping("/get")
        public Order getOrder(@RequestParam Integer order_id) {
                return orderServiceImp.getOrder(order_id);
        }

}
