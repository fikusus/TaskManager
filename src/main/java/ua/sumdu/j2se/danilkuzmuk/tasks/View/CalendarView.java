package ua.sumdu.j2se.danilkuzmuk.tasks.View;

import ua.sumdu.j2se.danilkuzmuk.tasks.Model.TaskList;
import ua.sumdu.j2se.danilkuzmuk.tasks.Model.Tasks;

import java.util.*;

public class CalendarView {
    public  void drawCalendar(int month, int year, TaskList taskList) {
        month--;
        HashSet<Integer> dayWithTask = new HashSet<>();
        Calendar beginningOfMonth = setTimeToBeginningOfMonth(month,year);
        Calendar endOfMonth = setTimeToEndofMonth(month,year);
        Iterator<Date> dateIterator =  Tasks.calendar(taskList.clone(),beginningOfMonth.getTime(),endOfMonth.getTime()).keySet().iterator();
        while (dateIterator.hasNext()){
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(dateIterator.next());
            dayWithTask.add(calendar.get(Calendar.DAY_OF_MONTH));

        }
        String[] months = {
                "Январь", "Февраль", "Март",
                "Апрель", "Май", "Июнь",
                "Июль", "Август", "Сентябрь",
                "Октябрь", "Ноябрь", "Декабрь"};
        System.out.println("   " + months[month] + " " + year);
        System.out.println("Пн Вт Ср Чт Пт Сб Вс");
        int d = beginningOfMonth.get(Calendar.DAY_OF_WEEK) - 2;
        for (int i = 0; i < d; i++)
            System.out.print("   ");
        for (int i = 1; i <= beginningOfMonth.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            if (dayWithTask.contains(i))
                System.out.print("\u001B[31m");
            System.out.printf("%2d \u001B[0m", i);
            if (((i + d) % 7 == 0) || (i == beginningOfMonth.getActualMaximum(Calendar.DAY_OF_MONTH)))
                System.out.println();
        }
    }
    private Calendar setTimeToBeginningOfMonth(int month, int year) {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    private Calendar setTimeToEndofMonth(int month, int year) {
        Calendar calendar =  setTimeToBeginningOfMonth(month,year);
        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar;
    }
}