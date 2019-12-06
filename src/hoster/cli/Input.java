package hoster.cli;

import java.util.Scanner;

public class Input {
    Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public String scan() {
        String input;
        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
        } else {
            input = "NULL";
        }
        return input.toLowerCase();
    }

    public int scanInt() {
        return Integer.parseInt(scanner.nextLine());
    }

    public String get(String prompt) {
        System.out.print(prompt);
        return this.scan();
    }

    public int getInt(String prompt) {
        System.out.print(prompt);
        return this.scanInt();
    }

    public void close() {
        scanner.close();
    }
}