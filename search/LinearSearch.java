package search;

public class LinearSearch {
    public static <E> int indexOf(E[] array, E element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
}