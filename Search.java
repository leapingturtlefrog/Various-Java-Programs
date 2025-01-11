import java.util.Random;
import java.util.Arrays;

public final class Search {
    private static final int ARRAY_LENGTH = 1_000_000;
    private static final int ARRAY_ELEMENT_UPPER_BOUND = 100_000;
    private static final Type ELEMENT = new Type(53);
    private static final int CORRECT_ELEMENT_IDX = 494;
    
    public static void main(String[] args) {
        Random random = new Random(10);
        Type[] array = new Type[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            array[i] = new Type(random.nextInt(ARRAY_ELEMENT_UPPER_BOUND));
        }
        Arrays.sort(array);
        int idx = search.BinarySearch.indexOf(array, ELEMENT);
        System.out.printf("element: %d\ncorrect idex: %d\nindex: %d\nmatches correct index: %b\n",
                ELEMENT.getVar1(),
                CORRECT_ELEMENT_IDX,
                idx,
                idx == CORRECT_ELEMENT_IDX);
    }
}
