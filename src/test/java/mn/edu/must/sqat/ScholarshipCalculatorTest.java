package mn.edu.must.sqat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScholarshipCalculatorTest {
    ScholarshipCalculator calc = new ScholarshipCalculator();

    @Test void testGradeA() { assertEquals("A", calc.letterGrade(95)); }
    @Test void testGradeB() { assertEquals("B", calc.letterGrade(85)); }
    @Test void testGradeC() { assertEquals("C", calc.letterGrade(75)); }
    @Test void testGradeD_Safe() { assertEquals("D", calc.letterGrade(65)); }
    @Test void testGradeF() { assertEquals("F", calc.letterGrade(50)); }
    @Test void testGradeEx() { assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(-1)); }

    @Test void testGpa_Loop0_Null() { assertThrows(IllegalArgumentException.class, () -> calc.gpa(null)); }
    @Test void testGpa_Loop0_Empty() { assertThrows(IllegalArgumentException.class, () -> calc.gpa(new double[]{})); }
    @Test void testGpa_Loop1() { assertEquals(4.0, calc.gpa(new double[]{95})); }
    @Test void testGpa_Loop2Plus() { assertEquals(2.0, calc.gpa(new double[]{95, 85, 75, 65, 50})); }

    @Test void testSchol_Ex1() { assertThrows(IllegalArgumentException.class, () -> calc.scholarship(-1, 15, false)); }
    @Test void testSchol_Ex2() { assertThrows(IllegalArgumentException.class, () -> calc.scholarship(5, 15, false)); }
    @Test void testSchol_Ex3() { assertThrows(IllegalArgumentException.class, () -> calc.scholarship(3.5, -1, false)); }
    @Test void testSchol_Viol() { assertEquals(0, calc.scholarship(4.0, 15, true)); }
    
    @Test void testSchol_100() { assertEquals(100, calc.scholarship(3.9, 15, false)); }
    @Test void testSchol_100Fail() { assertEquals(70, calc.scholarship(3.9, 14, false)); }
    @Test void testSchol_70() { assertEquals(70, calc.scholarship(3.5, 12, false)); }
    @Test void testSchol_70Fail() { assertEquals(50, calc.scholarship(3.5, 11, false)); }
    @Test void testSchol_50() { assertEquals(50, calc.scholarship(3.0, 15, false)); }
    @Test void testSchol_0() { assertEquals(0, calc.scholarship(2.9, 15, false)); }
    
 
    @Test void testLetterGrade_D_Boundary() { assertEquals("D", calc.letterGrade(60)); }
}
