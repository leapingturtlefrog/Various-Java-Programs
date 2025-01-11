package search;

public class BinarySearch {
    public static <E extends Comparable<E>> int indexOf(E[] array, E element) {
        int minIdx = 0, maxIdx = array.length - 1;
        int midIdx = 0, compareToResult;
        while (minIdx <= maxIdx) {
            midIdx = (minIdx + maxIdx) / 2;
            compareToResult = element.compareTo(array[midIdx]);
            if (compareToResult > 0) {
                minIdx = midIdx + 1;
            } else if (compareToResult < 0) {
                maxIdx = midIdx - 1;
            } else {
                return midIdx;
            }
        }
        return -(midIdx + 1);
    }
}
