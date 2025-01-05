public class DefaultValues {
    public static void main(String[] args) {
        DefaultTest d = (new DefaultValues()).new DefaultTest();
        System.out.println(d);
    }
    
    class DefaultTest {
        short short1;
        int int1;
        long long1;
        char char1;
        boolean boolean1;
        float float1;
        double double1;
        String string1;
        Object object1;
        
        DefaultTest() {
            System.out.println(short1);
            System.out.println(int1);
            System.out.println(long1);
            System.out.println(char1);
            System.out.println(boolean1);
            System.out.println(float1);
            System.out.println(double1);
            System.out.println(string1);
            System.out.println(object1);
        }
    }
}