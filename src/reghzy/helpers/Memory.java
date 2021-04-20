package reghzy.helpers;

import java.lang.reflect.Array;

public final class Memory {
    private Memory() {

    }

    public static char[] copy(char[] original) {
        char[] copy = new char[original.length];
        System.arraycopy(original, 0, copy, 0, original.length);
        return copy;
    }

    /**
     * Extracts the characters at and between the start and end index
     * <p>
     * extractRange([0,1,2,3,4], 1, 3) == [1, 2, 3]
     * </p>
     */
    public static char[] extractRange(char[] original, int start, int end) {
        int length = Math.min((end - start) + 1, original.length);
        char[] copy = new char[length];
        System.arraycopy(original, start, copy, 0, length);
        return copy;
    }

    /**
     * Removes characters at and between the start and end index
     * <p>
     *      removeRange([0,1,2,3,4], 1, 3) == [0,4],
     *      removeRange([0,1,2,3,4,5,6,7], 2, 5) == [0,1,6,7],
     * </p>
     */
    public static char[] removeRange(char[] src, int start, int end) {
        end = Math.min(end, src.length - 1);
        char[] out = new char[src.length - (end - start + 1)];
        System.arraycopy(src, 0, out, 0, start);
        System.arraycopy(src, end + 1, out, start, src.length - end - 1);
        return out;
    }

    public static char[] combineArrays(char[] a, char[] b) {
        char[] output = new char[a.length + b.length];
        System.arraycopy(a, 0, output, 0, a.length);
        System.arraycopy(b, 0, output, a.length, b.length);
        return output;
    }

    public static char[] combineArrays(char[] a, char[] b, char[] c) {
        char[] output = new char[a.length + b.length + c.length];
        System.arraycopy(a, 0, output, 0, a.length);
        System.arraycopy(b, 0, output, a.length, b.length);
        System.arraycopy(c, 0, output, a.length + b.length, c.length);
        return output;
    }

    public static char[] combine(char[]... arrays) {
        int outputLength = 0;
        for (char[] chars : arrays) {
            outputLength += chars.length;
        }

        return combine(outputLength, arrays);
    }

    public static char[] combine(int totalLength, char[]... arrays) {
        char[] output = new char[totalLength];
        for (int outIndex = 0, j = 0, len = arrays.length; j < len; j++) {
            char[] array = arrays[j];
            System.arraycopy(array, 0, output, outIndex, array.length);
            outIndex += array.length;
        }
        return output;
    }

    public static int indexOf(char[] array, char[] value) {
        char first = value[0];
        int i = 0;
        while (i < array.length) {
            char c = array[i++];
            if (c == first) {
                boolean found = true;
                int j = 1, k = i + 1;
                while (j < value.length && k < array.length) {
                    if (value[j++] != array[k++]) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static boolean contains(char[] array, char[] value) {
        return indexOf(array, value) != -1;
    }

    public static <T> T[] createArray(Class<? extends T> type, int length) {
        return (type == Object[].class) ? (T[]) new Object[length] : (T[]) Array.newInstance(type.getComponentType(), length);
    }
}
