package ua.sumdu.j2se.danilkuzmuk.tasks.Model;
import java.io.Serializable;
import java.util.*;


public class Tasks implements Serializable {
    public static Iterable<Task> incoming(Iterable<Task> tasks, Date start, Date end) {
        Iterator<Task> taskIterator = tasks.iterator();
        while (taskIterator.hasNext()){
            Task tmp = taskIterator.next();
            if (tmp.nextTimeAfter(start) == null || tmp.nextTimeAfter(start).after(end)){
                taskIterator.remove();
            }
        }
        return tasks;
    }

    public static SortedMap<Date, Set<Task>> calendar(Iterable<Task> tasks, Date start, Date end){
        HashSet<Task> buffSet = new HashSet<>();
        TreeMap<Date, Set<Task>> myMap  = new TreeMap<>();
        Iterator<Task> taskIterator = tasks.iterator();
        while (taskIterator.hasNext()){
            Task tmp = taskIterator.next();
            Date tmpDate = (Date) start.clone();
            while (tmp.nextTimeAfter(tmpDate) != null && !tmp.nextTimeAfter(tmpDate).after(end)){
                if (myMap.get(tmp.nextTimeAfter(tmpDate)) == null){
                    buffSet = new HashSet<>();
                    buffSet.add(tmp);
                    myMap.put(tmp.nextTimeAfter(tmpDate), buffSet);
                }else {
                    buffSet = (HashSet<Task>) myMap.get(tmp.nextTimeAfter(tmpDate));
                    buffSet.add(tmp);
                    myMap.put(tmp.nextTimeAfter(tmpDate), buffSet);
                }
                tmpDate.setTime(tmp.nextTimeAfter(tmpDate).getTime());
            }
        }
        return  myMap;
    }

}
