package ua.sumdu.j2se.danilkuzmuk.tasks.Model;
import ua.sumdu.j2se.danilkuzmuk.tasks.Exceptions.IllegalIntervalException;
import ua.sumdu.j2se.danilkuzmuk.tasks.Exceptions.IllegalTaskException;
import java.io.Serializable;


public abstract class TaskList implements Iterable, Cloneable, Serializable {

    public abstract void add(Task task);

    public abstract boolean remove(Task task);

    public abstract int size();

    public abstract Task getTask(int index);



    public int getRemoveValue(int x) {
        if (x < size()) {
            return x;
        } else {
            throw new IllegalArgumentException("Element is outside the array");
        }
    }

    public Task getRightTask(Task x) {
        if (x.getTime().getTime() >= 0 && x.getEndTime().getTime() >= 0 && x.getEndTime().getTime() >= 0) {
            if (x.getRepeatInterval() > 0 || !x.isRepeated()) {
                if (x != null) {
                    return x;
                } else {
                    throw new IllegalTaskException("The task can not be empty");
                }
            } else {
                throw new IllegalIntervalException("Interval must be greater than zero");
            }
        } else {
            throw new IllegalArgumentException("Time can not be less than zero");
        }
    }

    @Override
    public TaskList clone() throws CloneNotSupportedException {
        return (TaskList) super.clone();
    }
}

