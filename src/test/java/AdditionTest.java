import com.sun.jdi.connect.Connector;
import myPackage.model.Monomial;
import myPackage.model.Polynomial;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdditionTest {

@ParameterizedTest
@MethodSource("provideInput")
    void testAddition(Polynomial a, Polynomial b, Polynomial expectedResult) {
        Polynomial p = a.plus(b);
        assertEquals(expectedResult, p);
    }
    private static List<Arguments> provideInput(){

        List<Arguments> argumentsList = new ArrayList<>();
        Polynomial a = new Polynomial("x^2 + 3x +2");
        Polynomial b = new Polynomial("x^2 + 5x +4");
        Polynomial c = new Polynomial("2x^2 + 8x + 6");
        Polynomial a1 = new Polynomial("5x^3 -3x +2");
        Polynomial b1 = new Polynomial(" 3x +2");
        Polynomial c1 = new Polynomial("5x^3 + 4");
        Polynomial a2 = new Polynomial("5x^8 +3x^4 + 2x^2 +6x + 9");
        Polynomial b2 = new Polynomial(" 4x^6 - 3x^2 + 4x -6");
        Polynomial c2 = new Polynomial("5x^8 + 4x^6 + 3x^4 - x^2 + 10x + 3");

        argumentsList.add(Arguments.of(a,b,c));
        argumentsList.add(Arguments.of(a1,b1,c1));
        argumentsList.add(Arguments.of(a2,b2,c2));
        return argumentsList;
    }

}