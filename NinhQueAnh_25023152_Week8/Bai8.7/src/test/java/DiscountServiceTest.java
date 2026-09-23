import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DiscountServiceTest {

    @Test
    void testPriceNegative() {
        assertThrows(IllegalArgumentException.class, () ->
                DiscountService.calculateDiscount(-1, "GUEST"));
    }

    @Test
    void testGuestUnder100() {
        assertEquals(0.0, DiscountService.calculateDiscount(50, "GUEST"));
    }

    @Test
    void testGuestOverOrEqual100() {
        assertEquals(0.0, DiscountService.calculateDiscount(150, "GUEST"));
    }

    @Test
    void testMemberUnder100() {
        assertEquals(0.05, DiscountService.calculateDiscount(80, "MEMBER"));
    }

    @Test
    void testMemberOverOrEqual100() {
        assertEquals(0.10, DiscountService.calculateDiscount(120, "MEMBER"));
    }

    @Test
    void testVipUnder100() {
        assertEquals(0.15, DiscountService.calculateDiscount(90, "VIP"));
    }

    @Test
    void testVipOverOrEqual100() {
        assertEquals(0.20, DiscountService.calculateDiscount(200, "VIP"));
    }

    @Test
    void testInvalidMemberType() {
        assertThrows(IllegalArgumentException.class, () ->
                DiscountService.calculateDiscount(50, "STUDENT"));
    }

    @Test
    void testBoundary0() {
        assertEquals(0.05, DiscountService.calculateDiscount(0, "MEMBER"));
    }

    @Test
    void testBoundary99() {
        assertEquals(0.05, DiscountService.calculateDiscount(99, "MEMBER"));
    }

    @Test
    void testBoundary100() {
        assertEquals(0.10, DiscountService.calculateDiscount(100, "MEMBER"));
    }

    @Test
    void testBoundary101() {
        assertEquals(0.10, DiscountService.calculateDiscount(101, "MEMBER"));
    }
}
