package team.college.database.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import team.college.database.model.entity.OrderProduct;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer>{

}
