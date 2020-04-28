package alltasks.rational;

/**
 * Задача на ооп, рациональные числа
 */
public class Rational {

    public static final Rational ZERO = new Rational(0, 1);

    public static final Rational ONE = new Rational(1, 1);

    public static Rational add(Rational r1, Rational r2) {
        return r1.add(r2);
    }

    public static Rational sub(Rational r1, Rational r2) {
        return r1.sub(r2);
    }

    public static Rational mul(Rational r1, Rational r2) {
        return r1.mul(r2);
    }

    public static Rational div(Rational r1, Rational r2) {
        return r1.div(r2);
    }

    private static int _gcd(int a, int b) {
        if (b == 0) return a;
        return _gcd(b,a % b);
    }

    private static int[] _reduction(int n, int d) {
        if (n == 1 || d == 1) return new int[]{n, d};
        int gcd = _gcd(Math.abs(n), d);
        if (d / gcd > 0) {
            return new int[]{n / gcd, d / gcd};
        } else {
            return new int[]{n, d};
        }
    }

    private final int numerator;

    private final int denominator;

    public Rational(int n, int d) {
        if (d < 0) {
            d = -d;
            n = -n;
        }
        var tmp = _reduction(n, d);
        numerator = tmp[0];
        denominator = tmp[1];
    }

    public Rational(int n) {
        numerator = n;
        denominator = 1;
    }

//    public int getNumerator() { return numerator; }

//    public int getDenominator() { return denominator; }

    @Override
    public String toString() {
        if (numerator == 0 || denominator == 1)
            return Integer.toString(numerator);
        else
            return Integer.toString(numerator).concat("/").concat(Integer.toString(denominator));
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    public Rational add(Rational r) {
        return new Rational(r.numerator * denominator + numerator * r.denominator, denominator * r.denominator);
    }

    public Rational sub(Rational r) {
        return new Rational(-r.numerator * denominator + numerator * r.denominator, denominator * r.denominator);
    }

    public Rational mul(Rational r) {
        return new Rational(numerator * r.numerator, denominator * r.denominator);
    }

    public Rational div(Rational r) {
        return new Rational(numerator * r.denominator, denominator * r.numerator);
    }
}