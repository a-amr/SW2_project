package team.college.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team.college.user.model.*;
import team.college.user.service.UserServiceImp;
import org.springframework.web.bind.annotation.RequestParam;


//http://localhost:8081/user
@RestController
@RequestMapping("/user")
public class UserController {

        @Autowired
        private UserServiceImp userServiceImp;

        @PostMapping("/register")
        public void createUser(@RequestBody User user) {
                userServiceImp.createUser(user);
        }

        @PostMapping("/login")
        public User loginUser(@RequestBody User user) {
                return userServiceImp.loginUser(user);
        }

        @PostMapping("/update")
        public User updateUser(@RequestBody User user) {
                return userServiceImp.updateUser(user);
        }

        // @GetMapping("/{user_id}/add")
        // public Integer addOrder(@RequestParam Integer orderId, @PathVariable Integer user_id) {
        //         userService.addOrder(user_id, orderId);
        //         return user_id;
        // }

        // @GetMapping("/{user_id}/remove")
        // public Integer removeOrder(@RequestParam Integer orderId, @PathVariable Integer user_id) {
        //         userService.removeOrder(user_id, orderId);
        //         return user_id;
        // }

        @GetMapping("/")
        public List<User> all_Users() {
                return userServiceImp.allUsers();
        }

        @GetMapping("/{user_id}/orders")
        public List<Order> all_OrderIds(@PathVariable Integer user_id) {
                return userServiceImp.userOrders(user_id);
        }

        @GetMapping("/{user_id}/payments")
        public List<Payment> all_PaymentsIds(@PathVariable Integer user_id) {
                return userServiceImp.userPayments(user_id);
        }

        @GetMapping("/get")
        public User getUser(@RequestParam Integer user_id) {
                return userServiceImp.getUser(user_id);
        }
        
}
