import org.example.BookShelf;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("BookShelf Class")
public class BookShelfSpec {

    private BookShelfSpec(TestInfo testInfo) {
        System.out.println("Working on test " + testInfo.getDisplayName());
    }

    @Test
    @DisplayName("is empty when no book is added to it")
    public void shelfEmptyWhenNoBookAdded(TestInfo testInfo) throws Exception {
        System.out.println("Working on test case " + testInfo.getDisplayName());
        BookShelf shelf = new BookShelf();
        List<String> books = shelf.books();
        assertTrue(books.isEmpty(), () -> "Bookshelf should be empty.");
    }

    @Test
    void nullAssertionTest() {
        String str = null;
//        str = "";
//        assertNull(str);
//        assertNull(str, "str should be null");
        assertNull(str, () -> "str should be null");
    }

    @Test
    void shouldCheckForEvenNumbers() {
        int number = new Random(10).nextInt();
        assertTrue(() -> number % 2 == 0, number + " is not an even number");

        BiFunction<Integer, Integer, Boolean> divisible = (x, y) -> x % y == 0;
        Function<Integer, Boolean> multipleOf2 = (x) -> divisible.apply(x, 2);
        assertTrue(() -> multipleOf2.apply(number), () -> "2 is not a factor of " + number);

        List<Integer> numbers = Arrays.asList(1, 1, 1, 1, 2);
        assertTrue(() -> numbers.stream().distinct().anyMatch(BookShelfSpec::isEven), "Did not find number in the list");
    }

    @Test
    public void shelfToStringShouldPrintBookCountAndTitles() throws Exception {
        BookShelf shelf = new BookShelf();
        List<String> books = shelf.books();
        books.add("Tom and Jerry Adventures");
        books.add("Karate Cat");

        String shelfStr = books.toString();

//        assertTrue(shelfStr.contains("Tomd and Jerry Adventures"), "1st book title missing");
//        assertTrue(shelfStr.contains("Karate Cat"), "2nd book title missing");

        assertAll(() -> assertTrue(shelfStr.contains("Tomd and Jerry Adventures"), "1st book title missing"),
                  () -> assertTrue(shelfStr.contains("karate Cat"), "2nd book title missing"));
    }

    static boolean isEven(int number) {
        return number % 2 == 0;
    }

}
