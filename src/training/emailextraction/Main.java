package training.emailextraction;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws Exception {
        String input = Files.readString(Paths.get("sample.txt"));

        System.out.println("Extracting emails...");
        System.out.println();

        Part1.extractSoftwireEmails(input);
    }
}
