package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    private static final String TASK_LIST_NAME = "My list";
    private static final String DESCRIPTION = "Test: Learn Hibernate";

    @Test
    public void testFindByListName() {
        //Given
        TaskList taskList = new TaskList(TASK_LIST_NAME, DESCRIPTION);

        //When
        taskListDao.save(taskList);

        //Then
        int id = taskList.getId();
        List<TaskList> taskLists = taskListDao.findByListName(TASK_LIST_NAME);
        Assert.assertEquals(1, taskLists.size());
        Assert.assertEquals(TASK_LIST_NAME, taskLists.get(0).getListName());
        Assert.assertEquals(DESCRIPTION, taskLists.get(0).getDescription());

        //CleanUp
        taskListDao.deleteById(id);
    }
}
