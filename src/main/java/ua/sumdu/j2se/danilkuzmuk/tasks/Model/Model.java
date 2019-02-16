package ua.sumdu.j2se.danilkuzmuk.tasks.Model;

import ua.sumdu.j2se.danilkuzmuk.tasks.View.View;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Model {


    private View view;
    private ArrayTaskList taskList;



    public void setView(View view) {
        this.view = view;
    }

    public void setTaskList(ArrayTaskList taskList) {
        this.taskList = taskList;
    }
    public void Save(){
        try {
            TaskIO.writeBinary(taskList,new File("./src/main/java/ua/sumdu/j2se/danilkuzmuk/tasks/Saves/TaskList.txt"));
            view.MainMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CallView(int key){
        switch (key){
            case 0:
                view.MainMenu();
                break;
            case 1:
                view.AddSubMenu();
                break;
            case 2:
                view.ShowAllTaskList(taskList);
                break;
            case 3:
                view.AddRepeatMenu();
                break;
            case 4:
                view.AddNoRepeatMenu();
                break;
            case 5:
                view.InvalidData();
                break;
            case 6:
                view.ChangeMenu(true);
                break;
             case 7:
                 view.ChangeMenu(false);
                break;
        }
    }
    public void Incoming(int key){
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        calendar.set(Calendar.MILLISECOND,999);
        if (key == 1){
            calendar.set(Calendar.DAY_OF_WEEK,1);
        }
        view.TaskListView(Tasks.calendar(taskList.clone(),new Date(),calendar.getTime()));
    }

    public void ExitApp(){
       // Save();
        System.exit(0);
    }

    public void AddTask(Task task){
        taskList.add(task);
        Save();
    }
    public void ChangeTaskList(int index, boolean noRemove){
        if(noRemove){
            SimpleDateFormat ft = new SimpleDateFormat ("ss:mm:HH:dd:MM:yyyy");
            switch (view.ChangeTasks()){
                case "1":
                    String time = view.PrintAndReadText("Время задачи в формате ss:mm:HH:dd:MM:yyyy");
                    try {
                        Date tmpTime = ft.parse(time);
                        taskList.getTask(index).setTime(tmpTime);
                    } catch (ParseException e) {
                        view.InvalidData();
                    }
                    Save();
                    break;
                case "2":
                    String startTime = view.PrintAndReadText("Время начала задачи в формате ss:mm:HH:dd:MM:yyyy");
                    String endTime = view.PrintAndReadText("Время конца задачи в формате ss:mm:HH:dd:MM:yyyy");
                    try {
                        Date startDate = ft.parse(startTime);
                        Date endDate = ft.parse(endTime);
                        int interval = Integer.valueOf(view.PrintAndReadText("Интервал выполнения в секундах"));
                        taskList.getTask(index).setTime(startDate,endDate,interval);
                    } catch (ParseException e) {
                        view.InvalidData();
                    }
                    catch (NumberFormatException a){
                        view.InvalidData();
                    }
                    Save();
                    break;
                case "3":
                    taskList.getTask(index).setTitle(view.PrintAndReadText("Введите новое название"));
                    Save();
                    break;
                case "4":
                    if (taskList.getTask(index).isActive()){
                        view.PrintText("Задача деактивирована");
                        taskList.getTask(index).setActive(false);
                    }else {
                        view.PrintText("Задача активирована");
                        taskList.getTask(index).setActive(true);
                    }
                    Save();
                    break;
                case "5":
                    Save();
                    break;
                    default:
                        ChangeTaskList(index,noRemove);
                        break;
            }
        }else {
            if (!taskList.remove(taskList.getTask(index))){
                view.InvalidData();
            }else{
                Save();
                view.MainMenu();
            }
        }
    }
}
