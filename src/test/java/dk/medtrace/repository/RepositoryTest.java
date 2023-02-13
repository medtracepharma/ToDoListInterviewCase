package dk.medtrace.repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tester repository brugt enten som test repository eller som rigtigt repository med database.
 */
class RepositoryTest {

    @Test
    void testTestRepository() {
        Repository repository = new Repository();
        repository.setTestMode(true);
        assertEquals(2, repository.getList().size());
    }

    @Test
    void testRealRepository() {
        Repository repository = new Repository();
        repository.setTestMode(false);
        assertNotNull(repository.getList()); // Vi ved ikke hvor mange entries der er i databasen.
    }

}