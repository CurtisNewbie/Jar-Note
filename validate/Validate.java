package validate;

public class Validate {

    public static boolean isValid(String s) {
        if (s.matches("[a-zA-Z0-9_]"))
            return true;
        else
            return false;
    }

}