package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {
    private TaskList toDoList = new TaskList();
    private TaskList inProgressList = new TaskList();
    private TaskList doneList = new TaskList();

    @Bean(name = "toDo")
    @Scope("prototype")
    public TaskList toDo() {
        return toDoList;
    }

    @Bean(name = "inProgress")
    @Scope("prototype")
    public TaskList inProgress() {
        return inProgressList;
    }

    @Bean(name = "done")
    @Scope("prototype")
    public TaskList done() {
        return doneList;
    }


}
