package reghzy.string;

public class SplitString {
    public final String before;
    public final String after;

    public SplitString(String content, char splitter) {
        int splitIndex = content.indexOf(splitter);
        if (splitIndex == -1) {
            this.before = null;
            this.after = null;
            return;
        }

        this.before = content.substring(0, splitIndex);
        this.after = content.substring(splitIndex + 1);
    }

    public SplitString(String content, String splitter) {
        int splitIndex = content.indexOf(splitter);
        if (splitIndex == -1) {
            this.before = null;
            this.after = null;
            return;
        }

        this.before = content.substring(0, splitIndex);
        this.after = content.substring(splitIndex + splitter.length());
    }
}
