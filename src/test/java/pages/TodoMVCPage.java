package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static common.Browser.*;

public class TodoMVCPage {
    public void open(){
        visit("https://todomvc.com/examples/vanillajs/#/");
    }

    public void createNewTask(String name){
        senKeys(By.className("new-todo"),name+Keys.ENTER);
    }

    public String getLatestTaskName(){

        return getText(By.cssSelector(".todo-list > li:last-child"));
    }

    public void markComplete(String taskName){
        click(By.xpath(String.format("//label[.='%s']/preceding-sibling::input",taskName)));
    }

    public void selectCompletedTaskView(){
        click(By.linkText("Completed"));
    }
    public void selectAllTaskView(){
        if(isDisplayed(By.linkText("All"))){
            click(By.linkText("All"));
        }
    }

    public int getItemsLeft(){
        String itemLeft = getText(By.cssSelector(".todo-count strong"));
        if(itemLeft.equals("")){
            return 0;
        }else return Integer.parseInt(itemLeft);
    }

    public void delete(String taskName){
        hover(By.xpath(String.format("//label[.='%s']",taskName)));
        click(By.xpath(String.format("//label[.='%s']/following-sibling::button",taskName)));
    }
    public void updateName(String oldTaskName,String newTaskName){
        doubleClick(By.xpath(String.format("//label[.='%s']",oldTaskName)));
        WebElement editTaskBtn = getDriver()
                .findElement(By.xpath(String.format("//label[.='%s']/../..",oldTaskName)))
                .findElement(By.cssSelector("input.edit"));

        //Clear the current task name
        executeJSScript("arguments[0].value = ''",editTaskBtn);
        editTaskBtn.sendKeys(newTaskName+Keys.ENTER);
    }

    public boolean isTaskNameDisplay(String name){
        return isDisplayed(By.xpath(String.format("//label[.='%s']",name)));
    }
}
