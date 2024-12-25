import java.util.ArrayList;
import java.net.URL;
import java.net.URI;
import java.util.Scanner;

public class WebCrawler {
    private final static int MAX_PAGES_TO_VISIT = 10;
    public static void main(String[] args) {
        int totalLength = 0, pageLength;
        ArrayList<String> pagesVisited = new ArrayList<>(), pagesToVisit = new ArrayList<>();
        if (args.length == 0) {
            try (Scanner consoleInput = new Scanner(System.in)) {
                System.out.print("\nNo URL provided in arguments, so enter the URL to crawl in the form 'https://www.[url].[extension]': ");
                pagesToVisit.add(consoleInput.nextLine());
            }
        } else if (args.length > 2) {
            System.out.println("Provide only one URL. Usage: java WebCrawler \"https://www.[url].[extension]\"");
            System.exit(1);
        } else if (args.length == 1) {
            pagesToVisit.add(args[0]);
        } else {
            
        }
        while (pagesToVisit.size() > 0 && pagesVisited.size() < MAX_PAGES_TO_VISIT) {
            String urlString = pagesToVisit.removeFirst();
            if (pagesVisited.contains(urlString)) {
                System.out.println("Already crawled " + urlString);
                continue;
            }
            pagesVisited.add(urlString);
            try{
                System.out.println("Crawling " + urlString);
                URL url = new URI(urlString).toURL();
                pageLength = 0;
                try (Scanner input = new Scanner(url.openStream())) {
                    while (input.hasNext()) {
                        String line = input.nextLine();
                        String[] lineSplit = line.splitWithDelimiters("https://[A-Za-z0-9.-]+\\.[A-Za-z0-9]{2,}(?:/[^\\s\"<>]*)?", 0);
                        for (String str: lineSplit) {
                            if (str.startsWith("https://")) {
                                pagesToVisit.add(str);
                                //System.out.println("\t\tFound " + str);
                            }
                        }
                        pageLength += line.length();
                    }
                }
                totalLength += pageLength;
                System.out.println("\tPage code length: " + pageLength);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println("Total length: " + totalLength);
    }
}
