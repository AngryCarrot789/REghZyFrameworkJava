package reghzy.credentials;

public class UserAccount implements IUser {
    private final String username;
    private final String password;

    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean matchCredentials(String user, String password) {
        return this.username.equals(user) && this.password.equals(password);
    }

    @Override
    public String getName() {
        return this.username;
    }

    @Override
    public boolean isConsole() {
        return false;
    }
}
