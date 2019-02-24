package ua.sumdu.j2se.danilkuzmuk.tasks.View;


import ua.sumdu.j2se.danilkuzmuk.tasks.Controller.Controller;
import ua.sumdu.j2se.danilkuzmuk.tasks.Model.ArrayTaskList;
import ua.sumdu.j2se.danilkuzmuk.tasks.Model.Task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;

public class View
{
    private CalendarView calendarView = new CalendarView();
    private Controller controller;
    private String separator = "------------------------";

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void mainMenu() {
        System.out.println(separator);
        System.out.println("Выберете необходимый вам пункт меню");
        System.out.println("1)Добавить задачу");
        System.out.println("2)Задачи на сегодня");
        System.out.println("3)Задачи до конца недели");
        System.out.println("4)Изменить/удалить задачу");
        System.out.println("5)Календарь");
        System.out.println("6)Выход");
        controller.mainMenuControl(0);
    }
    public void addSubMenu(){
        System.out.println(separator);
        System.out.println("1)Добавить задачу с повторением");
        System.out.println("2)Добавить задачу без повторение");
        System.out.println("3)В меню");
        controller.mainMenuControl(1);
    }
    public void addRepeatMenu(){
        System.out.println(separator);
        System.out.println("Введите:\nНазвание задачи\nВремя начала задачи в формате ss:mm:HH:dd:MM:yyyy\nВремя конца задачи в формате ss:mm:HH:dd:MM:yyyy\nИнтервал выполнения в секундах");
        controller.addRepeatMenu();
    }
    public void addNoRepeatMenu(){
        System.out.println(separator);
        System.out.println("Введите:\nНазвание задачи\nВремя задачи в формате ss:mm:HH:dd:MM:yyyy");
        controller.addNoRepeatMenu();
    }
    public void taskListView(SortedMap<Date, Set<Task>> tsk){
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        System.out.println(separator);
        Iterator<Date> tskIter = tsk.keySet().iterator();
        while (tskIter.hasNext()){
            Date keySet = tskIter.next();
            Iterator<Task> stskIter = tsk.get(keySet).iterator();
            while (stskIter.hasNext()){
                Task sTask = stskIter.next();
                System.out.println("На время " + dateFormat.format(keySet));
                    System.out.println("    Задача'"+sTask.getTitle()+"'");
            }
        }
        mainMenu();
    }
    public void showAllTaskList(ArrayTaskList arr){
        System.out.println(separator);
        for(int i = 0;i < arr.size();i++){
            System.out.println("(" + i + ")" + arr.getTask(i).toString());
        }
        System.out.println(separator);
        System.out.println("1)Изменть");
        System.out.println("2)Удалить");
        System.out.println("3)В меню");
        controller.mainMenuControl(2);
    }

    public void changeMenu(){
        System.out.println(separator);
        System.out.println("Введите номер задачи которую необходимо изменить");
        changeTasks(controller.readerInt());
    }

    public void removeMenu(){
        System.out.println(separator);
        System.out.println("Введите номер задачи которую необходимо удалить");
        controller.removeControl();
    }
    public void changeTasks(int index){
        System.out.println(separator);
        System.out.println("Выберите что необходимо изменить");
        System.out.println("1)Время выполнения(задача будет неповторяющиеся)");
        System.out.println("2)Время начала/конца и интервал(задача будет повторяющиеся)");
        System.out.println("3)Название");
        System.out.println("4)Активность");
        System.out.println("5)В меню");
        controller.changeControl(index);
    }

    public String printAndReadText(String str){
        System.out.println(separator);
        System.out.println(str);
        return controller.readerText();
    }

    public int printAndReadInt(String str){
        System.out.println(separator);
        System.out.println(str);
        return controller.readerInt();
    }

    public void printText(String str){
        System.out.println(separator);
        System.out.println(str);
    }

    public void invalidData(){
        System.out.println("Неверний формат ввода");
        mainMenu();
    }
    public void drawCalendar(){
        calendarView.drawCalendar(printAndReadInt("Введите желаемый месяц"),printAndReadInt("Введите желаемый год"));
        mainMenu();
    }
}
