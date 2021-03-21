import myPackage.model.Polynomial;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivisionTest {

    @ParameterizedTest
    @MethodSource("provideInput")
    void testDivision(Polynomial a, Polynomial b, Polynomial[] expectedResult) {
        Polynomial[] p = a.divides(b);
        assertEquals(expectedResult[0], p[0]);
        assertEquals(expectedResult[1], p[1]);
    }
    private static List<Arguments> provideInput(){

        List<Arguments> argumentsList = new ArrayList<>();
        Polynomial a = new Polynomial("x^2 + 3x +2");
        Polynomial b = new Polynomial("x^2 + 5x +4");
        Polynomial[] q = new Polynomial[]{new Polynomial("1"),  new Polynomial("-2x - 2")};
        Polynomial a1 = new Polynomial("5x^3 -3x+2");
        Polynomial b1 = new Polynomial(" 5x^2 -2");
        Polynomial[] q1 = new Polynomial[]{new Polynomial("x"),  new Polynomial("-x+2")};
        Polynomial a2 = new Polynomial("5x^7 +6x^4 + 2x^2 +6x + 9");
        Polynomial b2 = new Polynomial(" x^2+1");
        Polynomial[] q2 = new Polynomial[]{new Polynomial("5x^5 - 5x^3 + 6x^2 + 5x - 4"),  new Polynomial("x + 13")};

        argumentsList.add(Arguments.of(a,b,q));
        argumentsList.add(Arguments.of(a1,b1,q1));
        argumentsList.add(Arguments.of(a2,b2,q2));
        return argumentsList;
    }
}
