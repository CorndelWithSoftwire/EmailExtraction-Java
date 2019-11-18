package training.emailextraction;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Stretch {

    public static void extractTopEmailDomains(String input, int limit) {

        String emailRegexWithDomainGroup = "\\b[a-z0-9.'_%+-]+@([a-z0-9.-]+\\.[a-z]{2,})\\b";
        HashMap<String, Integer> domains = createDomainMap(input, emailRegexWithDomainGroup);
        HashMap<String, Integer> topDomains = getTopDomains(domains, limit);
        printTopDomains(topDomains, limit);
    }

    public static void extractDomainsWithMinimumFrequency(String input, int min) {

        String emailRegexWithDomainGroup = "\\b[a-z0-9.'_%+-]+@([a-z0-9.-]+\\.[a-z]{2,})\\b";
        HashMap<String, Integer> domains = createDomainMap(input, emailRegexWithDomainGroup);
        HashMap<String, Integer> domainsWithMinFrequency = getDomainsWithMinFrequency(domains, min);
        printDomainsWithMinFrequency(domainsWithMinFrequency, min);
    }

    public static void extractTopLevelDomains(String input) {

        String emailRegexWithTopLevelDomainGroup = "\\b[a-z0-9.'_%+-]+@([a-z0-9-]+)(\\.[a-z0-9.-]+)*\\.[a-z]{2,}\\b";
        HashMap<String, Integer> domains = createDomainMap(input, emailRegexWithTopLevelDomainGroup);
        PrintTopLevelDomains(domains);
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

    private static HashMap<String, Integer> getTopDomains(HashMap<String, Integer> domainMap, int limit) {

        return domainMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(limit)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldKey, newKey) -> oldKey, LinkedHashMap::new));
    }

    private static HashMap<String, Integer> getDomainsWithMinFrequency(HashMap<String, Integer> domainMap, int min) {

        return domainMap.entrySet().stream()
                .filter(d -> d.getValue() >= min)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldKey, newKey) -> oldKey, LinkedHashMap::new));
    }

    private static void printTopDomains(HashMap<String, Integer> domains, int limit) {

        System.out.printf("Top %s domains:\n%-20.20s %5.5s\n", limit, "Domain", "Count");
        domains.forEach((domain, count) -> {
            System.out.printf("%-20.20s %5.5s\n", domain, count);
        });
        System.out.println();
    }

    private static void printDomainsWithMinFrequency(HashMap<String, Integer> domains, int min) {

        System.out.printf("Domains with at least %s occurrences:\n%-20.20s %5.5s\n", min, "Domain", "Count");
        domains.forEach((domain, count) -> {
            System.out.printf("%-20.20s %5.5s\n", domain, count);
        });
        System.out.println();
    }

    private static void PrintTopLevelDomains(HashMap<String, Integer> domains) {

        System.out.printf("Top Level Domains:\n%-20.20s %5.5s\n", "Domain", "Count");
        domains.forEach((domain, count) -> {
            System.out.printf("%-20.20s %5.5s\n", domain, count);
        });
        System.out.println();
    }
}
