package ua.sumdu.j2se.danilkuzmuk.tasks.Model;
import ua.sumdu.j2se.danilkuzmuk.tasks.Exceptions.IllegalIntervalException;
import ua.sumdu.j2se.danilkuzmuk.tasks.Exceptions.IllegalTaskException;

import java.io.*;


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
    public TaskList clone() {
        TaskList clone = null;
        TaskList cloned = null;
        try {
            clone = (TaskList) super.clone();
            cloned = getDeepCloning(clone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cloned;
    }
    private TaskList getDeepCloning(Object obj) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(obj);
        oos.close();
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        return (TaskList) ois.readObject();
    }
}

