package team.college.database.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import team.college.database.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
