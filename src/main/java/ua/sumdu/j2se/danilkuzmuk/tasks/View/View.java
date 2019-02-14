package ua.sumdu.j2se.danilkuzmuk.tasks.View;


import ua.sumdu.j2se.danilkuzmuk.tasks.Controller.Controller;

public class View
{
    public static void MainMenu(){
        System.out.println("Выберете необходимый вам пункт меню");
        System.out.println("1)Добавить задачу");
        System.out.println("2)Изменить задачу");
        System.out.println("3)Удалить задачу");
        System.out.println("4)Задачи на неделю");
        System.out.println("5)Выход");
        Controller.MainMenuControl();
    }
    public static void AddSubMenu(){
        System.out.println("1)Добавить задачу с повторением");
        System.out.println("2)Добавить задачу без повторение");
        Controller.AddSubMenuControl();
    }
    public static void AddRepeatMenu(){

    }
    public static void AddNoRepeatMenu(){

    }
}
