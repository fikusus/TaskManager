package ua.sumdu.j2se.danilkuzmuk.tasks;


import ua.sumdu.j2se.danilkuzmuk.tasks.Model.ArrayTaskList;
import ua.sumdu.j2se.danilkuzmuk.tasks.Model.TaskIO;
import ua.sumdu.j2se.danilkuzmuk.tasks.View.View;

import java.io.File;
import java.io.IOException;

public class Start  {
    public static ArrayTaskList tasks = new ArrayTaskList();

    public static void main(String[] args){
        try {
            TaskIO.readBinary(tasks,new File("C:\\Users\\Timon\\Desktop\\TaskManager\\src\\main\\java\\ua\\sumdu\\j2se\\danilkuzmuk\\tasks\\Saves\\TaskList.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        View.MainMenu();
    }
    public static void Save(){
        try {
            TaskIO.writeBinary(tasks,new File("C:\\Users\\Timon\\Desktop\\TaskManager\\src\\main\\java\\ua\\sumdu\\j2se\\danilkuzmuk\\tasks\\Saves\\TaskList.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
