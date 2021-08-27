package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.controllers.exceptions.OupsHandlerWithNoArgumentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest {

    IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @Test
    void index() {
        assertEquals("index", indexController.index(), "Wrong VIew Returned!");
    }

    @Test
    @DisplayName("Annotation to put another meaningful name for the tests")
    void oupsHandler() {
        assertEquals("notimplemented method", indexController.oupsHandler("method"), () -> "Some Havier Work To Do!");
    }

    @Test
    void oupsHandlerException() {
        assertThrows(OupsHandlerWithNoArgumentException.class, () -> indexController.oupsHandler("variable"));
    }

    @Test
    void testAssumptionNotTrue() {
        assumeFalse("DEV".equalsIgnoreCase(System.getenv("DEV")));
    }

    @Test
    void testAssumption() {
        assumeTrue("GURU".equalsIgnoreCase("guru"));
    }


}