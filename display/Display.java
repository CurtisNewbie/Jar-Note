import validate.Validate;

public class Display {

    private String content;

    Display(String c) {
        if (Validate.isValid(c)) {
            this.content = c;
        }
    }

    public String show() {
        return "Showing: " + this.content;
    }
}