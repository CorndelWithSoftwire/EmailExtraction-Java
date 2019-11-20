package training.emailextraction;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

    public static void extractEmailDomains(String input) {

        String emailRegexWithDomainGroup = "(?<=\\s|^)[a-z0-9.'_%+-]+@([a-z0-9.-]+\\.[a-z]{2,})(?=\\s|$)";
        HashMap<String, Integer> domainMap = createDomainMap(input, emailRegexWithDomainGroup);
        printDomains(domainMap);
    }

    private static HashMap<String, Integer> createDomainMap(String input, String regex) {

        HashMap<String, Integer> domainMap = new HashMap<>();

        Pattern emailPattern = Pattern.compile(regex);
        Matcher emailMatcher = emailPattern.matcher(input);

        while (emailMatcher.find()) {
            domainMap.merge(emailMatcher.group(1), 1, Integer::sum);
        }

        return domainMap;
    }

    private static void printDomains(HashMap<String, Integer> domains) {

        System.out.printf("%-20.20s %5.5s\n", "Domain", "Count");
        domains.forEach((domain, count) -> {
            System.out.printf("%-20.20s %5.5s\n", domain, count);
        });
        System.out.println();
    }
}
