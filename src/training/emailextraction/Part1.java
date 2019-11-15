package training.emailextraction;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Part1 {

    public static void extractSoftwireEmails(String input) {

        String softwireString = "@softwire.com ";
        int counter = 0;

        for (int i = 0; i < input.length() - softwireString.length() + 1; i++) {
            if (input.substring(i, i + softwireString.length()).equals(softwireString)) {
                counter += 1;
            }
        }

        System.out.println("Part 1 - Substring Matching");
        System.out.println(String.format("Occurences of '@softwire.com': %s", counter));
        System.out.println();
    }
}
