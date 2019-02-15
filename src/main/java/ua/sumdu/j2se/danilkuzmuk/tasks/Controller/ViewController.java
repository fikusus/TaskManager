package ua.sumdu.j2se.danilkuzmuk.tasks.Controller;

import ua.sumdu.j2se.danilkuzmuk.tasks.Model.ArrayTaskList;
import ua.sumdu.j2se.danilkuzmuk.tasks.Model.Task;
import ua.sumdu.j2se.danilkuzmuk.tasks.Model.TaskIO;
import ua.sumdu.j2se.danilkuzmuk.tasks.Model.Tasks;
import ua.sumdu.j2se.danilkuzmuk.tasks.View.View;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ViewController {

    private View view;
    private ArrayTaskList taskList;

    public void setTaskList(ArrayTaskList taskList) {
        this.taskList = taskList;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void MainMenuControl(){
        Scanner in = new Scanner(System.in);
        switch (in.nextInt()){
            case 1:
                view.AddSubMenu();
                break;
            case 2:
                Calendar tdCalendar = new GregorianCalendar();
                tdCalendar.set(Calendar.HOUR,23);
                tdCalendar.set(Calendar.MINUTE,59);
                tdCalendar.set(Calendar.SECOND,59);
                tdCalendar.set(Calendar.MILLISECOND,999);
                view.TaskListView(Tasks.calendar(taskList.clone(),new Date(),tdCalendar.getTime()));
                break;
            case 3:
                Calendar weCalendar = new GregorianCalendar();
                weCalendar.set(Calendar.HOUR,23);
                weCalendar.set(Calendar.MINUTE,59);
                weCalendar.set(Calendar.SECOND,59);
                weCalendar.set(Calendar.MILLISECOND,999);
                weCalendar.set(Calendar.DAY_OF_WEEK,7);
                view.TaskListView(Tasks.calendar(taskList.clone(),new Date(),weCalendar.getTime()));
                break;
            case 4:
                view.ShowAllTaskList(taskList);
                break;
            case 5:
                System.exit(0);
                break;
            default:
                view.MainMenu();
                break;
        }
    }
    public void AddSubMenuControl(){
        Scanner in = new Scanner(System.in);
        switch (in.nextInt()){
            case 1:
                view.AddRepeatMenu();
                break;
            case 2:
                view.AddNoRepeatMenu();
                break;
            default:
                view.AddSubMenu();
                break;
        }
    }
    public void AddNoRepeatMenu()  {
        String title;
        SimpleDateFormat ft = new SimpleDateFormat ("ss:mm:HH:dd:MM:yyyy");
        Scanner in = new Scanner(System.in);
        title = in.nextLine();
        String str = in.nextLine();
        Date time = new Date();
        try {
            time = ft.parse(str);
            Task tsk = new Task(title,time);
            taskList.add(tsk);
            Save();
        } catch (ParseException e) {
            System.out.println("Неверний формат ввода");
            view.AddNoRepeatMenu();
        }
    }
    public void AddRepeatMenu()  {
        String title;
        SimpleDateFormat ft = new SimpleDateFormat ("ss:mm:HH:dd:MM:yyyy");
        Scanner in = new Scanner(System.in);
        title = in.nextLine();
        Date start = new Date();
        Date end = new Date();
        try {
            start = ft.parse(in.nextLine());
            end = ft.parse(in.nextLine());
            Task tsk = new Task(title,start,end,in.nextInt());
            taskList.add(tsk);
            Save();
        } catch (ParseException e) {
            view.InvalidData();
        }
    }
    public void TaskListMenu() {
        Scanner in = new Scanner(System.in);
        switch (in.nextInt()) {
            case 1:
                view.ChangeMenu(true);
                break;
            case 2:
                view.ChangeMenu(false);
                break;
            case 3:
                view.MainMenu();
                break;
            default:
                view.ShowAllTaskList(taskList);
                break;
        }
    }

    public void ChangeControl(boolean key){
        Scanner in = new Scanner(System.in);
        if(key){

        }else {
            if (!taskList.remove(taskList.getTask(in.nextInt()))){
                view.InvalidData();
            }else{
                Save();
                view.MainMenu();
            }
        }
    }



    public void Save(){
        try {
            TaskIO.writeBinary(taskList,new File("./src/main/java/ua/sumdu/j2se/danilkuzmuk/tasks/Saves/TaskList.txt"));
            view.MainMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
