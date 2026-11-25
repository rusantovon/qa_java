import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CatTest {

    private final Feline feline = Mockito.mock(Feline.class);
    private final Cat cat = new Cat(feline);

    @Test
    public void getSoundTest() {
        String expected = "Мяу";
        String actual = cat.getSound();

        assertEquals(expected, actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        Mockito.when(feline.eatMeat()).thenReturn(expected);
        List<String> actual = cat.getFood();

        assertEquals(expected, actual);
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }
}
