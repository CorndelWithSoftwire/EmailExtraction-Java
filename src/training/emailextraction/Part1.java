package training.emailextraction;

public class Part1 {

    public static void extractSoftwireEmails(String input) {

        // This string will not account for all whitespace possibilities, leading to an answer of 237
        String softwireDomain = "@softwire.com ";

        int count = 0;

        for (int i = 0; i <= input.length() - softwireDomain.length(); i++) {
            if (input.substring(i, i + softwireDomain.length()).equals(softwireDomain)) {
                count ++;
            }
        }

        System.out.printf("Occurrences of '@softwire.com' using substring matching: %s\n\n", count);
    }
}
