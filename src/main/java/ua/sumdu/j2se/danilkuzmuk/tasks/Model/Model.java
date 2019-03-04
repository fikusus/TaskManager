package ua.sumdu.j2se.danilkuzmuk.tasks.Model;

import ua.sumdu.j2se.danilkuzmuk.tasks.Controller.Controller;


import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.log4j.Logger;
import ua.sumdu.j2se.danilkuzmuk.tasks.Interfaces.ObservableModel;
import ua.sumdu.j2se.danilkuzmuk.tasks.Interfaces.ObserverView;

public class Model implements ObservableModel {

    private Logger log = Logger.getLogger(Model.class);
    private Controller controller;
    private ArrayTaskList taskList;
    private ArrayList<ObserverView> observerViews = new ArrayList<>();
    private SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy-HH:mm:ss");

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
        notifyObservers();
        saveData();
    }

    public void addNoRepeatMenu(int index)  {
        String title = controller.getViewController().printAndReadText("Введите название задачи");
        String dateStr = controller.getViewController().printAndReadText("Время задачи в формате dd/MM/yyyy-HH:mm:ss");
        try {
            Date time = ft.parse(dateStr);
            Task tsk = new Task(title,time);
            addTask(tsk);
        } catch (ParseException e) {
            log.info("Формат входных данных неверный");
            controller.getViewController().invalidData();
        }
    }

    public void addRepeatMenu(int index)  {
        String title = controller.getViewController().printAndReadText("Введите название задачи");
        String startTime = controller.getViewController().printAndReadText("Время начала задачи в формате dd/MM/yyyy-HH:mm:ss");
        String endTime = controller.getViewController().printAndReadText("Время конца задачи в формате dd/MM/yyyy-HH:mm:ss");
        int interval = Integer.valueOf(controller.getViewController().printAndReadText("Интервал выполнения в секундах"));
        try {
            Date start = ft.parse(startTime);
            Date end = ft.parse(endTime);
            Task tsk = new Task(title,start,end,interval);
            addTask(tsk);
        } catch (ParseException e) {
            log.info("Формат входных данных неверный");
            controller.getViewController().invalidData();
        }
    }

    public void chNoRepeatTime(int index){
        String time = controller.getViewController().printAndReadText("Время задачи в формате dd/MM/yyyy-HH:mm:ss");
        try {
            Date tmpTime = ft.parse(time);
            taskList.getTask(index).setTime(tmpTime);
            notifyObservers();
        } catch (ParseException e) {
            log.info("Формат входных данных неверный");
            controller.getViewController().invalidData();
        }
        saveData();
    }
    public void chRepeatTime(int index){
        String startTime = controller.getViewController().printAndReadText("Время начала задачи в формате dd/MM/yyyy-HH:mm:ss");
        String endTime = controller.getViewController().printAndReadText("Время конца задачи в формате dd/MM/yyyy-HH:mm:ss");
        try {
            Date startDate = ft.parse(startTime);
            Date endDate = ft.parse(endTime);
            int interval = Integer.valueOf(controller.getViewController().printAndReadText("Интервал выполнения в секундах"));
            taskList.getTask(index).setTime(startDate,endDate,interval);
            notifyObservers();
        } catch (ParseException e) {
            log.info("Формат входных данных неверный");
            controller.getViewController().invalidData();
        }
        catch (NumberFormatException a){
            log.info("Формат входных данных неверный");
            controller.getViewController().invalidData();
        }
        saveData();
    }

    public void chName(int index){
        taskList.getTask(index).setTitle(controller.getViewController().printAndReadText("Введите новое название"));
        notifyObservers();
        saveData();
    }

    public void chActive(int index){
        if (taskList.getTask(index).isActive()){
            controller.getViewController().printText("Задача деактивирована");
            taskList.getTask(index).setActive(false);
            notifyObservers();
        }else {
            controller.getViewController().printText("Задача активирована");
            taskList.getTask(index).setActive(true);
            notifyObservers();
        }
        saveData();
    }

    public void remove(int index){
        if (!taskList.remove(taskList.getTask(index))){
            controller.getViewController().invalidData();
        }else{
            notifyObservers();
            saveData();
            controller.getViewController().mainMenu();
        }
    }
    public void mainMenu(){
        controller.getViewController().mainMenu();
    }
    @Override
    public void registerObserver(ObserverView o) {
        observerViews.add(o);
    }

    @Override
    public void removeObserver(ObserverView o) {
        observerViews.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (ObserverView obsView:observerViews) {
            obsView.update(taskList);
        }
    }

}
