package ua.sumdu.j2se.danilkuzmuk.tasks.Model;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.*;

public class TaskIO {
    private static Logger log = Logger.getLogger(LinkedTaskList.class);

    public static void write(TaskList tasks, OutputStream out) throws IOException {
        OutputStream os = new DataOutputStream(out);
        Iterator<Task> taskIterator = tasks.iterator();
        out.write(tasks.size());
        while (taskIterator.hasNext()){
            Task task = taskIterator.next();
            os.write(task.getTitle().length());
            os.write(task.getTitle().getBytes());
            ((DataOutputStream) os).writeBoolean(task.isActive());
            ((DataOutputStream) os).writeBoolean(task.isRepeated());
            if (task.isRepeated()){
                ((DataOutputStream) os).writeLong(task.getStartTime().getTime());
                ((DataOutputStream) os).writeLong(task.getEndTime().getTime());
                ((DataOutputStream) os).writeInt(task.getRepeatInterval());
            }else {
                ((DataOutputStream) os).writeLong(task.getTime().getTime());
            }
        }
    }

    public static void read(TaskList tasks, InputStream in) throws IOException {
        InputStream inputStream = new DataInputStream(in);
        int size = inputStream.read();
        for (int i = 0; i < size;i++){
            int titleSize = inputStream.read();
            byte[] tmp = new byte[titleSize];
            for (int j = 0;j < titleSize; j++){
                tmp[j] = (byte) inputStream.read();
            }
            String title = new String(tmp);
            boolean tmpActive = ((DataInputStream) inputStream).readBoolean();
            if (((DataInputStream) inputStream).readBoolean()){
                Date tmpStartTime = new Date(((DataInputStream) inputStream).readLong());
                Date tmpEndTime = new Date(((DataInputStream) inputStream).readLong());
                int tmpInterval = ((DataInputStream) inputStream).readInt();
                Task task = new Task(title,tmpStartTime,tmpEndTime,tmpInterval);
                task.setActive(tmpActive);
                tasks.add(task);
            }else{
                Date tmpTime = new Date(((DataInputStream) inputStream).readLong());
                Task task = new Task(title,tmpTime);
                task.setActive(tmpActive);
                tasks.add(task);
            }
        }
    }

