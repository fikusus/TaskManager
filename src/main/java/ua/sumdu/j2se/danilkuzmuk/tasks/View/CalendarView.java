package ua.sumdu.j2se.danilkuzmuk.tasks.View;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarView {
    public  void drawCalendar(int month, int year) {
        month--;
        Calendar cln = new GregorianCalendar();
        cln.set(Calendar.YEAR,year);
        cln.set(Calendar.MONTH,month);
        cln.set(Calendar.DAY_OF_MONTH,1);
        String[] months = {
                "Январь", "Февраль", "Март",
                "Апрель", "Май", "Июнь",
                "Июль", "Август", "Сентябрь",
                "Октябрь", "Ноябрь", "Декабрь"};
        System.out.println("   " + months[month] + " " + year);
        System.out.println("Пн Вт Ср Чт Пт Сб Вс");
        int d = cln.get(Calendar.DAY_OF_WEEK) - 2;
        for (int i = 0; i < d; i++)
            System.out.print("   ");
        for (int i = 1; i <= cln.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            System.out.printf("%2d ", i);
            if (((i + d) % 7 == 0) || (i == cln.getActualMaximum(Calendar.DAY_OF_MONTH)))
                System.out.println();
        }
    }
}