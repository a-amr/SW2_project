package team.college.user.service;

import team.college.user.model.Order;
import team.college.user.model.Payment;
import team.college.user.model.User;

import java.util.List;

public interface UserService {
    public List<User> allUsers();

    public List<Order> userOrders(Integer user_id);

    public List<Payment> userPayments(Integer user_id);

    public void createUser(User user);


    public User loginUser(User user);

    public User updateUser(User user);

    public User getUser(Integer user_id);
}
