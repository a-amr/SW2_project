package team.college.database.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team.college.database.model.entity.Order;
import team.college.database.model.entity.Payment;
import team.college.database.model.entity.User;
import team.college.database.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/user")
public class UserController {
        @Autowired
        private UserService userService;

        @PostMapping("/register")
        public void registerUser(@RequestBody User user) {
                userService.register(user);
        }

        @PostMapping("/update")
        public void updateUser(@RequestBody User user) {
                userService.update(user);
        }


        @GetMapping("/")
        public List<User> getAll() {
            return userService.getAll();
        }

        @GetMapping("/{user_id}/orders")
        public List<Order> userOrders(@PathVariable Integer user_id) {
                return userService.getOrders(user_id);
        }

        @GetMapping("/{user_id}/payments")
        public List<Payment> userPayments(@PathVariable Integer user_id) {
                return userService.getPayments(user_id);
        }
}
