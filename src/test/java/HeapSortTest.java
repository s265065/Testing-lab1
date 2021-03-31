import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Heap sort tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HeapSortTest {

    private HeapSort sorter;
    private PrintStream originalPrintStream;
    private  ByteArrayOutputStream stream;

    @BeforeEach
    void init() {
        sorter = new HeapSort();
        originalPrintStream = System.out;
        stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));
    }

    @AfterEach
    public void resetSystemOut(){
        System.setOut(originalPrintStream);
    }


    @ParameterizedTest(name = "Result only tests")
    @MethodSource("provideArraysWithResultOnly")
    void resultOnlyTest(int[] startState, int[] expectedResult) {
        assertArrayEquals(expectedResult, HeapSort.heapSort(startState));
    }

    @ParameterizedTest(name = "With path test")
    @MethodSource("provideArrays")
    void dataTest(int[] startState, int[] expectedState, String expectedStream) {

        assertArrayEquals(expectedState, sorter.heapSort(startState));
        assertEquals(expectedStream, stream.toString());
    }


    private static Stream<Arguments> provideArraysWithResultOnly() {
        return Stream.of(
                Arguments.of(new int[] {1, 10, 16, 19, 3, 5}, new int[] {1, 3, 5, 10, 16, 19}),
                Arguments.of(new int[] {-11, -7, 0, -9, 3, -5}, new int[] {-11, -9, -7, -5, 0, 3}),
                Arguments.of(new int[] {0, 0, 0, 0}, new int[] {0, 0, 0, 0}),
                Arguments.of(new int[] {1}, new int[] {1}),
                Arguments.of(new int[] {-22, -5, -4, -1, -13}, new int[] {-22, -13, -5, -4, -1}),
                Arguments.of(new int[] {-5, -5, -5}, new int[] {-5, -5, -5}),
                Arguments.of(new int[] {}, new int[] {}),
                Arguments.of(new int[] {6, 4, 6, 4, 8}, new int[] {4, 4, 6, 6, 8})
        );
    }

    private static Stream<Arguments> provideArrays() {
        return Stream.of(
                Arguments.of(new int[] {1, 10, 16, 19, 3, 5}, new int[] {1, 3, 5, 10, 16, 19},
                        "[1, 10, 16, 19, 3, 5]\n"+
                        "[1, 10, 16, 19, 3, 5]\n"+
                        "[1, 19, 16, 10, 3, 5]\n"+
                        "[1, 19, 16, 10, 3, 5]\n"+
                        "[19, 1, 16, 10, 3, 5]\n"+
                        "[19, 10, 16, 1, 3, 5]\n"+
                        "[5, 10, 16, 1, 3, 19]\n"+
                        "[16, 10, 5, 1, 3, 19]\n"+
                        "[3, 10, 5, 1, 16, 19]\n"+
                        "[10, 3, 5, 1, 16, 19]\n"+
                        "[1, 3, 5, 10, 16, 19]\n"+
                        "[5, 3, 1, 10, 16, 19]\n"+
                        "[1, 3, 5, 10, 16, 19]\n"+
                        "[3, 1, 5, 10, 16, 19]\n"+
                        "[1, 3, 5, 10, 16, 19]\n"
                ),
                Arguments.of(new int[] {-11, -7, 0, -9, 3, -5}, new int[] {-11, -9, -7, -5, 0, 3},
                        "[-11, -7, 0, -9, 3, -5]\n"+
                        "[-11, -7, 0, -9, 3, -5]\n"+
                        "[-11, 3, 0, -9, -7, -5]\n"+
                        "[-11, 3, 0, -9, -7, -5]\n"+
                        "[3, -11, 0, -9, -7, -5]\n"+
                        "[3, -7, 0, -9, -11, -5]\n"+
                        "[-5, -7, 0, -9, -11, 3]\n"+
                        "[0, -7, -5, -9, -11, 3]\n"+
                        "[-11, -7, -5, -9, 0, 3]\n"+
                        "[-5, -7, -11, -9, 0, 3]\n"+
                        "[-9, -7, -11, -5, 0, 3]\n"+
                        "[-7, -9, -11, -5, 0, 3]\n"+
                        "[-11, -9, -7, -5, 0, 3]\n"+
                        "[-9, -11, -7, -5, 0, 3]\n"+
                        "[-11, -9, -7, -5, 0, 3]\n"
                ),
                Arguments.of(new int[] {0, 0, 0, 0}, new int[] {0, 0, 0, 0},
                        "[0, 0, 0, 0]\n"+
                        "[0, 0, 0, 0]\n"+
                        "[0, 0, 0, 0]\n"+
                        "[0, 0, 0, 0]\n"+
                        "[0, 0, 0, 0]\n"
                ),
                Arguments.of(new int[] {1}, new int[] {1}, "[1]\n"),
                Arguments.of(new int[] {-22, -5, -4, -1, -13}, new int[] {-22, -13, -5, -4, -1},
                        "[-22, -5, -4, -1, -13]\n"+
                        "[-22, -5, -4, -1, -13]\n"+
                        "[-22, -1, -4, -5, -13]\n"+
                        "[-22, -1, -4, -5, -13]\n"+
                        "[-1, -22, -4, -5, -13]\n"+
                        "[-1, -5, -4, -22, -13]\n"+
                        "[-13, -5, -4, -22, -1]\n"+
                        "[-4, -5, -13, -22, -1]\n"+
                        "[-22, -5, -13, -4, -1]\n"+
                        "[-5, -22, -13, -4, -1]\n"+
                        "[-13, -22, -5, -4, -1]\n"+
                        "[-22, -13, -5, -4, -1]\n"
                ),
                Arguments.of(new int[] {-5, -5, -5}, new int[] {-5, -5, -5},
                        "[-5, -5, -5]\n"+
                        "[-5, -5, -5]\n"+
                        "[-5, -5, -5]\n"+
                        "[-5, -5, -5]\n"
                ),
                Arguments.of(new int[] {}, new int[] {}, "[]\n"),
                Arguments.of(new int[] {6, 4, 6, 4, 8}, new int[] {4, 4, 6, 6, 8},
                        "[6, 4, 6, 4, 8]\n"+
                        "[6, 4, 6, 4, 8]\n"+
                        "[6, 8, 6, 4, 4]\n"+
                        "[6, 8, 6, 4, 4]\n"+
                        "[8, 6, 6, 4, 4]\n"+
                        "[4, 6, 6, 4, 8]\n"+
                        "[6, 4, 6, 4, 8]\n"+
                        "[4, 4, 6, 6, 8]\n"+
                        "[6, 4, 4, 6, 8]\n"+
                        "[4, 4, 6, 6, 8]\n"+
                        "[4, 4, 6, 6, 8]\n"
                )
        );
    }
}
