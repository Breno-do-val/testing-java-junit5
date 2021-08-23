package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
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
    void oupsHandler() {
        assertEquals("notimplemented", indexController.oupsHandler(), () -> "Some Havier Work To Do!");
    }
}