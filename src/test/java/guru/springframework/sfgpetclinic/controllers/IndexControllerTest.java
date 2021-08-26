package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.controllers.exceptions.OupsHandlerWithNoArgumentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}