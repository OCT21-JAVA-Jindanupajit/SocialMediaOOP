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




}
