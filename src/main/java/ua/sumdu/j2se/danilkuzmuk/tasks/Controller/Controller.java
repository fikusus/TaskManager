package ua.sumdu.j2se.danilkuzmuk.tasks.Controller;

import ua.sumdu.j2se.danilkuzmuk.tasks.View.View;

import java.util.Scanner;

public class Controller {
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
                System.out.println('d');
                View.MainMenu();
                break;
        }
    }
    public static void AddSubMenuControl(){
        Scanner in = new Scanner(System.in);
        switch (in.nextInt()){
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            default:
                System.out.println('d');
                View.AddSubMenu();
                break;
        }
    }

}
