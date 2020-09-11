package com.urmiacoder.TodoProject.controller;


import com.urmiacoder.TodoProject.exception.TaskNotFoundException;
import com.urmiacoder.TodoProject.exception.UserNotFoundException;
import com.urmiacoder.TodoProject.model.Task;
import com.urmiacoder.TodoProject.repository.TaskRepository;
import com.urmiacoder.TodoProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/userInformation/{id}/task")
    public List<Task> getAllTaskOfUser(@PathVariable(value = "id") Long Id) {
        return taskRepository.findByUserId(Id);
    }

    @PostMapping("/userInformation/{id}/task")
    public Task createTask(@PathVariable (value = "id") Long Id, @Valid @RequestBody Task task)
    throws UserNotFoundException
    {

        return userRepository.findById(Id).map(user ->
                {
                task.setUser(user);
                return taskRepository.save(task);
                }
            ).orElseThrow(() -> new UserNotFoundException(Id));
    }

    @PutMapping("/userInformation/{id}/task/{taskId}")
    public Task updateTask(@PathVariable (value = "id") Long Id,
                           @PathVariable (value = "taskId") Long taskId,
                           @Valid @RequestBody Task taskDetail)
    throws UserNotFoundException,TaskNotFoundException{

        if(!userRepository.existsById(Id)) {
            throw new UserNotFoundException(Id);
        }
        Task task=taskRepository.findById(taskId).orElseThrow(()->new TaskNotFoundException(taskId));
        task.setDescription(taskDetail.getDescription());
        Task updateTasks=taskRepository.save(task);
        return updateTasks;
    }

    @DeleteMapping("/userInformation/{id}/task/{taskId}")
    public void deleteTask(@PathVariable (value = "id") Long Id,
                                        @PathVariable (value = "taskId") Long taskId)
    throws UserNotFoundException,TaskNotFoundException{

        if(!userRepository.existsById(Id)) {
            throw new UserNotFoundException(Id);
        }
        Task task=taskRepository.findByTaskIdAndUserId(taskId,Id).orElseThrow(()->new TaskNotFoundException(taskId));
        taskRepository.delete(task);
    }
}
