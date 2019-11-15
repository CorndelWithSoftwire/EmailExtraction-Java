package training.emailextraction;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Part1 {

    public static void extractSoftwireEmails(String input) {

        int counter = 0;

        for (int i = 0; i < input.length() - 12; i++) {
            if (input.substring(i, i + 13).equals("@softwire.com")) {
                counter += 1;
            }
        }

        System.out.println(String.format("Occurences of '@softwire.com': %s", counter));
    }
}
