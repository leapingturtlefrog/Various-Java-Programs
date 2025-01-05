public class Enums {
    public static enum Test {
        GOOD, BAD, WONDERFUL
    }
    public static void main(String[] args) {
        String good = Test.GOOD.name();
        Test[] testValues = Test.values();
        System.out.printf("%s %s %s\n%s\n%s\n%s\n%s\n\n",
                Test.GOOD, Test.BAD, Test.WONDERFUL, good,
                Test.WONDERFUL.ordinal(),
                Test.GOOD.compareTo(Test.BAD), Test.GOOD.compareTo(Test.WONDERFUL));
        for (Test val: testValues) {
            System.out.println(val);
        }
    }
}
