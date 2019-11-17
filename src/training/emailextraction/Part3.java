package training.emailextraction;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Part3 {

    public static void extractTopEmailAddresses(String input, int limit) {

        HashMap<String, Integer> domains = extractEmailDomains(input);
        HashMap<String, Integer> topDomains = getTopDomains(domains, limit);
        printDomains(topDomains, limit);
    }

    private static HashMap<String, Integer> extractEmailDomains(String input) {

        HashMap<String, Integer> domainMap = new HashMap<>();

        Pattern emailPattern = Pattern.compile("\\b[a-z0-9.'_%+-]+@([a-z0-9.-]+\\.[a-z]{2,})\\b");
        Matcher emailMatcher = emailPattern.matcher(input.toLowerCase(Locale.UK));

        while (emailMatcher.find()) {
            domainMap.merge(emailMatcher.group(1), 1, Integer::sum);
        }

        return domainMap;
    }

    private static HashMap<String, Integer> getTopDomains(HashMap<String, Integer> domainMap, int limit) {

        return domainMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(limit)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldKey, newKey) -> oldKey, LinkedHashMap::new));
    }

    private static void printDomains(HashMap<String, Integer> domains, int limit) {

        System.out.println("Part 3 - Top Domains\n");
        System.out.printf("Top %s addresses are:\n\n", limit);
        domains.forEach((domain, count) -> {
            System.out.printf("%s\t- %s\n", count, domain);
    });
    }
}
