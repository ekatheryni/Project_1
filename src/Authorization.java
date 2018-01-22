public class Authorization {
    public static boolean isAllowed(String username, String password) {
        return username.contentEquals("admin") && password.contentEquals("admin");
    }
}