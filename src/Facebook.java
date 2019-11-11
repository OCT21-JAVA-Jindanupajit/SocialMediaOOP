public class Facebook extends SocialMedia {

    public Facebook() {
        super.setName("Facebook");
    }

    public Facebook(UserDatabase userDatabase) {
        super(userDatabase);
        super.setName("Facebook");
    }
}
