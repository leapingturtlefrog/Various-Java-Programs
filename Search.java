import java.util.Random;
import java.util.Arrays;

public final class Search {
    private static final int ARRAY_LENGTH = 1_000_000;
    private static final int ARRAY_ELEMENT_UPPER_BOUND = 100_000;
    private static final Type ELEMENT = new Type(53);
    
    public static void main(String[] args) {
        Random random = new Random(10);
        Type[] array = new Type[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            array[i] = new Type(random.nextInt(ARRAY_ELEMENT_UPPER_BOUND));
        }
        System.out.printf("index: %d\nmatches index: %b\n",
                search.LinearSearch.indexOf(array, ELEMENT),
                Arrays.asList(array).indexOf(ELEMENT));
    }
}
