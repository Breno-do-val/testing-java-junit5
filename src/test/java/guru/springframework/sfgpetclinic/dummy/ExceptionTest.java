package guru.springframework.sfgpetclinic.dummy;

import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import guru.springframework.sfgpetclinic.services.springdatajpa.SpecialitySDJpaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
public class ExceptionTest {

    @Mock
    private SpecialtyRepository specialtyRepository;

    @InjectMocks
    private SpecialitySDJpaService service;

    @Test
    void shouldThrowsException() {
        // given
        given(specialtyRepository.findById(1L)).willThrow(new RuntimeException("oops..."));

        // when
        assertThrows(RuntimeException.class, () -> service.findById(1L));

        // then
        then(specialtyRepository).should().findById(1L);
    }
}
