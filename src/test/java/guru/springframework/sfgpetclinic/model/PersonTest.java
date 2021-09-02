package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void groupedAssertions() {
        // given
        Person person = new Person(1l, "Breno", "Val");

        //then
        assertAll("Testing Props Set",
                () -> assertEquals( "Breno", person.getFirstName(),"First Name Failed"),
                () -> assertEquals( "Val", person.getLastName(),"Second Name First")
        );
    }
}