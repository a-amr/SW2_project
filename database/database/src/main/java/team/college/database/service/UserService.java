package team.college.database.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.college.database.model.entity.*;
import team.college.database.model.repository.UserRepository;

@Service
public class UserService {

        @Autowired
        private UserRepository userRepository;

        public List<User> getAll() {
                return userRepository.findAll();
        }

        public Boolean register(User user) {
                // id
                // email

                if (user == null) return false;

                if (user.getPassword() == null) return false;
                boolean isContainsUppercase = false;
                for (char c : user.getPassword().toCharArray()) {
                if (Character.isUpperCase(c)) {
                        isContainsUppercase = true;
                        break;
                }
                }
                if (!isContainsUppercase) {
                return false;
                }

                if (user.getPassword().contains(" ")) {
                return false;
                }
                if (user.getEmail() == null || !user.getEmail().contains("@") || !user.getEmail().endsWith(".com")) {
                        return false;
                }
                if (user.getId() != null) return false;
                List<User> users = getAll();
                for (User u: users)
                {
                        if (user.getEmail().equalsIgnoreCase(u.getEmail()))
                        {
                                return false;
                        }
                }
                userRepository.save(user);
                return true;
        }

        public Boolean update(User user) {
                if (user == null) return false;

                if (user.getPassword() == null) return false;
                boolean isContainsUppercase = false;
                for (char c : user.getPassword().toCharArray()) {
                if (Character.isUpperCase(c)) {
                        isContainsUppercase = true;
                        break;
                }
                }
                if (!isContainsUppercase) {
                return false;
                }

                if (user.getPassword().contains(" ")) {
                return false;
                }
                if (user.getEmail() == null || !user.getEmail().contains("@") || !user.getEmail().endsWith(".com")) {
                        return false;
                }
                if (user.getId() == null) return false;
                System.out.println("hello");
                List<User> users = getAll();
                for (User u: users)
                {
                        if (user.getEmail().equalsIgnoreCase(u.getEmail()) && user.getId() != u.getId())
                        {
                                return false;
                        }
                }
                userRepository.save(user);
                return true;
                
        }

        public List<Payment> getPayments(Integer user_id) {
                Optional<User> user = userRepository.findById(user_id);
                if (user.isPresent())
                        return user.get().payments;
                throw null;
        }

        public List<Order> getOrders(Integer user_id) {
                Optional<User> user = userRepository.findById(user_id);
                if (user.isPresent())
                        return user.get().orders;
                throw null;
        }
}
