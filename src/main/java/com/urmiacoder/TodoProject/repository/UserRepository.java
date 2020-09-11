package com.urmiacoder.TodoProject.repository;


import com.urmiacoder.TodoProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}