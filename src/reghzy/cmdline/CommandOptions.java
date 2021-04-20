package reghzy.cmdline;

import java.util.HashMap;

/**
 * A class for easily accessing command line options
 */
public class CommandOptions {
    private final HashMap<String, Object> options;

    public CommandOptions(HashMap<String, Object> options) {
        this.options = options;
    }

    public boolean hasFlag(String flag) {
        return options.containsKey(flag);
    }

    public String getString(String key) {
        Object value = getObject(key);
        if (value instanceof String) {
            return (String) value;
        }
        return null;
    }

    public Double getDouble(String key) {
        Object value = getObject(key);
        if (value instanceof Double) {
            return (Double) value;
        }
        return null;
    }

    public Integer getInteger(String key) {
        Object value = getObject(key);
        if (value instanceof Integer) {
            return (Integer) value;
        }
        return null;
    }

    public Double getNumber(String key) {
        Object value = getObject(key);
        if (value instanceof Double) {
            return (Double) value;
        }
        if (value instanceof Integer) {
            return ((Integer) value).doubleValue();
        }
        return null;
    }

    public String[] getStringArray(String key) {
        Object value = getObject(key);
        if (value instanceof String[]) {
            return (String[]) value;
        }
        return null;
    }

    public Double[] getDoubleArray(String key) {
        Object value = getObject(key);
        if (value instanceof Double[]) {
            return (Double[]) value;
        }
        return null;
    }

    public CommandOptions getSubOptions(String key) {
        Object value = getObject(key);
        if (value instanceof CommandOptions) {
            return (CommandOptions) value;
        }
        return null;
    }

    public Object getObject(String key) {
        return options.get(key);
    }
}
