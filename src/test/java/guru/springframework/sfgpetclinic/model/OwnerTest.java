package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void dependentAssertions() {

        Owner owner = new Owner(1l, "Breno", "Val");
        owner.setCity("Srs");
        owner.setTelephone("123456789");

        assertAll("Props Set Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Breno", owner.getFirstName(), "First Name Did Not Match"),
                        () -> assertEquals("Val", owner.getLastName(), "Last Name Did Not Match")),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Srs", owner.getCity(), "City Name Did Not Match"),
                        () -> assertEquals("123456789", owner.getTelephone(), "Phone Name Did Not Match"))
        );
    }
}