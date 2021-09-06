package guru.springframework.sfgpetclinic.dummy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

public class MockAnnotationTest {

    @Mock
    Map<String, Object> mapMock;

    @BeforeEach
    void setUp() {
        // This static method is deprecated
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testMockAnnotation() {
        mapMock.put("foo", "bar");
    }
}
