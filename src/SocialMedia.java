import java.util.Scanner;

public class SocialMedia {

    private String name;
    private UserDatabase userDatabase;

    public SocialMedia() {
        name = "";
        this.userDatabase = new UserDatabase();
    }

    public SocialMedia(UserDatabase userDatabase) {
        name = "";
        this.userDatabase = userDatabase;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDatabase getUserDatabase() {
        return userDatabase;
    }

    public void setUserDatabase(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    public void shell() {

        while (!login()) {
            System.out.println("Username or password is incorrect!\n");
        }

        String commandLine;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.printf("%s > ", this.name);
            commandLine = scanner.nextLine();
            switch(commandLine.toLowerCase()) {
                case "say":
                    System.out.printf("I am %s\n", name);
                    break;
                case "logout":
                    break;
                default:
                    System.out.printf(" * %s: No such command", name);
            }

            System.out.println();
        } while (!commandLine.equalsIgnoreCase("logout"));

        System.out.println("Good bye");
    }

    private boolean login() {
        String email = getEmail();
        String password = getPassword();

        User user = new User(email, password);

        return userDatabase.authenticate(user);
    }

    private String getLine(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%s", prompt);
        return scanner.nextLine();
    }

    private String getEmail() {

        return getLine("login (email) : ");
    }

    private String getPassword() {
        return getLine("password: ");
    }
}
