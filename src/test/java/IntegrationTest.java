import myPackage.model.Polynomial;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTest {

    @ParameterizedTest
    @MethodSource("provideInput")
    void testIntegration(Polynomial a, Polynomial expectedResult) {
        assertEquals(expectedResult, a.integral());
    }
    private static List<Arguments> provideInput() {

        List<Arguments> argumentsList = new ArrayList<>();
        Polynomial a = new Polynomial("3x^2 + 3x +2");
        Polynomial b = new Polynomial("x^3 + 1.5x^2 + 2x");
        Polynomial a1 = new Polynomial("12x^3 -4x +2");
        Polynomial b1 = new Polynomial(" 3x^4 -2x^2 +2x");
        Polynomial a2 = new Polynomial("9x^8 +25x^4 + 6x^2 +6x + 9");
        Polynomial b2 = new Polynomial(" 1x^9 + 5x^5 + 2x^3 + 3x^2 + 9x");

        argumentsList.add(Arguments.of(a, b));
        argumentsList.add(Arguments.of(a1, b1));
        argumentsList.add(Arguments.of(a2, b2));
        return argumentsList;
    }
}
