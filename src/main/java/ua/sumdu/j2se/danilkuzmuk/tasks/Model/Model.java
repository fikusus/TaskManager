package ua.sumdu.j2se.danilkuzmuk.tasks.Model;

import sun.rmi.runtime.Log;
import ua.sumdu.j2se.danilkuzmuk.tasks.Controller.Controller;


import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.log4j.Logger;

public class Model {

    private Logger log = Logger.getLogger(Model.class);
    private Controller controller;
    private ArrayTaskList taskList;
    private SimpleDateFormat ft = new SimpleDateFormat ("ss:mm:HH:dd:MM:yyyy");

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setTaskList(ArrayTaskList taskList) {
        this.taskList = taskList;
    }

    public ArrayTaskList getTaskList() {
        return taskList;
    }

    public void saveData(){
        try {
            TaskIO.writeBinary(taskList,new File("./src/main/java/ua/sumdu/j2se/danilkuzmuk/tasks/Saves/TaskList.txt"));
            controller.getViewController().mainMenu();
        } catch (IOException e) {
            log.error("Отсутствует файл сохранения");
            controller.getViewController().exitApp();
        }
    }

    public void callView(int key){
        switch (key){
            case 6:
                controller.getView().changeMenu();
                break;
             case 7:
                 controller.getView().changeMenu();
                break;
        }
    }
    public SortedMap incomingToday(){
        return Tasks.calendar(taskList.clone(),new Date(),  getTodayCalendar().getTime());
    }
    public SortedMap incomingWeek(){
        Calendar calendar = getTodayCalendar();
        calendar.set(Calendar.DAY_OF_WEEK,1);
        return Tasks.calendar(taskList.clone(),new Date(),calendar.getTime());
    }
    private Calendar getTodayCalendar(){
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        calendar.set(Calendar.MILLISECOND,999);
        return calendar;
    }

    public void addTask(Task task){
        taskList.add(task);
        saveData();
    }
    public void chNoRepeatTime(int index){
        String time = controller.getViewController().printAndReadText("Время задачи в формате ss:mm:HH:dd:MM:yyyy");
        try {
            Date tmpTime = ft.parse(time);
            taskList.getTask(index).setTime(tmpTime);
        } catch (ParseException e) {
            controller.getViewController().invalidData();
        }
        saveData();
    }
    public void chRepeatTime(int index){
        String startTime = controller.getViewController().printAndReadText("Время начала задачи в формате ss:mm:HH:dd:MM:yyyy");
        String endTime = controller.getViewController().printAndReadText("Время конца задачи в формате ss:mm:HH:dd:MM:yyyy");
        try {
            Date startDate = ft.parse(startTime);
            Date endDate = ft.parse(endTime);
            int interval = Integer.valueOf(controller.getViewController().printAndReadText("Интервал выполнения в секундах"));
            taskList.getTask(index).setTime(startDate,endDate,interval);
        } catch (ParseException e) {
            controller.getViewController().invalidData();
        }
        catch (NumberFormatException a){
            controller.getViewController().invalidData();
        }
        saveData();
    }

    public void chName(int index){
        taskList.getTask(index).setTitle(controller.getViewController().printAndReadText("Введите новое название"));
        saveData();
    }

    public void chActive(int index){
        if (taskList.getTask(index).isActive()){
            controller.getViewController().printText("Задача деактивирована");
            taskList.getTask(index).setActive(false);
        }else {
            controller.getViewController().printText("Задача активирована");
            taskList.getTask(index).setActive(true);
        }
        saveData();
    }

    public void remove(int index){
        if (!taskList.remove(taskList.getTask(index))){
            controller.getViewController().invalidData();
        }else{
            saveData();
            controller.getViewController().mainMenu();
        }
    }

}
