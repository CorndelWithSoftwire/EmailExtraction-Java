package training.emailextraction;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws Exception {

        String input = Files.readString(Paths.get("sample.txt"), StandardCharsets.UTF_8);

        System.out.println("Extracting emails...");
        System.out.println();

        Part1.extractSoftwireEmails(input);
        Part2.extractSoftwireEmailsRegex(input);
        Part3.extractEmailDomains(input);

        Stretch.extractTopEmailDomains(input, 10);
        Stretch.extractDomainsWithMinimumFrequency(input, 250);
        Stretch.extractTopLevelDomains(input);
    }
}
