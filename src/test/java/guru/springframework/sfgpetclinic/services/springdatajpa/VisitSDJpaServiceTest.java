package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    private VisitRepository visitRepository;

    @InjectMocks
    private VisitSDJpaService service;

    @Test
    void findAll() {
        // given
        Visit visit = new Visit();
        Set<Visit> visits = new HashSet<>();
        visits.add(visit);

        when(visitRepository.findAll()).thenReturn(visits);

        // when
        Set<Visit> foundVisits = service.findAll();

        // then
        verify(visitRepository, times(1)).findAll();
        assertThat(foundVisits).hasSize(1);
    }

    @Test
    void findById() {
        // given
        Visit visit = new Visit();
        when(visitRepository.findById(1L)).thenReturn(Optional.of(visit));

        // when
        Visit foundVisit = service.findById(1L);

        // then
        verify(visitRepository, times(1)).findById(1L);
        assertThat(visit).isInstanceOf(Visit.class);
        assertThat(visit).isNotNull();
    }

    @Test
    void save() {
        // given
        Visit visit = new Visit();
        when(visitRepository.save(any(Visit.class))).thenReturn(visit);

        // when
        Visit savedVisit = service.save(new Visit());

        // then
        verify(visitRepository, times(1)).save(any(Visit.class));
        assertThat(savedVisit).isNotNull();
        assertThat(savedVisit).isInstanceOf(Visit.class);
        assertThat(savedVisit).isNotNull();
    }

    @Test
    void delete() {
        // when
        service.delete(new Visit());

        // then
        verify(visitRepository, times(1)).delete(any(Visit.class));
    }

    @Test
    void deleteById() {
        // when
        service.deleteById(1L);

        // then
        verify(visitRepository, times(1)).deleteById(anyLong());
    }
}