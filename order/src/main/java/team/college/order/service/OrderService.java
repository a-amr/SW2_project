package team.college.order.service;

import team.college.order.model.Order;


public interface OrderService {
    public void addOrder(Order order);
    public void updateOrder(Order order);
    public void removeOrder(Integer order_id);
    public Order getOrder(Integer order_id);
}
