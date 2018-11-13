package julia;

public class Complex {

    private final double real;
    private final double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    } // Complex( double, double )

    // TO-DO: Complete the definition of
    // this stub method.
    public double getReal() {
        return 0.0;
    } // getReal()

    // TO-DO: Complete the definition of
    // this stub method.
    public double getImag() {
        return 0.0;
    } // getImag()

    // TO-DO: Complete the definition of
    // this stub method.
    public double magnitudeSquared() {
        return 0.0;
    } // magnitudeSquared()

    // TO-DO: Complete the definition of
    // this stub method.
    public double magnitude() {
        return 0.0;
    } // magnitude()

    // TO-DO: Complete the definition of
    // this stub method.
    public Complex add(Complex z) {
        return new Complex(0.0, 0.0);
    } // add( Complex )

    // TO-DO: Complete the definition of
    // this stub method.
    public Complex multiply(Complex z) {
        // (a + bi)(c + di) = (ac - bd) + (bc + ad)i
        return new Complex(0.0, 0.0);
    } // multiply( Complex )

    @Override
    public String toString() {
        return String.format("%8.4f + %8.4fi",
                this.getReal(), this.getImag());
    } // toString()
} // Complex
