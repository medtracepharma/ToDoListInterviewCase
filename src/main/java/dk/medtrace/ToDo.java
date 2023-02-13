package dk.medtrace;


import java.util.Date;
import java.util.Objects;

public class ToDo {

    public static String SEPARATOR = " ";
    public static String START_TAG = "<li>";

    public static String getEndTag() {
        return END_TAG;
    }

    public static void setEndTag(String endTag) {
        END_TAG = endTag;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public static String END_TAG = "</li>";
    Date date = new Date();
    String text;
    boolean isDone = false;

    int priority = 2;   // Default priority

    String[] priorityStrings = {"URGENT", "DEFAULT", "WHENEVER"};

    String[] statusStrings = {"NOT DONE", "DONE"};
    public static String getStartTag() {
        return START_TAG;
    }

    public static void setStartTag(String startTag) {
        START_TAG = startTag;
    }

    public boolean equals(ToDo toDo) {
        if (toDo == null || getClass() != toDo.getClass()) return false;
        return isDone == toDo.isDone && priority == toDo.priority && Objects.equals(date, toDo.date) && Objects.equals(text, toDo.text);
    }

    public int hashCode() {
        return 42;
    }

    public String toString() {
        return START_TAG + SEPARATOR +
                text + SEPARATOR + date.toString() + SEPARATOR +
                priorityStrings[priority] + SEPARATOR +
                statusStrings[isDone() ? 1: 2] + END_TAG;
    }

}
