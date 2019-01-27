package ua.sumdu.j2se.danilkuzmuk.tasks.Model;
import ua.sumdu.j2se.danilkuzmuk.tasks.Exceptions.IllegalIntervalException;
import ua.sumdu.j2se.danilkuzmuk.tasks.Exceptions.IllegalTaskException;
import java.util.*;
public class ArrayTaskList extends TaskList {
    Task[] yourTasks = new Task[0];
    
    @Override
    public void add(Task task) {
        try {
            Task tempTask = getRightTask(task);
            Task[] tmp = new Task[yourTasks.length + 1];
            for (int i = 0; i < yourTasks.length; i++) {
                tmp[i] = yourTasks[i];
            }
            tmp[yourTasks.length] = task;
            yourTasks = tmp;
        } catch (IllegalTaskException b) {
            System.out.println("The task can not be empty");
        } catch (IllegalIntervalException j) {
            System.out.println("Interval must be greater than zero");
        } catch (IllegalArgumentException c) {
            System.out.println("Time can not be less than zero");
        }

    }
    
    @Override
    public boolean remove(Task task) {

        if (find(yourTasks, task) == -1) {
            return false;
        } else {
            yourTasks = removeElement(yourTasks, find(yourTasks, task));
            return true;
        }
    }
    @Override
    public int size() {
        return yourTasks.length;
    }
    @Override
    public Task getTask(int index) {
        try {
            int tmp = getRemoveValue(index);
            return yourTasks[tmp];
        } catch (IllegalArgumentException e) {
            System.out.println("You are trying to find an array element that is outside the array");
            return null;
        }


    }


    public int find(Task[] array, Task value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public Task[] removeElement(Task[] original, int element) {

        Task[] tmp = new Task[original.length - 1];
        for (int i = 0; i < original.length; i++) {
            if (i < element) {
                tmp[i] = original[i];
            }
            if (i > element) {
                tmp[i - 1] = original[i];
            }
        }
        return tmp;
    }

    public Task[] addElement(Task e) {
        Task[] tmp = new Task[yourTasks.length + 1];
        for (int i = 0; i < yourTasks.length; i++) {
            tmp[i] = yourTasks[i];
        }
        tmp[yourTasks.length] = e;
        return tmp;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayTaskList that = (ArrayTaskList) o;
        boolean tmp = true;
        if (that.yourTasks.length == this.yourTasks.length) {
            for (int i = 0; i < that.yourTasks.length; i++) {
                if (!that.yourTasks[i].equals(that.yourTasks[i])) {
                    tmp = false;
                }
            }
            return tmp;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(yourTasks);
    }

    @Override
    public String toString() {
        return "ArrayTaskList{" 
        + "Your Tasks=" 
        + Arrays.toString(yourTasks) 
        + '}';
    }

    @Override
    public Iterator<Task> iterator() {
        return new ArrayIterator();
    }
    private class ArrayIterator implements Iterator<Task> {
        int cursor;
        int lastRet = -1;


        public boolean hasNext() {
            return cursor != size();
        }

        public Task next() {
            if (cursor >= size()) {
                throw new NoSuchElementException();
            }
            return  ArrayTaskList.this.yourTasks[lastRet = cursor++];
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            try {

                ArrayTaskList.this.remove(getTask(lastRet));
                cursor = lastRet;
                lastRet = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }
}