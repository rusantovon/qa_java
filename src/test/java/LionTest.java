import com.example.LionDependency;
import com.example.Lion;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertThrows;

public class LionTest {

    private final LionDependency dependency = Mockito.mock(LionDependency.class);

    @Test
    public void invalidSexTest() {
        assertThrows(
                Exception.class,
                () -> new Lion("Неизвестный", dependency)
        );
    }
}
