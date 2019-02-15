package ua.sumdu.j2se.danilkuzmuk.tasks.View;


import ua.sumdu.j2se.danilkuzmuk.tasks.Controller.ViewController;
import ua.sumdu.j2se.danilkuzmuk.tasks.Model.ArrayTaskList;
import ua.sumdu.j2se.danilkuzmuk.tasks.Model.Task;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;

public class View
{
    private ViewController viewController;

    private String separator = "------------------------";

    public void setViewController(ViewController viewController) {
        this.viewController = viewController;
    }

    public void MainMenu(){
        System.out.println(separator);
        System.out.println("Выберете необходимый вам пункт меню(1-5)");
        System.out.println("1)Добавить задачу");
        System.out.println("2)Задачи на сегодня");
        System.out.println("3)Задачи на неделю");
        System.out.println("4)Изменить/удалить задачу");
        System.out.println("5)Выход");
        viewController.MainMenuControl();
    }
    public void AddSubMenu(){
        System.out.println(separator);
        System.out.println("1)Добавить задачу с повторением");
        System.out.println("2)Добавить задачу без повторение");
        viewController.AddSubMenuControl();
    }
    public void AddRepeatMenu(){
        System.out.println(separator);
        System.out.println("Введите:\nНазвание задачи\nВремя начала задачи в формате ss:mm:HH:dd:MM:yyyy\nВремя конца задачи в формате ss:mm:HH:dd:MM:yyyy\nИнтервал выполнения в секундах");
        viewController.AddRepeatMenu();
    }
    public void AddNoRepeatMenu(){
        System.out.println(separator);
        System.out.println("Введите:\nНазвание задачи\nВремя задачи в формате ss:mm:HH:dd:MM:yyyy");
        viewController.AddNoRepeatMenu();
    }
    public void TaskListView(SortedMap<Date, Set<Task>> tsk){
        System.out.println(separator);
        Iterator<Date> tskIter = tsk.keySet().iterator();
        while (tskIter.hasNext()){
            Date keySet = tskIter.next();
            Iterator<Task> stskIter = tsk.get(keySet).iterator();
            while (stskIter.hasNext()){
                Task sTask = stskIter.next();
                System.out.println(sTask.toString());
            }
        }
        MainMenu();
    }
    public void ShowAllTaskList(ArrayTaskList arr){
        System.out.println(separator);
        for(int i = 0;i < arr.size();i++){
            System.out.println("(" + i + ")" + arr.getTask(i).toString());
        }
        System.out.println(separator);
        System.out.println("1)Изменть");
        System.out.println("2)Удалить");
        System.out.println("3)В меню");
        viewController.TaskListMenu();
    }

    public void ChangeMenu(boolean key){
        System.out.println(separator);
        if(key){
            System.out.println("Введите номер задачи которую необходимо изменить");
        }else {
            System.out.println("Введите номер задачи которую необходимо удалить");
        }
        viewController.ChangeControl(key);
    }
    public void InvalidData(){
        System.out.println("Неверний формат ввода");
        MainMenu();
    }
}
