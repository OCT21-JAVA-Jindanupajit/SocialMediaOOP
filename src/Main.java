import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String commandLine;
        String prompt = "% ";

        UserDatabase userDatabase = new UserDatabase();

        Collections.addAll(userDatabase,
                new User("john@gmail.com", "password"),
                new User("jane@gmail.com", "password"),
                new User("jack@gmail.com", "password")
                );
        outer:
        do {

            commandLine = getLine(prompt);
            SocialMedia socialMedia;
            switch (commandLine.toLowerCase()) {
                case "facebook":
                    socialMedia = new Facebook(userDatabase);
                    getShell(socialMedia);
                    continue outer;
                case "twitter":
                    socialMedia = new Twitter(userDatabase);
                    getShell(socialMedia);
                    continue outer;
                case "linkedin":
                    socialMedia = new LinkedIn(userDatabase);
                    getShell(socialMedia);
                    continue outer;
                case "instagram":
                    socialMedia = new Instagram(userDatabase);
                    getShell(socialMedia);
                    continue outer;
                case "exit":
                    break;
                default:
                    System.out.printf("%s is not a command.", commandLine);
            }
            System.out.println();
        } while (!commandLine.equalsIgnoreCase("exit"));
    }

    private static void getShell(SocialMedia socialMedia) {
        int wrongCredentialCounter = 0;
        do {
            if (socialMedia.getUserDatabase().authenticate(
                    new User(getEmail(), getPassword())
            )) {
                socialMedia.shell();
                return;
            } else
                System.out.println("Not valid email & password combination");
        } while(++wrongCredentialCounter < 5);
    }

    private static String getLine(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%s", prompt);
        return scanner.nextLine();
    }

    private static String getEmail() {

        return getLine("login (email) : ");
    }

    private static String getPassword() {
        return getLine("password: ");
    }
}
