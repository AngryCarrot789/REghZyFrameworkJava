package reghzy.unused.cmdline;

import java.util.HashMap;
import java.util.HashSet;

public class CommandOptions {
    private final HashSet<String> flags;
    private final HashMap<String, String> strings;
    private final HashMap<String, Double> numbers;
    private final HashMap<String, String[]> stringArrays;
    private final HashMap<String, Double[]> doubleArrays;
    private final HashMap<String, DoublePair> ranges;

    public CommandOptions(HashSet<String> flags,
                          HashMap<String, String> strings,
                          HashMap<String, Double> numbers,
                          HashMap<String, String[]> stringArrays,
                          HashMap<String, Double[]> doubleArrays,
                          HashMap<String, DoublePair> ranges) {
        this.flags = flags;
        this.strings = strings;
        this.numbers = numbers;
        this.stringArrays = stringArrays;
        this.doubleArrays = doubleArrays;
        this.ranges = ranges;
    }

    public boolean hasFlag(String flag) {
        return flags.contains(flag);
    }

    public String getString(String option) {
        return strings.get(option);
    }

    public Double getDouble(String option) {
        return numbers.get(option);
    }

    public Integer getInteger(String option) {
        Double d = getDouble(option);
        if (d == null)
            return null;
        return (int) Math.floor(d);
    }

    public String[] getStringArray(String option) {
        return stringArrays.get(option);
    }

    public Double[] getDoubleArray(String option) {
        return doubleArrays.get(option);
    }
}
