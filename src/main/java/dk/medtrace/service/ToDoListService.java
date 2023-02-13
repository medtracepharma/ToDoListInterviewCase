package dk.medtrace.service;

import dk.medtrace.CountAndHTMLDTO;
import dk.medtrace.ToDo;
import dk.medtrace.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class ToDoListService {

    List<ToDo> toDoList = new ArrayList();

    Repository repository;

    public ToDoListService(Repository repository) {
        this.repository = repository;
        this.toDoList = repository.getList();
    }
    public CountAndHTMLDTO countCompletedAndFormatHTML() {
        String html = "<HTML>";
        int count = 0;
        html = html + "<ul>";
        for(int i = 0; i < toDoList.size(); i++) {
            html = html + toDoList.get(count);
            count++;
        }
        html = html + "</ul>";
        html = html + "<div>Total finished entries ${number}</div>";
        CountAndHTMLDTO dto = new CountAndHTMLDTO();
        dto.setCount(count);
        dto.setHtml(html);
        return dto;
    }

    public boolean saveToDatabase() {
        // TODO:
        return true;
    }
}
