import myPackage.model.Polynomial;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DerivativeTest {

    @ParameterizedTest
    @MethodSource("provideInput")
    void testDerivative(Polynomial a, Polynomial expectedResult) {
        assertEquals(expectedResult, a.derivative());
    }
    private static List<Arguments> provideInput() {

        List<Arguments> argumentsList = new ArrayList<>();
        Polynomial a = new Polynomial("x^2 + 3x +2");
        Polynomial b = new Polynomial("2x + 3");
        Polynomial a1 = new Polynomial("5x^3 -3x +2");
        Polynomial b1 = new Polynomial(" 15x^2 -3");
        Polynomial a2 = new Polynomial("5x^8 +3x^4 + 2x^2 +6x + 9");
        Polynomial b2 = new Polynomial(" 40x^7 + 12x^3 +4x + 6");

        argumentsList.add(Arguments.of(a, b));
        argumentsList.add(Arguments.of(a1, b1));
        argumentsList.add(Arguments.of(a2, b2));
        return argumentsList;
    }
}
