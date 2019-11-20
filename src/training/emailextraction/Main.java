package training.emailextraction;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws IOException {

        String input = new String(Files.readAllBytes(Paths.get("sample.txt")), StandardCharsets.UTF_8)
                .toLowerCase(Locale.UK);

        System.out.println("Part 1");
        Part1.extractSoftwireEmails(input);

        System.out.println("Part 2");
        Part2.extractSoftwireEmailsRegex(input);

        System.out.println("Part 3");
        Part3.extractEmailDomains(input);

        System.out.println("Stretch Goals");
        Stretch.extractTopEmailDomains(input, 10);
        Stretch.extractDomainsWithMinimumFrequency(input, 63);
        Stretch.extractNonTopLevelDomains(input);
    }
}
