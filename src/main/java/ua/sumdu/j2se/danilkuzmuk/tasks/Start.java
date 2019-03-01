package ua.sumdu.j2se.danilkuzmuk.tasks;

import org.apache.log4j.Logger;
import ua.sumdu.j2se.danilkuzmuk.tasks.Controller.Controller;
import ua.sumdu.j2se.danilkuzmuk.tasks.Controller.ViewController;
import ua.sumdu.j2se.danilkuzmuk.tasks.Model.ArrayTaskList;
import ua.sumdu.j2se.danilkuzmuk.tasks.Model.Model;
import ua.sumdu.j2se.danilkuzmuk.tasks.Model.TaskIO;
import ua.sumdu.j2se.danilkuzmuk.tasks.View.View;

import java.io.File;
import java.io.IOException;

public class Start  {
    private static Logger log = Logger.getLogger(Start.class);
    public static void main(String[] args) {
        ArrayTaskList tasks = new ArrayTaskList();
        try {
            TaskIO.readBinary(tasks,new File("./src/main/java/ua/sumdu/j2se/danilkuzmuk/tasks/Saves/TaskList.txt"));
        } catch (IOException e) {
            log.error("Отсутствует файл сохранения");
        }
        Notificator notificator = new Notificator();
        View view = new View();
        Model model = new Model();
        model.registerObserver(view);
        model.setTaskList(tasks);
        ViewController viewController = new ViewController();
        Controller controller = new Controller(view,model,viewController);
        view.setController(controller);
        model.setController(controller);
        viewController.setController(controller);
        controller.generateMethodCallKey();
        notificator.setController(controller);
        notificator.start();
        view.mainMenu();
    }

}
