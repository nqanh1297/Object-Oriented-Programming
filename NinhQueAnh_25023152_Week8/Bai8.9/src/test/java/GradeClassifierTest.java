import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GradeClassifierTest {

    // =========================
    // EP tests
    // =========================

    @Test
    void testEP_Yeu() {
        assertEquals("Yếu", GradeClassifier.classifyGrade(4.0));
    }

    @Test
    void testEP_TrungBinh() {
        assertEquals("Trung bình", GradeClassifier.classifyGrade(5.5));
    }

    @Test
    void testEP_Kha() {
        assertEquals("Khá", GradeClassifier.classifyGrade(7.0));
    }

    @Test
    void testEP_Gioi() {
        assertEquals("Giỏi", GradeClassifier.classifyGrade(9.0));
    }

    @Test
    void testEP_InvalidLow() {
        assertThrows(IllegalArgumentException.class, () -> {
            GradeClassifier.classifyGrade(-1.0);
        });
    }

    @Test
    void testEP_InvalidHigh() {
        assertThrows(IllegalArgumentException.class, () -> {
            GradeClassifier.classifyGrade(10.5);
        });
    }

    // =========================
    // BVA tests
    // =========================

    @Test
    void testBVA_0_0() {
        assertEquals("Yếu", GradeClassifier.classifyGrade(0.0));
    }

    @Test
    void testBVA_5_0() {
        assertEquals("Trung bình", GradeClassifier.classifyGrade(5.0));
    }

    @Test
    void testBVA_6_5() {
        assertEquals("Khá", GradeClassifier.classifyGrade(6.5));
    }

    @Test
    void testBVA_8_0() {
        assertEquals("Giỏi", GradeClassifier.classifyGrade(8.0));
    }

    @Test
    void testBVA_10_0() {
        assertEquals("Giỏi", GradeClassifier.classifyGrade(10.0));
    }
}
