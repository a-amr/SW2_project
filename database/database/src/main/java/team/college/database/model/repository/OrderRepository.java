package team.college.database.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import team.college.database.model.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
