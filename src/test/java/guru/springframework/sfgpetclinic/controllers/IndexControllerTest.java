package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.controllers.exceptions.OupsHandlerWithNoArgumentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import static org.assertj.core.api.Assertions.assertThat;
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

        // AssertJ
        assertThat(indexController.index()).isEqualTo("index");
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

    @EnabledOnOs(OS.LINUX)
    @Test
    void testMeOnLinux() {
        System.out.println("Running on Linux");
    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    public void testMeOnJAva11() {
        System.out.println("Using JRE 11");
    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "bribeiro")
    @Test
    public void testIfUserIsBreno() {
        System.out.println("User is Breno");
    }
}