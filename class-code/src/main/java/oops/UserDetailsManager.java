package oops;

// composition example
public class UserDetailsManager {

    private final DBAccessor dbAccessor;

    public UserDetailsManager(DBAccessor dbAccessor) {
        this.dbAccessor = dbAccessor;
    }
}
