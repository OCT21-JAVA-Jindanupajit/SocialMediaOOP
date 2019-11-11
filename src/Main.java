import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String commandLine;
        String prompt = "% ";
        Scanner scanner = new Scanner(System.in);
        UserDatabase userDatabase = new UserDatabase();

        Collections.addAll(userDatabase,
                new User("john@gmail.com", "password"),
                new User("jane@gmail.com", "password"),
                new User("jack@gmail.com", "password")
                );
        outer:
        do {
            System.out.printf("%s", prompt);
            commandLine = scanner.nextLine();
            SocialMedia socialMedia;
            switch (commandLine.toLowerCase()) {
                case "facebook":
                    socialMedia = new Facebook(userDatabase);
                    socialMedia.shell();
                    continue outer;
                case "twitter":
                    socialMedia = new Twitter(userDatabase);
                    socialMedia.shell();
                    continue outer;
                case "linkedin":
                    socialMedia = new LinkedIn(userDatabase);
                    socialMedia.shell();
                    continue outer;
                case "instagram":
                    socialMedia = new Instagram(userDatabase);
                    socialMedia.shell();
                    continue outer;
                case "exit":
                    break;
                default:
                    System.out.printf("%s is not a command.", commandLine);
            }
            System.out.println();
        } while (!commandLine.equalsIgnoreCase("exit"));
    }

}
