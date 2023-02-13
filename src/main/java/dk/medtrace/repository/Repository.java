package dk.medtrace.repository;

import dk.medtrace.ToDo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Repository {
    public boolean isTestMode() {
        return testMode;
    }

    public void setTestMode(boolean testMode) {
        this.testMode = testMode;
    }

    boolean testMode = true;

    List<ToDo> entries;

    /**
     * Constructor sets the test mode so that we can work on test data when testing.
     */
    public Repository() {
        if (testMode) {
            readTestData();
        }
    }

    public List<ToDo> getList() {
        return entries;
    }

    private void readTestData() {
        entries = new ArrayList<>(100);
        ToDo todo1 = new ToDo();
        todo1.setDate(new Date());
        todo1.setText("Todo stuff");
        todo1.setPriority(1);
        todo1.setDone(true);
        entries.add(todo1);
        ToDo todo2 = new ToDo();
        todo2.setDate(new Date(1, 2, 2023));
        todo2.setText("More stuff");
        todo2.setPriority(0);
        entries.add(todo1);
    }
}
