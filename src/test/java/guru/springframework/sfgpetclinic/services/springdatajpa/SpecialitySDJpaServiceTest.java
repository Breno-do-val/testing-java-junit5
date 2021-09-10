package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

    @Mock
    private SpecialtyRepository specialtyRepository;

    @InjectMocks
    private SpecialitySDJpaService service;

    @Test
    void delete() {
        // given
        Speciality speciality = new Speciality();

        // when
        service.delete(speciality);

        // then
        then(specialtyRepository).should().delete(any(Speciality.class));
        then(specialtyRepository).shouldHaveNoMoreInteractions();
    }

    @Test
    void deleteByObject() {
        // given
        Speciality object = new Speciality();

        // when
        service.delete(object);

        // then
        then(specialtyRepository).should().delete(any(Speciality.class));
    }

    @Test
    void deleteById() {
        // given - none

        // when
        service.deleteById(1l);

        // then
        then(specialtyRepository).should(atLeastOnce()).deleteById(anyLong());
        then(specialtyRepository).should(never()).deleteById(5L);
    }

    @Test
    void findById() {
        // given
        Speciality speciality = new Speciality();
        given(specialtyRepository.findById(anyLong())).willReturn(Optional.of(speciality));

        // when
        Optional<Speciality> found = specialtyRepository.findById(1L);

        // then
        assertThat(found).isNotNull();
        assertThat(found).isInstanceOf(Optional.class);
        then(specialtyRepository).should().findById(anyLong());
        then(specialtyRepository).shouldHaveNoMoreInteractions();
    }

    @Test
    void findByIdNull() {
        // given
        Speciality speciality = new Speciality();
        given(specialtyRepository.findById(anyLong())).willReturn(null);

        // when
        Optional<Speciality> found = specialtyRepository.findById(1L);

        // then
        assertThat(found).isNull();
        then(specialtyRepository).should().findById(anyLong());
        then(specialtyRepository).shouldHaveNoMoreInteractions();
    }

    @Test
    void findAll() {
        // given
        Speciality speciality = new Speciality();
        Set<Speciality> specialitySet = new HashSet<>();
        specialitySet.add(speciality);
        given(specialtyRepository.findAll()).willReturn(specialitySet);

        // when
        Set<Speciality> foundSpecialties = service.findAll();

        // then
        assertThat(specialitySet).hasSize(1);
        then(specialtyRepository).should().findAll();
        then(specialtyRepository).shouldHaveNoMoreInteractions();
    }

    @Test
    void save() {
        // given
        Speciality speciality = new Speciality();
        given(specialtyRepository.save(any(Speciality.class))).willReturn(speciality);

        // when
        Speciality savedSpecialty = service.save(speciality);

        // then
        assertThat(savedSpecialty).isNotNull();
        then(specialtyRepository).should().save(speciality);
        then(specialtyRepository).shouldHaveNoMoreInteractions();
    }
}