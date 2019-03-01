package ua.sumdu.j2se.danilkuzmuk.tasks.Model;
import org.apache.log4j.Logger;
import ua.sumdu.j2se.danilkuzmuk.tasks.Exceptions.IllegalIntervalException;
import ua.sumdu.j2se.danilkuzmuk.tasks.Exceptions.IllegalTaskException;
import java.util.*;
public class LinkedTaskList extends TaskList  {
    private Node first;
    private Node last;
    private int length;
    private Logger log = Logger.getLogger(LinkedTaskList.class);
    @Override
    public void add(Task task) {
        try {
            Task tempTask = getRightTask(task);
            Node newNode = new Node(tempTask);
            if (first == null) {
                newNode.setNext(null);
                newNode.setPrevious(null);
                first = newNode;
                last = newNode;
            } else {
                last.setNext(newNode);
                newNode.setPrevious(last);
                last = newNode;
            }
            length++;
        } catch (IllegalTaskException b) {
            log.info("Задача не может быть пустой");
        } catch (IllegalIntervalException j) {
            log.error("Интервал должен быть больше нуля");
        } catch (IllegalArgumentException c) {
            log.info("Время должно быть больше нуля");
        }

    }
    @Override
    public boolean remove(Task task) {
        if (removeElement(first, task) == null) {
            return false;
        } else {
            length--;
            return true;
        }
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public Task getTask(int index) {
        try {
            int tmp = getRemoveValue(index);
            return find(tmp);
        } catch (IllegalArgumentException e) {
            log.error("Вы пытаетесь найти задачу которая находиться за массивом");
            return null;
        }

    }

    public Node removeElement(Node e, Task task) {

        if (e.getElement().equals(task)) {
            if (first.equals(e)) {
                first = e.getNext();
            }
            if (last.equals(e)) {
                last = e.getPrevious();
            }
            if (e.getNext() != null) {
                if (e.getElement() != null) {
                    e.getNext().setPrevious(e.getPrevious());
                } else {
                    e.getNext().setPrevious(null);
                }
            }
            if (e.getPrevious() != null) {
                if (e.getNext() != null) {
                    e.getPrevious().setNext(e.getNext());
                } else {
                    e.getPrevious().setNext(null);
                }
            }

            return e;
        } else {
            if (e.getNext() == null) {
                return null;
            } else {
                return removeElement(e.getNext(), task);
            }
        }
    }



    public Task find(int index) {
        Node e = first;
        for (int i = 0; e != null; i++) {
            if (i == index) {
                return e.getElement();
            }
            e = e.getNext();
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LinkedTaskList that = (LinkedTaskList) o;
        if (that.length == this.length) {
            for (int i = 0; i < this.length; i++) {
                if (!this.getTask(i).equals(that.getTask(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        Task hashTmp[] = new Task[length];
        Node e = first;
        for (int i = 0; e != null; i++) {
            hashTmp[i] = e.getElement();
            e = e.getNext();
        }
        return Arrays.hashCode(hashTmp);
    }


    @Override
    public Iterator<Task> iterator() {
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator<Task> {

        private Node lastRet = new Node(null, LinkedTaskList.this.first, null);
        private Node cursor = lastRet.getNext();

        public boolean hasNext() {
            return lastRet.getNext() != null;
        }
        
        public Task next() {
            if (lastRet.getNext() != null) {
                lastRet = cursor;
                cursor = cursor.getNext();
                return lastRet.getElement();
            } else {
                throw new NoSuchElementException();
            }
        }
        
        public void remove() {
            if (lastRet.getElement() == null)
                throw new IllegalStateException();
            removeElement(lastRet, lastRet.getElement());
        }
    }
    
    
    @Override
    public String toString() {
        return "LinkedTaskList{" 
        + "first=" + first 
        + ", last=" + last 
        + ", length=" + length 
        + '}';
    }

    class Node {
        private Task element;
        private Node next;
        private Node previous;

        public Node(Task element) {
            this.element = element;
        }
        public Node(Task element, Node next, Node previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }
        public Task getElement() {
            return element;
        }

        public void setElement(Task element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }



        @Override
        public int hashCode() {
            return Objects.hash(element, next, previous);
        }
        @Override
        public String toString() {
            return "Node{" 
            + "element=" + element 
            + ", next=" + next 
            + ", previous=" + previous 
            + '}';
        }
    }
}