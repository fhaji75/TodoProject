package com.urmiacoder.TodoProject.repository;

import com.urmiacoder.TodoProject.model.Task;
import com.urmiacoder.TodoProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId);
    Optional<Task> findByTaskIdAndUserId(Long taskId, Long userId);
}
