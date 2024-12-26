package defaultValues;

public class DefaultValues {
    public static void main(String[] args) {
        DefaultTest d = (new DefaultValues()).new DefaultTest();
        System.out.println(d);
    }
    
    class DefaultTest {
        int int1;
        char char1;
        boolean bool1;
        
        DefaultTest() {
            System.out.println(int1);
            System.out.println(char1);
            System.out.println(bool1);
        }
    }
}