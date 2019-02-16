package ua.sumdu.j2se.danilkuzmuk.tasks.Controller;

import ua.sumdu.j2se.danilkuzmuk.tasks.Model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ViewController {

    private Model model;

    public void setModel(Model model) {
        this.model = model;
    }

    public void MainMenuControl(){
        Scanner in = new Scanner(System.in);
        switch (in.next()){
            case "1":
                model.CallView(1);
                break;
            case "2":
                model.Incoming(0);
                break;
            case "3":
                model.Incoming(1);
                break;
            case "4":
                model.CallView(2);
                break;
            case "5":
                model.ExitApp();
                break;
            default:
                model.CallView(0);
                break;
        }
    }
    public void AddSubMenuControl(){
        Scanner in = new Scanner(System.in);
        switch (in.nextInt()){
            case 1:
                model.CallView(3);
                break;
            case 2:
                model.CallView(4);
                break;
            default:
                model.CallView(0);
                break;
        }
    }
    public void AddNoRepeatMenu()  {
        SimpleDateFormat ft = new SimpleDateFormat ("ss:mm:HH:dd:MM:yyyy");
        Scanner in = new Scanner(System.in);
        String title = in.nextLine();
        String dateStr = in.nextLine();
        try {
            Date time = ft.parse(dateStr);
            Task tsk = new Task(title,time);
            model.AddTask(tsk);
        } catch (ParseException e) {
            model.CallView(5);
        }
    }
    public void AddRepeatMenu()  {
        SimpleDateFormat ft = new SimpleDateFormat ("ss:mm:HH:dd:MM:yyyy");
        Scanner in = new Scanner(System.in);
        String title = in.nextLine();
        try {
            Date start = ft.parse(in.nextLine());
            Date end = ft.parse(in.nextLine());
            Task tsk = new Task(title,start,end,in.nextInt());
            model.AddTask(tsk);
        } catch (ParseException e) {
            model.CallView(5);
        }
    }
    public void TaskListMenu() {
        Scanner in = new Scanner(System.in);
        switch (in.nextInt()) {
            case 1:
                model.CallView(6);
                break;
            case 2:
                model.CallView(7);
                break;
            case 3:
                model.CallView(0);
                break;
            default:
                model.CallView(2);
                break;
        }
    }

    public void ChangeControl(boolean key){
        Scanner in = new Scanner(System.in);
        model.ChangeTaskList(in.nextInt(),key);
    }

    public String ReaderText (){
        Scanner in = new Scanner(System.in);
        return in.next();
    }

}
