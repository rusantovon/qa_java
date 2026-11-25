import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private Feline feline = Mockito.mock(Feline.class);

    private final String sex;
    private final boolean expectedHasMane;

    public LionParameterizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    private Lion lion;

    @Before
    public void setUp() throws Exception {
        lion = new Lion(sex, feline);
    }

    @Test
    public void getKittensTest() {
        int expected = 1;

        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();

        assertEquals(expected, actual);
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        List<String> actual = lion.getFood();

        assertEquals(expected, actual);
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void doesHaveManeParameterizedTest() {
        boolean actualHasMane = lion.doesHaveMane();

        assertEquals(expectedHasMane, actualHasMane);
    }
}
