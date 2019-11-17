package training.emailextraction;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Part1 {

    public static void extractSoftwireEmails(String input) {

        String softwireString = "@softwire.com ";

        int count = 0;

        for (int i = 0; i < input.length() - softwireString.length() + 1; i++) {
            if (input.substring(i, i + softwireString.length()).equals(softwireString)) {
                count ++;
            }
        }

        System.out.println("Part 1 - Substring Matching\n");
        System.out.printf("Occurrences of '@softwire.com': %s\n\n\n", count);
    }
}
