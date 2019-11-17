package training.emailextraction;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Part3 {

    public static void extractEmailDomains(String input) {

        HashMap<String, Integer> domains = createDomainMap(input);
        printDomains(domains);
    }

    private static HashMap<String, Integer> createDomainMap(String input) {

        HashMap<String, Integer> domainMap = new HashMap<>();

        Pattern emailPattern = Pattern.compile("\\b[a-z0-9.'_%+-]+@([a-z0-9.-]+\\.[a-z]{2,})\\b");
        Matcher emailMatcher = emailPattern.matcher(input.toLowerCase(Locale.UK));

        while (emailMatcher.find()) {
            domainMap.merge(emailMatcher.group(1), 1, Integer::sum);
        }

        return domainMap;
    }

    private static void printDomains(HashMap<String, Integer> domains) {

        System.out.println("Part 3 - All Domains\n");
        domains.forEach((domain, count) -> {
            System.out.printf("%s - %s\n", domain, count);
        });
        System.out.println("\n");
    }
}
