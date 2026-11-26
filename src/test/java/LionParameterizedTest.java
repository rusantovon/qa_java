import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final Feline feline = Mockito.mock(Feline.class);
    private final String sex;
    private final boolean expectedHasMane;
    private Lion lion;

    public LionParameterizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters(name = "Пол={0}, грива={1}")
    public static Object[][] testData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Before
    public void setUp() throws Exception {
        lion = new Lion(sex, feline);
    }

    @Test
    public void doesHaveManeParameterizedTest() {
        boolean actualHasMane = lion.doesHaveMane();

        assertEquals(expectedHasMane, actualHasMane);
    }
}
