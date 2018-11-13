
package julia;

import org.junit.Test;
import static org.junit.Assert.*;

public class ComplexTest {
    
    private static final double EPSILON = 1E-8;
    
    public ComplexTest() {
    } // ComplexTest()

    @Test
    public void testGetReal() {
        Complex instance = new Complex( 3, 4);
        System.out.println( "*" + instance + "*");
        double expResult = 3;
        double result = instance.getReal();
        assertEquals(expResult, result, EPSILON);
    } // testGetReal()

    @Test
    public void testGetImag() {
        Complex instance = new Complex( 3, 4);
        double expResult = 4;
        double result = instance.getImag();
        assertEquals(expResult, result, EPSILON);
    } // testGetImag()

    @Test
    public void testMagnitudeSquared() {
        Complex instance = new Complex( 3, 4);
        double expResult = 25;
        double result = instance.magnitudeSquared();
        assertEquals(expResult, result, EPSILON);
    } // testMagnitudeSquared()

    @Test
    public void testMagnitude() {
        Complex instance = new Complex( 3, 4);
        double expResult = 5;
        double result = instance.magnitude();
        assertEquals(expResult, result, EPSILON);
    } // testMagnitude()

    @Test
    public void testAdd() {
        Complex z = new Complex( 5, 12);
        Complex instance = new Complex( 3, 4);
        Complex expResult = new Complex( 8, 16);
        Complex result = instance.add(z);
        assertEquals(result.getReal(), 8, EPSILON);
        assertEquals(result.getImag(), 16, EPSILON);
    } // testAdd()

    @Test
    public void testMultiply() {
        Complex z = new Complex( 5, 12);
        Complex instance = new Complex( 3, 4);
        Complex expResult = new Complex( -33, 56);
        Complex result = instance.multiply(z);
        assertEquals(result.getReal(), -33, EPSILON);
        assertEquals(result.getImag(), 56, EPSILON);
    } // testMultiply()

    @Test
    public void testToString() {
        Complex instance = new Complex(3, 4);
        String expResult = "  3.0000 +   4.0000i";
        String result = instance.toString();
        assertEquals(expResult, result);
    } // testToString()
    
} // ComplexTest
