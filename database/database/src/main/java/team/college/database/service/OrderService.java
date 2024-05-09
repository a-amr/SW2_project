package team.college.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.college.database.model.entity.*;
import team.college.database.model.repository.OrderRepository;
import team.college.database.model.repository.UserRepository;

@Service
public class OrderService {

        @Autowired
        private OrderRepository orderRepository;

        @Autowired
        private UserRepository userRepository;

        public Boolean add(Order order) {
                if (order == null) return false;
                if (order.getTotalCost() == null || order.getTotalCost() <= 0) return false;
                if (order.getId() != null) return false;
                if (order.getUser() == null) return false;
                if (userRepository.findById(order.getUser().getId()).isPresent())
                {
                        orderRepository.save(order);
                        return true;
                }
                return false;
        }

        public Boolean update(Order order) {
                if (order == null) return false;
                if (order.getTotalCost() == null || order.getTotalCost() <= 0) return false;
                if (order.getId() == null) return false;
                if (orderRepository.findById(order.getId()).isEmpty()) return false;
                if (order.getUser() == null) return false;
                if (userRepository.findById(order.getUser().getId()).isPresent())
                {
                        orderRepository.save(order);
                        return true;
                }
                return false;
        }

        public Boolean remove(Integer order_id) {
                if (orderRepository.findById(order_id).isEmpty()) return false;
                orderRepository.deleteById(order_id);
                return true;
        }

        public Order get(Integer order_id) {
                if (orderRepository.findById(order_id).isEmpty()) return null;
                return orderRepository.findById(order_id).get();
        }
}
