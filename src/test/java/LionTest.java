import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertThrows;

public class LionTest {

    private final Feline feline = Mockito.mock(Feline.class);

    @Test
    public void invalidSexTest() {
        assertThrows(
                Exception.class,
                () -> new Lion("Неизвестный", feline)
        );
    }
}
