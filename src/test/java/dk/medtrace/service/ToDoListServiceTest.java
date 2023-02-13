package dk.medtrace.service;

import dk.medtrace.CountAndHTMLDTO;
import dk.medtrace.ToDo;
import dk.medtrace.repository.Repository;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tester ToDoListService.
 */
class ToDoListServiceTest {

    Repository repository = new Repository();
    @Test
    void testGeneration() {
        ToDoListService service = new ToDoListService(repository);
        CountAndHTMLDTO dto = service.countCompletedAndFormatHTML();
        assertEquals(2, dto.getCount());
        String html = dto.getHtml();
        Pattern pattern = Pattern.compile("<li>");
        Matcher matcher = pattern.matcher(html);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        assertEquals(2, dto.getCount());
        assertEquals(2, count);
    }

    @Test
    void testSaveToDatabase() {
        ToDoListService service = new ToDoListService(repository);
        ToDo todo1 = new ToDo();
        todo1.setDone(false);
        todo1.setText("New item");
        todo1.setDate(new Date());
        todo1.setPriority(7);
        service.toDoList.add(todo1);
        assertTrue(service.saveToDatabase());

    }
}