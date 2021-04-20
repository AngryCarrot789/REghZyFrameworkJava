package reghzy.helpers;
public class StringHelper {
    public boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }

    /**
     * Parses integers without throwing exceptions, simply returns null if it failed to parse (more efficient, no extra class creation on failure to parse)
     */
    public static Integer parseInteger(String value) {
        if (value == null || value.length() == 0)
            return null;

        int radix = 10;
        int result = 0;
        boolean isNegative = false;
        int i = 0, len = value.length();
        int limit = -Integer.MAX_VALUE;
        int radixMinLimit;
        int digit;

        char firstChar = value.charAt(0);
        if (firstChar < '0') { // Possible leading "+" or "-"
            if (firstChar == '-') {
                isNegative = true;
                limit = Integer.MIN_VALUE;
            }
            else if (firstChar != '+')
                return null;

            if (len == 1) // Cannot have lone "+" or "-"
                return null;
            i++;
        }
        radixMinLimit = limit / radix;
        while (i < len) {
            // Accumulating negatively avoids surprises near MAX_VALUE
            digit = Character.digit(value.charAt(i++), radix);
            if (digit < 0) {
                return null;
            }
            if (result < radixMinLimit) {
                return null;
            }
            result *= radix;
            if (result < limit + digit) {
                return null;
            }
            result -= digit;
        }

        return isNegative ? result : -result;
    }

    public static Double parseDouble(String stringValue) {
        try {
            return Double.parseDouble(stringValue);
        }
        catch (NumberFormatException e) {
            return null;
        }
    }

    public static String getContentAfterSplitterIndex(String content, char splitter, int splitIndex, int startIndex) {
        boolean next = false;
        for (int i = startIndex, last = 0, curr = -1, len = content.length(), lenIndex = len - 1; i < len; i++) {
            if (next) {
                if (content.charAt(i) == splitter) {
                    return content.substring(last + 1, i);
                }
                else if (i == lenIndex) {
                    return content.substring(last + 1, i + 1);
                }
            }
            else if (content.charAt(i) == splitter) {
                curr++;
                if (curr == splitIndex) {
                    next = true;
                }
                last = i;
            }
        }

        return null;
    }

    public static String repeat(char repeat, int count) {
        StringBuilder string = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            string.append(repeat);
        }
        return string.toString();
    }

    public static String repeat(String repeat, int count) {
        StringBuilder string = new StringBuilder(repeat.length() * count);
        for (int i = 0; i < count; i++) {
            string.append(repeat);
        }
        return string.toString();
    }

    public static String ensureLength(String string, int maxLength, char fillValue) {
        int extra = maxLength - string.length();
        if (extra > 0)
            return string + repeat(fillValue, extra);
        if (extra < 0)
            return string.substring(0, maxLength);
        else
            return string;
    }

    public static String joinArray(String[] args, int startIndex, char joinCharacter) {
        if ((args == null) || (startIndex < 0) || (startIndex >= args.length))
            return null;

        StringBuilder string = new StringBuilder(args.length);
        for (int i = startIndex, lenIndex = args.length - 1; i < args.length; i++) {
            if (i == lenIndex) {
                string.append(args[i]);
            }
            else {
                string.append(args[i]).append(joinCharacter);
            }
        }
        return string.toString();
    }

    public static String joinArray(String[] args, int startOffset, String joinText) {
        if ((args == null) || (startOffset < 0) || (startOffset >= args.length))
            return null;

        StringBuilder string = new StringBuilder(args.length);
        for (int i = startOffset, lenIndex = args.length - 1; i < args.length; i++) {
            if (i == lenIndex) {
                string.append(args[i]);
            }
            else {
                string.append(args[i]).append(joinText);
            }
        }
        return string.toString();
    }

    public static boolean containsChar(String string, char character) {
        for(int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == character)
                return true;
        }
        return false;
    }

    public static int countChar(String string, char character) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == character)
                count++;
        }
        return count;
    }

    public boolean contains(String original, String value) {
        return Memory.contains(original.toCharArray(), value.toCharArray());
    }

    public int indexOf(String original, String value) {
        return Memory.indexOf(original.toCharArray(), value.toCharArray());
    }

    /**
     * Returns a string where everything up to the last occurrence of the
     * given character is returned, the last bits aren't included
     */
    public static String getBeforeLast(String content, char character) {
        int i = content.length() - 1;
        while (true) {
            if (i < 0) {
                return null;
            }
            if (content.charAt(i) == character) {
                return content.substring(0, i);
            }
            i--;
        }
    }

    /**
     * Returns all of the text starting at startIndex up until the stop character is found
     * (or if includeLast is true, the end of the string if the stop character is found).
     * if includeLast is false and the stop character isn't found, null is returned
     *
     * @param content     The content
     * @param stop        The character that, if found, stops the search and the text before it is returned
     * @param includeLast Whether to return a substring between startIndex and the length if the stop character isn't found
     * @param startIndex  The index to start the search (inclusive; includes the character at the index)
     * @return
     */
    public static String getUpTo(String content, char stop, boolean includeLast, int startIndex) {
        for (int i = startIndex, len = content.length(); i < len; i++) {
            if (content.charAt(i) == stop) {
                return content.substring(startIndex, i);
            }
        }
        if (includeLast) {
            return content.substring(startIndex);
        }
        return null;
    }

    /**
     * Returns the text after the first occurrence of a given string value
     *
     * @param content
     * @param value
     * @param startIndex
     * @return
     */
    public static String getAfter(String content, String value, int startIndex) {
        int valueStart = content.indexOf(value, startIndex);
        if (valueStart == -1)
            return null;

        return content.substring(valueStart + value.length());
    }

    public static int countCharacter(String content, char character) {
        int count = 0;
        for (int i = 0, len = content.length(); i < len; i++) {
            if (content.charAt(i) == character)
                count++;
        }
        return count;
    }

    public static String[] split(String content, char splitter, int startIndex) {
        int splitterCount = countCharacter(content, splitter);
        if (splitterCount == 0) {
            return new String[0];
        }

        String[] array = new String[splitterCount + 1];
        int i = startIndex;
        int lastSplit = -1;
        int arrayIndex = 0;
        int len = content.length();
        int lenIndex = len - 1;
        while (true) {
            if (content.charAt(i) == splitter) {
                array[arrayIndex] = content.substring(lastSplit + 1, i);
                lastSplit = i;
                arrayIndex++;
            }
            if (i == lenIndex) {
                array[arrayIndex] = content.substring(lastSplit + 1);
                break;
            }
            i++;
        }
        return array;
    }

    public static boolean endsWith(String content, char character) {
        return content.charAt(content.length() - 1) == character;
    }

    public static boolean startsWith(String content, char character) {
        return content.charAt(0) == character;
    }

    public static String remove(String original, char a, int start) {
        StringBuilder stringBuilder = new StringBuilder(original.length());
        for (int i = start, len = original.length(); i < len; i++) {
            char c = original.charAt(i);
            if (c != a) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
