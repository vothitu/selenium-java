package todo;

import common.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TodoMVCPage;

import java.util.Objects;

public class TodoTest {

    TodoMVCPage todoMVCPage;

    @BeforeClass
    void setup(){
        Browser.launch("chrome");
        todoMVCPage = new TodoMVCPage();
        todoMVCPage.open();
    }

    @BeforeMethod
    void selectAllTaskView(){
        todoMVCPage.selectAllTaskView();
    }
    @Test
    void createNewTodoSuccessfully(){
        todoMVCPage.createNewTask("task 1");
        Assert.assertEquals(todoMVCPage.getLatestTaskName(),"task 1");
    }

    @Test
    void markCompleteATask(){
        todoMVCPage.createNewTask("task 1");
        todoMVCPage.markComplete("task 1");
        todoMVCPage.selectCompletedTaskView();
        Assert.assertEquals(todoMVCPage.getLatestTaskName(),"task 1");
    }

    @Test
    void deleteATaskSuccessfully(){
        todoMVCPage.createNewTask("task 1");
        int beforeDelete = todoMVCPage.getItemsLeft();
        todoMVCPage.delete("task 1");
        int afterDelete = todoMVCPage.getItemsLeft();
        Assert.assertEquals(beforeDelete-afterDelete,1);
    }

    @Test
    void updateTaskNameSuccessfully(){
        todoMVCPage.createNewTask("task 1");
        todoMVCPage.updateName("task 1","task 2");
        Assert.assertTrue(todoMVCPage.isTaskNameDisplay("task 2"));
    }
}
