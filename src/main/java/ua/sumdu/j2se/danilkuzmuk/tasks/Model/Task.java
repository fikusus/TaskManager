package ua.sumdu.j2se.danilkuzmuk.tasks.Model;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;


/**
 * Класс задач расписания дня.
 * @author Кузьмук Данила
 */
public class Task implements Cloneable {
    private String title;
    private Date time;
    private Date start;
    private Date end;
    private int interval;
    private boolean active = true;
    private boolean repeated;

    /**
     * Конструктор - создание нового объекта
     * @param title - название задачи
     * @param time - время выполнения задачи
     */
    public Task(String title, Date time) {
        this.title = title;
        this.time = time;
        interval = 0;
    }

    /**
     * Конструктор - создание нового объекта
     * @param title - название задачи
     * @param start - начало задачи
     * @param end - конец задачи
     * @param interval - промежуток выполнения
     */
    public Task(String title, Date start, Date end, int interval) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
        repeated = true;
    }

    /**
     * Метод возврата значения поля {@link Task#title}
     * @return возвращает название задачи
     */
    public String getTitle() {
        return title;
    }

    /**
     * Метод задания имени задачи {@link Task#title}
     * @param title - имя задачи
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Метод возврата значения поля {@link Task#active}
     * @return состояние задачи
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Метод задания состояния{@link Task#title}
     * @param active - параметр активности
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Метод возврата значения времини задачи
     * Задача неповторимая
     * @return возвращает время выполнения задачи
     */
    public Date getTime() {
        if (repeated) {
            return start;
        } else {
            return time;
        }
    }

    /**
     * Метод задания времени задачи{@link Task#time}
     * Задача повторимая
     * @param time - время задачи
     */
    public void setTime(Date time) {
        start = null;
        end = null;
        interval = 0;
        this.time = time;
        repeated = false;
    }

    /**
     * Метод возврата времени начала задачи
     * Задача повторимая
     * @return возвращает время начала задачи
     */
    public Date getStartTime() {
        if (repeated) {
            return start;
        } else {
            return time;
        }
    }

    /**
     * Метод возврата времени конца задачи
     * Задача повторимая
     * @return возвращает время конца задачи
     */
    public Date getEndTime() {
        if (repeated) {
            return end;
        } else {
            return time;
        }
    }

    /**
     * Метод возврата интервала задачи
     * Задача повторимая
     * @return возвращает интервал задачи
     */
    public int getRepeatInterval() {
        if (repeated) {
            return interval;
        } else {
            return 0;
        }
    }
    /**
     * Метод задания задачи с повторением
     * Задача повторимая
     * @param start - время начала задачи
     * @param end - время конца задачи
     * @param interval - интервал задачи
     */
    public void setTime(Date start, Date end, int interval) {
        this.start = start;
        this.end = end;
        this.interval = interval;
        time = null;
        repeated = true;
    }

    /**
     * Метод проверки повторяемости задачи
     * @return проверяет повторяемость задачи
     */
    public boolean isRepeated() {
        return repeated;
    }
    /**
     * Метод нахождения следующего
     * момента исполнения задачи.
     * @return возвращает время следующей задачи
     * @param current текущее время
     */
    public Date nextTimeAfter(Date current) {
        if (active) {
            if (repeated) {
                Date temp = (Date) start.clone();
                while (temp.before(current) || temp.equals(current)) {
                    temp.setTime(temp.getTime() + interval * 1000);
                }
                if (temp.after(end)) {
                    return null;
                } else {
                    return temp;
                }
            } else {
                if (time.after(current)) {
                    return time;
                } else {
                    return null;
                }
            }
        } else {
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return interval == task.interval &&
                active == task.active &&
                repeated == task.repeated &&
                Objects.equals(title, task.title) &&
                Objects.equals(time, task.time) &&
                Objects.equals(start, task.start) &&
                Objects.equals(end, task.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, time, start, end, interval, active, repeated);
    }

    @Override
    public String toString() {
        String str = new String();
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        if (repeated) {
            str += "Задача:'" + title+ "'" + " Время начала: " + dateFormat.format(start) + " Время конца: " + dateFormat.format(end) + " c интервалом: " + interval + " секунд";
            if(active){
                str+=" Задача активна";
            }else {
                str+=" Задача не активна";
            }
            str+=" с повторением";
        } else {
            str = "Задача: '" + title+ "'" + " Время исполнения: " + dateFormat.format(time);
            if(active){
                str+=" Задача активна";
            }else {
                str+=" Задача не активна";
            }
            str+=" без повторения";
        }
        return str;
    }


    @Override
    public Task clone() throws CloneNotSupportedException {
        return (Task) super.clone();
    }
}