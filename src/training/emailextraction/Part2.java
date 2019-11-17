package training.emailextraction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

    public static void extractSoftwireEmailsRegex(String input) {

        String patternString = "@softwire.com ";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(input);

        int count = 0;

        while (matcher.find()) {
            count ++;
        }

        System.out.println("Part 2 - Regex Matching");
        System.out.printf("Occurrences of '@softwire.com': %s\n\n", count);
    }
}
