package ua.sumdu.j2se.danilkuzmuk.tasks;

import ua.sumdu.j2se.danilkuzmuk.tasks.Controller.Controller;
import ua.sumdu.j2se.danilkuzmuk.tasks.Controller.ViewController;
import ua.sumdu.j2se.danilkuzmuk.tasks.Model.ArrayTaskList;
import ua.sumdu.j2se.danilkuzmuk.tasks.Model.Model;
import ua.sumdu.j2se.danilkuzmuk.tasks.Model.TaskIO;
import ua.sumdu.j2se.danilkuzmuk.tasks.View.CalendarView;
import ua.sumdu.j2se.danilkuzmuk.tasks.View.View;

import java.io.File;
import java.io.IOException;

public class Start  {
    public static void main(String[] args) {
        ArrayTaskList tasks = new ArrayTaskList();
        try {
            TaskIO.readBinary(tasks,new File("./src/main/java/ua/sumdu/j2se/danilkuzmuk/tasks/Saves/TaskList.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        View view = new View();
        Model model = new Model();
        model.setTaskList(tasks);
        ViewController viewController = new ViewController();
        Controller controller = new Controller(view,model,viewController);
        view.setController(controller);
        model.setController(controller);
        viewController.setController(controller);
        controller.generateMethodCallKey();
        view.mainMenu();
    }

}
