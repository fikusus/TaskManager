package ua.sumdu.j2se.danilkuzmuk.tasks.View;


import ua.sumdu.j2se.danilkuzmuk.tasks.Controller.ViewController;

public class View
{
    public static void MainMenu(){
        System.out.println("Выберете необходимый вам пункт меню");
        System.out.println("1)Добавить задачу");
        System.out.println("2)Задачи на сегодня");
        System.out.println("3)Задачи на неделю");
        System.out.println("4)Задачи на месяц");
        System.out.println("5)Выход");
        ViewController.MainMenuControl();
    }
    public static void AddSubMenu(){
        System.out.println("1)Добавить задачу с повторением");
        System.out.println("2)Добавить задачу без повторение");
        ViewController.AddSubMenuControl();
    }
    public static void AddRepeatMenu(){
        System.out.println("Введите:\nНазвание задачи\nВремя начала задачи в формате ss:mm:HH:dd:MM:yyyy\nВремя конца задачи в формате ss:mm:HH:dd:MM:yyyy\nИнтервал выполнения в секундах");
        ViewController.AddRepeatMenu();
    }
    public static void AddNoRepeatMenu(){
        System.out.println("Введите:\nНазвание задачи\nВремя задачи в формате ss:mm:HH:dd:MM:yyyy");
        ViewController.AddNoRepeatMenu();
    }
}
