public class StringPool {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "hello";
        System.out.println(str1 + "\n" + str2 + "\nstr1 == str2: " + (str1 == str2) + "\nstr1.equals(str2): " + str1.equals(str2));
        str2 = "hello2";
        System.out.println("\nAfter:\n");
        System.out.println(str1 + "\n" + str2 + "\nstr1 == str2: " + (str1 == str2) + "\nstr1.equals(str2): " + str1.equals(str2));
        
    }
}