import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;

public class ReplaceText {
    public static void main(String[] args) throws IOException {
        if (args.length != 4) {
            System.out.println("Incorrect number of arguments (needs 4). Found " + args.length + ". Usage: java ReplaceText <file with occurrences to be replaced> <new file> <string to be replaced> <replacement string>");
            System.exit(1);
        }
        File inputFile = new File(args[0]);
        if (!inputFile.exists() || !inputFile.isFile()) {
            System.out.println("Input file not found. Usage: java ReplaceText <file with occurrences to be replaced> <new file> <string to be replaced> <replacement string>");
            System.exit(2);
        }
        StringBuilder outputStringBuilder = new StringBuilder();
        try (
            Scanner input = new Scanner(inputFile);
        ) {
            while (input.hasNextLine()) {
                outputStringBuilder.append(input.nextLine().replaceAll(args[2], args[3])).append("\n");
            }
            int len = outputStringBuilder.length();
            if (len > 0) {
                outputStringBuilder.deleteCharAt(len - 1);
            }
        }
        File outputFile = new File(args[1]);
        try (FileWriter output = new FileWriter(outputFile)) {
            output.write(outputStringBuilder.toString());
        }
    }
}
