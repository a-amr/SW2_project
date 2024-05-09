package team.college.database.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import team.college.database.model.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
