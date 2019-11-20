package training.emailextraction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

    public static void extractSoftwireEmailsRegex(String input) {

        String patternString = "(?<=\\s|^)[a-z0-9.'_%+-]+@softwire\\.com(?=\\s|$)";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(input);

        int count = 0;

        while (matcher.find()) {
            count ++;
        }

        System.out.printf("Occurrences of '@softwire.com' using regular expressions: %s\n\n", count);
    }
}
