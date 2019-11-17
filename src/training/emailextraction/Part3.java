package training.emailextraction;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Part3 {

    public static void extractTopEmailAddresses(String input, int limit) {

        HashMap<String, Integer> domains = extractDomains(input);
        HashMap<String, Integer> topDomains = getTopDomains(domains, limit);
        printDomains(topDomains, limit);
    }

    private static HashMap<String, Integer> extractDomains(String input) {

        HashMap<String, Integer> domains = new HashMap<>();

        String emailPatternString = "\\b[A-Za-z0-9.'_%+-]+@([A-Za-z0-9.-]+\\.[A-Za-z]{2,})\\b";
        Pattern pattern = Pattern.compile(emailPatternString);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            domains.merge(matcher.group(1), 1, Integer::sum);
        }

        return domains;
    }

    private static HashMap<String, Integer> getTopDomains(HashMap<String, Integer> hashMap, int limit) {

        return hashMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(limit)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldKey, newKey) -> oldKey, LinkedHashMap::new));
    }

    private static void printDomains(HashMap<String, Integer> domains, int limit) {

        System.out.println("Part 3 - Top Domains");

        System.out.printf("Top %s addresses are:\n", limit);

        domains.forEach((domain, count) -> {
            System.out.printf("%s - %s\n", domain, count);
        });
    }
}
