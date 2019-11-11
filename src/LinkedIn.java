public class LinkedIn extends SocialMedia {

    public LinkedIn() {
        super.setName("LinkedIn");
    }

    public LinkedIn(UserDatabase userDatabase) {
        super(userDatabase);
        super.setName("LinkedIn");
    }
}
