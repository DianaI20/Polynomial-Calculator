import myPackage.model.Polynomial;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicationTest {

    @ParameterizedTest
    @MethodSource("provideInput")
    void testMultiplication(Polynomial a, Polynomial b, Polynomial expectedResult) {
        Polynomial p = a.multiply(b);
        assertEquals(expectedResult, p);
    }
    private static List<Arguments> provideInput(){

        List<Arguments> argumentsList = new ArrayList<>();
        Polynomial a = new Polynomial("x^2 + 3x +2");
        Polynomial b = new Polynomial("x^2 + 5x +4");
        Polynomial c = new Polynomial("1x^4 + 8x^3 + 21x^2 + 22x + 8");
        Polynomial a1 = new Polynomial("5x^3 -3x +2");
        Polynomial b1 = new Polynomial(" 3x +2");
        Polynomial c1 = new Polynomial("15x^4 + 10x^3 - 9x^2 + 4");
        Polynomial a2 = new Polynomial("5x^8 +3x^4 + 2x^2 +6x + 9");
        Polynomial b2 = new Polynomial(" 4x^6 - 3x^2 + 4x -6");
        Polynomial c2 = new Polynomial("20x^14 - 3x^10 + 20x^9 - 22x^8 + 24x^7 + 27x^6 + 12x^5 - 24x^4 - 10x^3 - 15x^2 - 54");

        argumentsList.add(Arguments.of(a,b,c));
        argumentsList.add(Arguments.of(a1,b1,c1));
        argumentsList.add(Arguments.of(a2,b2,c2));
        return argumentsList;
    }
}
