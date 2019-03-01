package ua.sumdu.j2se.danilkuzmuk.tasks;

import org.apache.log4j.Logger;
import ua.sumdu.j2se.danilkuzmuk.tasks.Controller.Controller;
import ua.sumdu.j2se.danilkuzmuk.tasks.Model.Task;
import ua.sumdu.j2se.danilkuzmuk.tasks.Model.TaskList;
import ua.sumdu.j2se.danilkuzmuk.tasks.Model.Tasks;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;

public class Notificator extends Thread {
    private Controller controller;
    private TaskList taskList;
    private TrayIcon trayIcon;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private Logger log = Logger.getLogger(Notificator.class);
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        taskList = controller.getModel().getTaskList();
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();

            java.awt.Image image = Toolkit.getDefaultToolkit().getImage("images/tray.gif");
            trayIcon = new TrayIcon(image);
            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                log.error("Ошибка при работе с ATW");
            }
        }
        while (!isInterrupted()){
            try {
                sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Date curr = new Date();
            Date past = new Date(curr.getTime() - 60000);
            String notify = new String();
                SortedMap<Date, Set<Task>> tsk = Tasks.calendar(taskList.clone(),past,curr);
                if (tsk.keySet().size() != 0) {
                    Iterator<Date> tskIter = tsk.keySet().iterator();
                    while (tskIter.hasNext()) {
                        Date keySet = tskIter.next();
                        Iterator<Task> stskIter = tsk.get(keySet).iterator();
                        notify += dateFormat.format(keySet) + "\n";
                        while (stskIter.hasNext()) {
                            Task sTask = stskIter.next();
                            notify += "   " + sTask.getTitle() + "\n";
                        }
                    }
                    trayIcon.displayMessage("Напоминание", notify, TrayIcon.MessageType.INFO);
                }
        }
    }
}
