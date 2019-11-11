public class Twitter extends SocialMedia {
    public Twitter() {
        super.setName("Twitter");
    }

    public Twitter(UserDatabase userDatabase) {
        super(userDatabase);
        super.setName("Twitter");
    }
}
