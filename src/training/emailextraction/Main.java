package training.emailextraction;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Extracting emails...");
        System.out.println();

        Part1.extractSoftwireEmails("sample.txt");
    }
}
