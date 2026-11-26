import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class LionTest {

    private final Feline feline = Mockito.mock(Feline.class);
    private Lion lion;

    @Before
    public void setUp() throws Exception {
        lion = new Lion("Самец", feline);
    }

    @Test
    public void getKittensTest() {
        int expected = 5;
        Mockito.when(feline.getKittens()).thenReturn(expected);

        int actual = lion.getKittens();

        assertEquals(expected, actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);

        List<String> actual = lion.getFood();

        assertEquals(expected, actual);
    }

    @Test
    public void invalidSexTest() {
        assertThrows(Exception.class, () -> new Lion("Неизвестный", feline));
    }

    @Test
    public void invalidSexMessageTest() {
        String actualMessage = null;
        try {
            new Lion("Неизвестный", feline);
        } catch (Exception exception) {
            actualMessage = exception.getMessage();
        }

        assertEquals(
                "Используйте допустимые значения пола животного - Самец или Самка",
                actualMessage
        );
    }
}
