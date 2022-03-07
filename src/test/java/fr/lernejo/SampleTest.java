package fr.lernejo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SampleTest {
    @Test
    void add_2_by_10_should_produce_12() {
        int a = 10; // (1)
        int b = 2;
        Sample test = new Sample();
        int sum = test.op(Sample.Operation.ADD, a, b);
        Assertions.assertSame(sum, 12, "10 + 2 = 12");
    }

    @Test
    void mul_2_by_10_should_produce_20() {
        int a = 10; // (1)
        int b = 2;
        Sample test = new Sample();
        int sum = test.op(Sample.Operation.MULT, a, b);
        Assertions.assertSame(sum, 20, "10 x 2 = 20");
    }

    @Test
    void fact_3_should_produce_6() {
        int a = 3; // (1)
        Sample test = new Sample();
        int fact3 = test.fact(a);
        Assertions.assertSame(fact3, 6, "fact(3) = 6");
    }

    @Test
    void negative_fact_should_produce_error() {
        int a = -10; // (1)
        Sample test = new Sample();
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> test.fact(a), "a should not be negative");
        Assertions.assertTrue(exception.getMessage().contains(("N should be positive")));
    }
}
