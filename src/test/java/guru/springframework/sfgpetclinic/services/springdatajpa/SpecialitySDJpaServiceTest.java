package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

    @Mock
    private SpecialtyRepository specialtyRepository;

    @InjectMocks
    private SpecialitySDJpaService service;

    @Test
    void delete() {
        service.delete(new Speciality());

        // It verifies if the dependency has been called the number of times expected
        verify(specialtyRepository, times(1)).delete(new Speciality());
    }

    @Test
    void deleteById() {
        service.deleteById(1l);

        verify(specialtyRepository, atLeastOnce()).deleteById(1l);
        verify(specialtyRepository, never()).deleteById(1L);
    }

    @Test
    void findById() {
        // given
        Speciality speciality = new Speciality();
        when(specialtyRepository.findById(1l)).thenReturn((Optional.of(speciality)));

        // when
        Optional<Speciality> found = specialtyRepository.findById(1L);

        // then
        assertThat(found).isNotNull();
        verify(specialtyRepository.findById(1L), times(1));
    }
}