    public static void writeBinary(TaskList tasks, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            write(tasks, fileOutputStream);
        }finally {
            fileOutputStream.close();
        }
    }

    public static void readBinary(TaskList tasks, File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            read(tasks, fileInputStream);
        }finally {
            fileInputStream.close();
        }
    }

    public static void write(TaskList tasks, Writer out) throws IOException {
        BufferedWriter output = new BufferedWriter(out);
        String tmp;
        Iterator<Task> taskIterator = tasks.iterator();
        while (taskIterator.hasNext()){
            tmp = new String();
            Task task = taskIterator.next();
            tmp +=  '"';
            for(int i = 0; i < task.getTitle().length();i++){
                tmp+= task.getTitle().charAt(i);
                if(task.getTitle().charAt(i) == '"'){
                    tmp+= '"';
                }
            }
            tmp +=  '"';
            if (task.isRepeated()) {
                Calendar startCal = new GregorianCalendar();
                startCal.setTime(task.getStartTime());
                Calendar endCal = new GregorianCalendar();
                endCal.setTime(task.getEndTime());
                tmp += " from " + '[' + (startCal.get(Calendar.YEAR)) + '-' + startCal.get(Calendar.MONTH) + '-' + startCal.get(Calendar.DAY_OF_MONTH) + ' ' + startCal.get(Calendar.HOUR) + ':' + startCal.get(Calendar.MINUTE) + ':' + startCal.get(Calendar.SECOND)+ '.' + startCal.get(Calendar.MILLISECOND) + ']';
                tmp += " to " + '[' + (endCal.get(Calendar.YEAR)) + '-' + endCal.get(Calendar.MONTH) + '-' + endCal.get(Calendar.DAY_OF_MONTH) + ' ' + endCal.get(Calendar.HOUR) + ':' + endCal.get(Calendar.MINUTE) + ':' + endCal.get(Calendar.SECOND)+ '.' + endCal.get(Calendar.MILLISECOND) + ']';
                int[] massMultipliers = {86400, 3600, 60, 1};
                String[] massName = {"day", "hour", "minute", "second"};
                int currInterval = task.getRepeatInterval();
                tmp += " [";
                for (int i = 0; i < 4; i++) {
                    int countInterval = (int) Math.floor(currInterval / massMultipliers[i]);
                    currInterval -= countInterval * massMultipliers[i];
                    if (countInterval > 0) {
                        tmp += countInterval + " " + massName[i];
                        if (countInterval >= 1) {
                            tmp += 's';
                        }
                    }
                }
                tmp+="]";
            }else {
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(task.getTime());
                tmp += " at " + '[' + (calendar.get(Calendar.YEAR)) + '-' + calendar.get(Calendar.MONTH) + '-' + calendar.get(Calendar.DAY_OF_MONTH) + ' ' + calendar.get(Calendar.HOUR) + ':' + calendar.get(Calendar.MINUTE) + ':' + calendar.get(Calendar.SECOND)+ '.' + calendar.get(Calendar.MILLISECOND) + ']';
            }
            if (task.isActive()){
                tmp += " inactive";
            }
            if (taskIterator.hasNext()){
                tmp+=';';
            }else {
                tmp += '.';
            }
            output.write(tmp);
            output.newLine();
            output.flush();
        }
    }

    public static void read(TaskList tasks, Reader in) throws IOException {
        BufferedReader reader = new BufferedReader(in);
        String myTaskinform = new String();
        while (reader.ready()){
            int curr = 1;
            boolean repeated;
            myTaskinform = reader.readLine();
            String title = new String();
            while (true){
                if (myTaskinform.charAt(curr) == '"'){
                    if(myTaskinform.charAt(curr + 1) == '"'){
                        title+=myTaskinform.charAt(curr);
                        curr+=2;
                    }else{
                        curr+=2;
                        break;
                    }
                }else {
                    title+=myTaskinform.charAt(curr);
                    curr++;
                }
            }
            if (myTaskinform.charAt(curr) == 'a'){
                curr+=4;
                String tmp = new String();
                while (myTaskinform.charAt(curr) != ']'){
                    tmp+=myTaskinform.charAt(curr);
                    curr++;
                }
                curr+=2;
                Date time = parsDate(tmp);
                Task myTask = new Task(title,time);
                if (curr < myTaskinform.length()){
                    myTask.setActive(true);
                }
                tasks.add(myTask);
            }else{
                int inteval = 0;
                curr+=6;
                String tmp = new String();
                while (myTaskinform.charAt(curr) != ']'){
                    tmp+=myTaskinform.charAt(curr);
                    curr++;
                }
                curr+=6;
                Date startTime = parsDate(tmp);
                tmp = new String();
                while (myTaskinform.charAt(curr) != ']'){
                    tmp+=myTaskinform.charAt(curr);
                    curr++;
                }
                curr+=3;
                Date endTime = parsDate(tmp);
                while (myTaskinform.charAt(curr ) != ']'){
                    tmp = new String();
                    while (myTaskinform.charAt(curr) != ' ' && myTaskinform.charAt(curr + 1) != ']'){
                        tmp+=myTaskinform.charAt(curr);
                        curr++;
                    }
                    try {
                        int a = Integer.parseInt(tmp);
                        curr++;
                        switch (myTaskinform.charAt(curr)){
                            case 'd':
                                inteval+=a*24*3600;
                                break;
                            case 'h':
                                inteval+=a*3600;
                                break;
                            case 'm':
                                inteval+=a*60;
                                break;
                            case 's':
                                inteval+=a;
                                break;
                        }
                    }catch (NumberFormatException e){
                        curr++;
                    }
                }
                curr+=2;
                Task myTask = new Task(title,startTime,endTime,inteval);
                if (curr < myTaskinform.length()){
                    myTask.setActive(true);
                }
                tasks.add(myTask);
            }
        }
    }

    public static void writeText(TaskList tasks, File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file,false);
        try {
            write(tasks, fileWriter);
        }finally {
            fileWriter.close();
        }
    }

    public static void readText(TaskList tasks, File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        try {
            read(tasks, fileReader);
        }finally {
            fileReader.close();
        }
    }

    public static Date parsDate(String pars){
        pars+=']';
        int curr = 0;
        Calendar time = new GregorianCalendar();
        char[] pointer = {'-','-',' ',':',':','.',']'};
        int [] dates = new int[7];
        for (int i = 0;i < 7;i++){
            int timeTemp;
            String tmp = new String();
            while (pars.charAt(curr) != pointer[i]){
                tmp+=pars.charAt(curr);
                curr++;
            }
            curr++;
            dates[i] = Integer.parseInt(tmp);
        }
        time.set(Calendar.YEAR,dates[0]);
        time.set(Calendar.MONTH,dates[1]);
        time.set(Calendar.DAY_OF_MONTH,dates[2]);
        time.set(Calendar.HOUR,dates[3]);
        time.set(Calendar.MINUTE,dates[4]);
        time.set(Calendar.SECOND,dates[5]);
        time.set(Calendar.MILLISECOND,dates[6]);
        Date myTime = new Date(time.getTimeInMillis());
        return myTime;
    }
}
