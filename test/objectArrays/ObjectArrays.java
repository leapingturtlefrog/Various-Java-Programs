package objectArrays;

public class ObjectArrays {
    public static void main(String[] args) {
        Object[] objArr = {
            new Class1(),
            new Class3Extends1()
        };
        for (Object obj: objArr) {
            System.out.println(((Class1) obj).method1());
        }
    }
}