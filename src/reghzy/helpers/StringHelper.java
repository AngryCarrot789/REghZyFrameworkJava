package reghzy.helpers;

import sun.security.util.Length;

public class StringHelper {
    public static String getElementAfterSplitter(String content, char splitter, int splitIndex, int startIndex) {
        boolean next = false;
        for(int i = startIndex, last = 0, curr = -1, len = content.length(), lenIndex = len - 1; i < content.length(); i++) {
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

    public static String getElementBeforeSplitter(String content, char splitter, int splitIndex, int startIndex) {
        for(int i = startIndex, lastSplitIndex = -1, splitCount = -1, len = content.length(); i < len; i++) {
            if (content.charAt(i) == splitter) {
                splitCount++;
                if (splitCount == splitIndex) {
                    return content.substring(lastSplitIndex + 1, i);
                }
                lastSplitIndex = i;
            }
        }
        return null;
    }

    /**
     * Returns a string where everything up to the last occurrence of the
     * given character is returned, the last bits aren't included
     */
    public static String getBeforeLast(String content, char character) {
        int i = content.length() - 1;
        while(true) {
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
     * @param content       The content
     * @param stop          The character that, if found, stops the search and the text before it is returned
     * @param includeLast   Whether to return a substring between startIndex and the length if the stop character isn't found
     * @param startIndex    The index to start the search (inclusive; includes the character at the index)
     * @return
     */
    public static String getUpTo(String content, char stop, boolean includeLast, int startIndex) {
        for(int i = startIndex, len = content.length(); i < len; i++) {
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
        for(int i = 0, len = content.length(); i < len; i++) {
            if (content.charAt(i) == character)
                count++;
        }
        return count;
    }

    public static String[] split(String content, char splitter, int startIndex) {
        int splitterCount = countCharacter(content, splitter);
        String[] array = new String[splitterCount + 1];
        int i = startIndex;
        int lastSplit = -1;
        int arrayIndex = 0;
        int len = content.length();
        int lenIndex = len - 1;
        while(true) {
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

    public static String combineBranches(char splitter, String... branches) {
        StringBuilder output = new StringBuilder(64);
        for (String branch : branches) {
            if (branch.isEmpty())
                continue;

            if (StringHelper.startsWith(branch, splitter)) {
                if (StringHelper.endsWith(branch, splitter)) {
                    output.append(branch, 1, branch.length() - 1);
                }
                else {
                    output.append(branch.substring(1)).append(splitter);
                }
            }
            else {
                if (StringHelper.endsWith(branch, splitter)) {
                    output.append(branch);
                }
                else {
                    output.append(branch).append(splitter);
                }
            }
        }
        return output.toString();
    }
}
