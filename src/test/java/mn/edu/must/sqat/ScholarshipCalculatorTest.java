package mn.edu.must.sqat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScholarshipCalculatorTest {
    ScholarshipCalculator calc = new ScholarshipCalculator();

    @Test void testGradeA() { assertEquals("A", calc.letterGrade(95)); }
    @Test void testGpaNormal() { assertEquals(3.5, calc.gpa(new double[]{95, 85})); }
    @Test void testScholarship100() { assertEquals(100, calc.scholarship(3.9, 16, false)); }
    @Test void testScholarship50() { assertEquals(50, calc.scholarship(3.0, 15, false)); }
}
