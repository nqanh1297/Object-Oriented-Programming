import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestMathUtils {
    @BeforeAll
    static void setUpBeforeAll() {
        System.out.println("=== Bắt đầu chạy test ===");
    }

    @AfterAll
    static void tearDownAfterAll() {
        System.out.println("=== Kết thúc test ===");
    }
    @Test
    public void testMax(){
        MathUtils mathUtils = new MathUtils();
        int maxx = mathUtils.max(2,3);
        assertEquals(3,maxx);
    }
    @Test
    public void testDivide() {
        MathUtils mathUtils = new MathUtils();
        int dev = mathUtils.divide(6,2);
        assertEquals(3,dev);
    }
    @Test
    public void testDivideByZero() {
        MathUtils mathUtils = new MathUtils();
        assertThrows(IllegalArgumentException.class,() -> {
            MathUtils.divide(5,0);
        });
    }
}
