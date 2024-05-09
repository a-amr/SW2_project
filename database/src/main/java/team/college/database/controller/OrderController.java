package team.college.database.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import team.college.database.model.entity.*;
import team.college.database.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("order")
public class OrderController {


        @Autowired
        private OrderService orderService;

        @PostMapping("add")
        public void add(@RequestBody Order order) {
                orderService.add(order);
        }

        @PostMapping("update")
        public void update(@RequestBody Order order) {
                orderService.update(order);
        }
        

        @GetMapping("remove")
        public void remove(@RequestParam Integer order_id) {
                orderService.remove(order_id);
        }

        @GetMapping("get")
        public Order get(@RequestParam Integer order_id) {
                return orderService.get(order_id);
        }
}
