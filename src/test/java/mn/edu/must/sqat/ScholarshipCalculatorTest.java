package mn.edu.must.sqat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScholarshipCalculatorTest {

    ScholarshipCalculator calc = new ScholarshipCalculator();

    @Test
    void testLetterGrade_A() {
        assertEquals("A", calc.letterGrade(90));
        assertEquals("A", calc.letterGrade(100));
        assertEquals("A", calc.letterGrade(95));
    }

    @Test
    void testLetterGrade_B() {
        assertEquals("B", calc.letterGrade(80));
        assertEquals("B", calc.letterGrade(89.99));
    }

    @Test
    void testLetterGrade_C() {
        assertEquals("C", calc.letterGrade(70));
        assertEquals("C", calc.letterGrade(79.99));
    }

    //@Test
    //void testLetterGrade_D() {
    //    assertEquals("D", calc.letterGrade(60));
    //    assertEquals("D", calc.letterGrade(69.99));
    //}

    @Test
    void testLetterGrade_F() {
        assertEquals("F", calc.letterGrade(59.99));
        assertEquals("F", calc.letterGrade(0));
    }

    @Test
    void testLetterGrade_Exception() {
     
        assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(-0.01));
        assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(100.01));
    }
    
    @Test
    void testGpa_Loop0_Null() {
        assertThrows(IllegalArgumentException.class, () -> calc.gpa(null));
    }

    @Test
    void testGpa_Loop0_Empty() {
        assertThrows(IllegalArgumentException.class, () -> calc.gpa(new double[]{}));
    }

    @Test
    void testGpa_Loop1() {
        assertEquals(4.0, calc.gpa(new double[]{95})); 
    }

    @Test
    void testGpa_Loop2Plus() {
        assertEquals(2.0, calc.gpa(new double[]{95, 85, 75, 65, 50}));
    }

    @Test
    void testScholarship_Exception_GpaNegative() {

        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(-0.1, 15, false));
    }

    @Test
    void testScholarship_Exception_GpaTooHigh() {

        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(4.1, 15, false));
    }

    @Test
    void testScholarship_Exception_CreditsNegative() {

        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(3.5, -1, false));
    }

    @Test
    void testScholarship_Violation() {

        assertEquals(0, calc.scholarship(4.0, 20, true));
    }

    @Test
    void testScholarship_100Percent() {
        assertEquals(100, calc.scholarship(3.8, 15, false));
    }

    @Test
    void testScholarship_100Percent_CreditFail() {

        assertEquals(70, calc.scholarship(3.8, 14, false));
    }

    @Test
    void testScholarship_70Percent() {
        assertEquals(70, calc.scholarship(3.4, 12, false));
    }

    @Test
    void testScholarship_70Percent_CreditFail() {
        assertEquals(50, calc.scholarship(3.4, 11, false));
    }

    @Test
    void testScholarship_50Percent() {
        assertEquals(50, calc.scholarship(3.0, 10, false));
    }

    @Test
    void testScholarship_0Percent() {
        assertEquals(0, calc.scholarship(2.9, 15, false));
    }
}
