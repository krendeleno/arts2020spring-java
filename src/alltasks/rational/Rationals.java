package alltasks.rational;

/**
 * Задача на ооп, функция из задачи про рациональные числа
 */
public class Rationals {

    public static double foo(int n, int k, double acc) {
        if (k < n)
            return foo(n, ++k, acc + (new Rational(1, k)).toDouble());
        else
            return acc;
    }
    public static double f(int n) {
        return foo(n, 0, 0.);
    }

    public static void main(String[] args) {
        Rational r1 = new Rational(1, 7);
        Rational r2 = new Rational(3, 2);
        System.out.println(Rational.sub(r1, r2));
        System.out.println(f(4));
    }
}
