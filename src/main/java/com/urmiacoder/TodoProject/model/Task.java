package com.urmiacoder.TodoProject.model;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue
    private Long taskId;

    private String description;
    private Timestamp date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private User user;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public Task(){
        super();
    }
    public Task(Long taskId, String description, Timestamp date, User user) {
        super();
        this.taskId = taskId;
        this.description = description;
        this.date = date;
        this.user = user;
    }
}
