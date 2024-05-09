package team.college.database.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import team.college.database.model.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
}
