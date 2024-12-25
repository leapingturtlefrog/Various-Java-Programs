public class ArrayAccess {
    static final int LIST_LENGTH = 100000;
    static final int LIST_MAX_VALUE = 1_000_000; // non-inclusive of value
    public static void main(String[] args) {
        double averageRatio = 0;
        int[] list1 = new int[LIST_LENGTH];
        for (int i = 0; i < list1.length; i++) {
            list1[i] = (int) (Math.random() * LIST_MAX_VALUE);
        }
        int[] list2 = list1.clone();
        
        long startTime1 = System.nanoTime();
        selectionSort1(list1);
        long endTime1 = System.nanoTime();
        
        long startTime2 = System.nanoTime();
        selectionSort2(list2);
        long endTime2 = System.nanoTime();
        
        long time1 = endTime1 - startTime1, time2 = endTime2 - startTime2;
        averageRatio += (double) time2 / time1;
        
        System.out.println("selectionSort1: " + String.valueOf(time1)
                + "\nselectionSort2: " + String.valueOf(time2)
                + "\nDifference (2 - 1): " + String.valueOf(time2 - time1)
                + "\nRatio (2 / 1): " + String.valueOf((double) time2 / time1)
                + "\n");
        
        list1 = new int[LIST_LENGTH];
        for (int i = 0; i < list1.length; i++) {
            list1[i] = (int) (Math.random() * LIST_MAX_VALUE);
        }
        list2 = list1.clone();
        
        startTime1 = System.nanoTime();
        selectionSort1(list2);
        endTime1 = System.nanoTime();
        
        startTime2 = System.nanoTime();
        selectionSort2(list1);
        endTime2 = System.nanoTime();
        
        time1 = endTime1 - startTime1;
        time2 = endTime2 - startTime2;
        averageRatio += (double) time2 / time1;
        
        System.out.println("selectionSort1: " + String.valueOf(time1)
                + "\nselectionSort2: " + String.valueOf(time2)
                + "\nDifference (2 - 1): " + String.valueOf(time2 - time1)
                + "\nRatio (2 / 1): " + String.valueOf((double) time2 / time1)
                + "\n");
        
        list1 = new int[LIST_LENGTH];
        for (int i = 0; i < list1.length; i++) {
            list1[i] = (int) (Math.random() * LIST_MAX_VALUE);
        }
        list2 = list1.clone();
        
        startTime2 = System.nanoTime();
        selectionSort2(list1);
        endTime2 = System.nanoTime();
        
        startTime1 = System.nanoTime();
        selectionSort1(list2);
        endTime1 = System.nanoTime();
        
        time1 = endTime1 - startTime1;
        time2 = endTime2 - startTime2;
        averageRatio += (double) time2 / time1;
        
        System.out.println("selectionSort1: " + String.valueOf(time1)
                + "\nselectionSort2: " + String.valueOf(time2)
                + "\nDifference (2 - 1): " + String.valueOf(time2 - time1)
                + "\nRatio (2 / 1): " + String.valueOf((double) time2 / time1)
                + "\n");
        
        list1 = new int[LIST_LENGTH];
        for (int i = 0; i < list1.length; i++) {
            list1[i] = (int) (Math.random() * LIST_MAX_VALUE);
        }
        list2 = list1.clone();
        
        startTime2 = System.nanoTime();
        selectionSort2(list2);
        endTime2 = System.nanoTime();
        
        startTime1 = System.nanoTime();
        selectionSort1(list1);
        endTime1 = System.nanoTime();
        
        time1 = endTime1 - startTime1;
        time2 = endTime2 - startTime2;
        averageRatio = (averageRatio + (double) time2 / time1) / 4;
        
        System.out.println("selectionSort1: " + String.valueOf(time1)
                + "\nselectionSort2: " + String.valueOf(time2)
                + "\nDifference (2 - 1): " + String.valueOf(time2 - time1)
                + "\nRatio (2 / 1): " + String.valueOf((double) time2 / time1)
                + "\n\nAverage ratio (2 / 1):" + String.valueOf(averageRatio));
    }
    
    public static int[] selectionSort1(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int minValue = list[i], minIdx = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < minValue) {
                    minValue = list[j];
                    minIdx = j;
                }
            }
            list[minIdx] = list[i];
            list[i] = minValue;
        }
        return list;
    }
    
    public static int[] selectionSort2(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = list[i];
            list[i] = list[minIdx];
            list[minIdx] = temp;
        }
        return list;
    }
}