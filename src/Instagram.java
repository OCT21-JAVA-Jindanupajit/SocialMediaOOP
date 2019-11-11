public class Instagram extends SocialMedia {
    public Instagram() {
        super.setName("Instagram");
    }

    public Instagram(UserDatabase userDatabase) {
        super(userDatabase);
        super.setName("Instagram");
    }
}
