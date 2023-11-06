package example;

public record Complex(double re, double im) {

    public final static Complex ONE = new Complex(1, 0);
    public final static Complex ZERO = new Complex(0, 0);
    public final static Complex I = new Complex(0, 1);

    public Complex(double re) {
        this(re, 0);
    }

    public String toString() {
        if (im == 0) {
            return String.valueOf(re);
        } else if (re == 0) {
            if (im < 0) {
                return "-I*" + (-im);
            } else {
                return "I*" + im;
            }
        } else if (im < 0) {
            return re + " - " + "I*" + (-im);
        } else {
            return re + " + " + "I*" + im;
        }
    }

    public Complex plus(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    public Complex minus(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    public Complex times(Complex c) {
        return new Complex(re * c.re, im * c.im);
    }

    public Complex dividedBy(Complex c) {
        double denom = c.re * c.re + c.im * c.im;
        double real = (re * c.re + im * c.im) / denom;
        double imaginary = (im * c.re - re * c.im) / denom;
        return new Complex(real, imaginary);
    }
}