package com.urmiacoder.TodoProject.exception;

public class TaskNotFoundException extends Exception{
    private long id;
    public TaskNotFoundException(long id){
        super(String.format("Task is not found with id : '%s'", id));
    }
}
