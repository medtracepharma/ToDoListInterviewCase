package dk.medtrace;

import dk.medtrace.repository.Repository;
import dk.medtrace.service.ToDoListService;

/**
 * Genererer en liste af todos i HTML format.
 *
 * @Copyright Konsulkent 2023.
 */
public class Main {
    public static void main(String[] args) {

        Repository repository = new Repository();
        ToDoListService service = new ToDoListService(repository);

        System.out.println("ToDoList Generator");
        CountAndHTMLDTO dto = service.countCompletedAndFormatHTML();
        String htmlOut = dto.html.replace("${count}", Integer.toString(dto.getCount()));
        System.out.println(dto.html);
        System.exit(0);
    }
}