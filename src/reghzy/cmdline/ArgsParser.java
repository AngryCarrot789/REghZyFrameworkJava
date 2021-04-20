package reghzy.cmdline;

import reghzy.string.SplitString;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class is used to create CommandOptions
 */
public class ArgsParser {
    public static final char DefaultOptionStarter = '-';
    public static final char DefaultSubOptionSplitter = ':';

    private final String[] arguments;
    private final char optionStarter;
    private final char subOptionSplitter;
    private final HashMap<String, ParameterType> parsableOptions;

    /**
     * Creates an ArgsParser instance using the given arguments, and the given option starter
     * @param arguments          The arguments
     * @param optionStarter The character used for determining "options" (usually this is the '-' character)
     */
    public ArgsParser(String[] arguments, char optionStarter, char subOptionSplitter) {
        this.arguments = arguments;
        this.optionStarter = optionStarter;
        this.subOptionSplitter = subOptionSplitter;
        this.parsableOptions = new HashMap<String, ParameterType>(16);
    }

    /**
     * Creates an ArgsParser instance using the given arguments
     *
     * @param arguments     The arguments
     */
    public ArgsParser(String[] arguments) {
        this.arguments = arguments;
        this.optionStarter = DefaultOptionStarter;
        this.subOptionSplitter = DefaultSubOptionSplitter;
        this.parsableOptions = new HashMap<String, ParameterType>(16);
    }

    public void addOptionToParse(String name, ParameterType type) {
        this.parsableOptions.put(name, type);
    }

    // -name google -version 1.12.4 -stuff something another thing array -useNone -sectionA name:gog name2:hh
    public CommandOptions parse() {
        HashMap<String, Object> options = new HashMap<String, Object>(16);

        for (int i = 0, len = arguments.length, lenIndex = len - 1; i < len; i++) {
            String argument = arguments[i];
            if (!isOption(argument)) {
                continue;
            }

            String option = argument.substring(1);

            ParameterType type = getParsableOption(option);
            if (type == null)
                continue;

            switch (type) {
                case flag: {
                    options.put(option, new Object());
                    break;
                }
                case string: {
                    if (i == lenIndex) {
                        break;
                    }
                    options.put(option, arguments[++i]);
                    break;
                }
                case number: {
                    if (i == lenIndex) {
                        break;
                    }
                    String arg = arguments[++i];
                    char start = arg.charAt(0);
                    if (isForceInteger(start)) {
                        options.put(option, Integer.parseInt(arg.substring(1)));
                    }
                    else if (isForceDouble(start)) {
                        options.put(option, Double.parseDouble(arg.substring(1)));
                    }
                    else {
                        options.put(option, Double.parseDouble(arg));
                    }
                    break;
                }
                case stringArray: {
                    if (i == lenIndex) {
                        break;
                    }
                    ArrayList<String> array = new ArrayList<String>(8);
                    String arg = arguments[++i];
                    while(true) {
                        // -helo ok no you -ok
                        if (isOption(arg)) {
                            i--;
                            break;
                        }
                        array.add(arg);
                        if (i == lenIndex) {
                            break;
                        }
                        arg = arguments[++i];
                    }
                    options.put(option, array.toArray(new String[0]));
                    break;
                }
                case numberArray: {
                    if (i == lenIndex) {
                        break;
                    }
                    ArrayList<Double> array = new ArrayList<Double>(8);
                    String arg = arguments[++i];
                    while (true) {
                        if (isOption(arg)) {
                            i--;
                            break;
                        }
                        array.add(Double.parseDouble(arg));
                        if (i == lenIndex) {
                            break;
                        }
                        arg = arguments[++i];
                    }
                    options.put(option, array.toArray(new Double[0]));
                    break;
                }
                case subOptions: {
                    if (i == lenIndex) {
                        break;
                    }
                    HashMap<String, Object> subOptions = new HashMap<String, Object>(8);
                    String arg = arguments[++i];
                    while (true) {
                        if (isOption(arg)) {
                            i--;
                            break;
                        }
                        SplitString split = new SplitString(arg, subOptionSplitter);
                        subOptions.put(split.before, split.after);
                        if (i == lenIndex) {
                            break;
                        }
                        arg = arguments[++i];
                    }
                    options.put(option, new CommandOptions(subOptions));
                    break;
                }
            }
        }

        return new CommandOptions(options);
    }

    private boolean isForceInteger(char character) {
        return Character.toLowerCase(character) == 'i';
    }

    private boolean isForceDouble(char character) {
        return Character.toLowerCase(character) == 'd';
    }

    private ParameterType getParsableOption(String option) {
        return this.parsableOptions.get(option);
    }

    private boolean isOption(String value) {
        return value.charAt(0) == this.optionStarter;
    }
}
