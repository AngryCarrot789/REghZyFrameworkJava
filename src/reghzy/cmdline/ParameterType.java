package reghzy.cmdline;

public enum ParameterType {
    flag("A flag"),
    string("A string value"),
    number("A number value"),
    stringArray("A collection of strings"),
    numberArray("A collection of numbers"),
    subOptions("A collection of sub-options");

    private final String readable;

    ParameterType(String readable) {
        this.readable = readable;
    }

    public String getReadable() {
        return readable;
    }
}
