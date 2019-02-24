package ua.sumdu.j2se.danilkuzmuk.tasks.Controller;


public class ViewController {
    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }
    public void exitApp(){
        System.exit(0);
    }

    public void mainMenu(){
        controller.getView().mainMenu();
    }

    public void addSubMenu(){
        controller.getView().addSubMenu();
    }

    public void showAllTaskList(){
        controller.getView().showAllTaskList(controller.getModel().getTaskList());
    }
    public void addRepeatMenu(){
        controller.getView().addRepeatMenu();
    }

    public void addNoRepeatMenu(){
        controller.getView().addNoRepeatMenu();
    }

    public void invalidData(){
        controller.getView().invalidData();
    }
    public void incomingToday(){
        controller.getView().taskListView(controller.getModel().incomingToday());
    }
    public void incomingWeek(){
        controller.getView().taskListView(controller.getModel().incomingWeek());
    }
    public void changeMenu(){
        controller.getView().changeMenu();
    }
    public void changeTasks(int index){
        controller.getView().changeTasks(index);
    }
    public void removeMenu(){
        controller.getView().removeMenu();
    }
    public String printAndReadText(String str){
        return controller.getView().printAndReadText(str);
    }
    public void printText(String str){
        controller.getView().printText(str);
    }
    public void drawCalendar(){
        controller.getView().drawCalendar();
    }
}
