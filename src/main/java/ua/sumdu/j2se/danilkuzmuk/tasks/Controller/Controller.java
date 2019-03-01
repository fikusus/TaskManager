package ua.sumdu.j2se.danilkuzmuk.tasks.Controller;

import org.apache.log4j.Logger;
import ua.sumdu.j2se.danilkuzmuk.tasks.Model.*;
import ua.sumdu.j2se.danilkuzmuk.tasks.View.View;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Controller {

    private View view;
    private Model model;
    private ViewController viewController;
    private ArrayList<HashMap<String,String>> methodCallKey = new ArrayList<>();
    private SimpleDateFormat ft = new SimpleDateFormat ("ss:mm:HH:dd:MM:yyyy");
    private Logger log = Logger.getLogger(Controller.class);

    public Controller(View view, Model model, ViewController viewController) {
        this.view = view;
        this.model = model;
        this.viewController = viewController;
    }

    public void mainMenuControl(int currMenu)  {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        if (methodCallKey.get(currMenu).containsKey(a)){
            try {
                viewController.getClass().getMethod(methodCallKey.get(currMenu).get(a)).invoke(viewController);
            } catch (IllegalAccessException e) {
                log.error("Нет доступа к методу");
                viewController.mainMenu();
            } catch (InvocationTargetException e) {
                log.error("Базовый метод генерирует исключение.");
                viewController.mainMenu();
            } catch (NoSuchMethodException e) {
                log.error("Метод не существует");
                viewController.mainMenu();
            }
        }else {
            viewController.printText("Неверная команада");
            mainMenuControl(currMenu);
        }
    }

    public void changeControl(int index,int indexOfTask){
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        if (methodCallKey.get(index).containsKey(a)){
            try {
                model.getClass().getMethod(methodCallKey.get(index).get(a),int.class).invoke(model,indexOfTask);
            } catch (IllegalAccessException e) {
                log.error("Нет доступа к методу");
                viewController.mainMenu();
            } catch (InvocationTargetException e) {
                log.error("Базовый метод генерирует исключение.");
                viewController.mainMenu();
            } catch (NoSuchMethodException e) {
                log.error("Метод не существует");
                viewController.mainMenu();
            }
        }else {
            viewController.printText("Неверная команада");
            changeControl(index,indexOfTask);
        }
    }

    public int readerInt(){
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public void removeControl(){
        Scanner in = new Scanner(System.in);
        model.remove(in.nextInt());
    }

    public String readerText(){
        Scanner in = new Scanner(System.in);
        return in.next();
    }

    public void generateMethodCallKey(){
        HashMap<String,String> tmp = new HashMap<>();
        tmp.put("1","addSubMenu");
        tmp.put("2","incomingToday");
        tmp.put("3","incomingWeek");
        tmp.put("4","showAllTaskList");
        tmp.put("5","drawCalendar");
        tmp.put("6","exitApp");
        methodCallKey.add(tmp);
        tmp = new HashMap<>();
        tmp.put("1","addRepeatMenu");
        tmp.put("2","addNoRepeatMenu");
        tmp.put("3","mainMenu");
        methodCallKey.add(tmp);
        tmp = new HashMap<>();
        tmp.put("1","changeMenu");
        tmp.put("2","removeMenu");
        tmp.put("3","mainMenu");
        methodCallKey.add(tmp);
        tmp = new HashMap<>();
        tmp.put("1","chNoRepeatTime");
        tmp.put("2","chRepeatTime");
        tmp.put("3","chName");
        tmp.put("4","chActive");
        tmp.put("5","mainMenu");
        methodCallKey.add(tmp);
        tmp = new HashMap<>();
        tmp.put("1","chNoRepeatTime");
        tmp.put("2","chRepeatTime");
        tmp.put("3","chName");
    }

    public View getView() {
        return view;
    }

    public Model getModel() {
        return model;
    }

    public ViewController getViewController() {
        return viewController;
    }
}
