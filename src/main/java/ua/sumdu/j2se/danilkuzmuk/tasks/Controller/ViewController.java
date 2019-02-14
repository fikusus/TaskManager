package ua.sumdu.j2se.danilkuzmuk.tasks.Controller;

import ua.sumdu.j2se.danilkuzmuk.tasks.Model.Task;
import ua.sumdu.j2se.danilkuzmuk.tasks.Start;
import ua.sumdu.j2se.danilkuzmuk.tasks.View.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ViewController {
    public static void MainMenuControl(){
        Scanner in = new Scanner(System.in);
        switch (in.nextInt()){
            case 1:
                View.AddSubMenu();
                break;
            case 2:
                System.out.println(2);
                break;
            case 3:
                System.out.println(3);
                break;
            case 4:
                System.out.println(4);
                break;
            case 5:
                System.exit(0);
                break;
            default:
                View.MainMenu();
                break;
        }
    }
    public static void AddSubMenuControl(){
        Scanner in = new Scanner(System.in);
        switch (in.nextInt()){
            case 1:
                View.AddRepeatMenu();
                break;
            case 2:
                View.AddNoRepeatMenu();
                break;
            default:
                View.AddSubMenu();
                break;
        }
    }
    public static void AddNoRepeatMenu()  {
        String title;
        SimpleDateFormat ft = new SimpleDateFormat ("ss:mm:HH:dd:MM:yyyy");
        Scanner in = new Scanner(System.in);
        title = in.nextLine();
        String str = in.nextLine();
        Date time = new Date();
        try {
            time = ft.parse(str);
            Task tsk = new Task(title,time);
            Start.tasks.add(tsk);
            Start.Save();
        } catch (ParseException e) {
            System.out.println("Неверний формат ввода");
            View.AddNoRepeatMenu();
        }
    }
    public static void AddRepeatMenu()  {
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
            Start.tasks.add(tsk);
            Start.Save();
        } catch (ParseException e) {
            System.out.println("Неверний формат ввода");
            View.AddNoRepeatMenu();
        }
    }

}
