import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private final Feline feline = new Feline();
    private final int kittensNumber;

    public FelineParameterizedTest(int kittensNumber) {
        this.kittensNumber = kittensNumber;
    }

    @Parameterized.Parameters(name = "Набор параметров №{index}: количество={0}")
    public static Object[][] testData() {
        return new Object[][] {
                {0},
                {1},
                {5}
        };
    }

    @Test
    public void getKittensParameterizedTest() {
        int actual = feline.getKittens(kittensNumber);

        assertEquals(kittensNumber, actual);
    }
}
