package reghzy.string;

/**
 * A dynamic string. basically meaning its contents can be changed very simply
 */
public class DString {
    private final char[] elements;

    public DString(String string) {
        elements = string.toCharArray();
    }

    public DString(char... elements) {
        this.elements = elements;
    }

    public DString(DString string, int start, int amount) {
        this.elements = new char[amount];
        if (amount == 0)
            return;

        System.arraycopy(string.elements, start, elements, 0, Math.min(elements.length - start, amount));
    }

    public DString(DString string, int start) {
        int length = string.elements.length - start;
        this.elements = new char[length];
        System.arraycopy(string.elements, start, elements, 0, length);
    }

    public DString[] split(char splitter, int startIndex) {
        DString[] array = new DString[countCharacter(splitter) + 1];
        int i = startIndex;
        int lastSplit = -1;
        int arrayIndex = 0;
        int lenIndex = elements.length - 1;
        while (true) {
            if (elements[i] == splitter) {
                array[arrayIndex] = substring(lastSplit + 1, i);
                lastSplit = i;
                arrayIndex++;
            }
            if (i == lenIndex) {
                array[arrayIndex] = substring(lastSplit + 1);
                break;
            }
            i++;
        }
        return array;
    }

    public int countCharacter(char character) {
        int count = 0;
        int i = 0, lenIndex = elements.length - 1;
        while (true) {
            if (i == lenIndex)
                return count;

            if (elements[i++] == character)
                count++;
        }
    }

    public DString substring(int start, int end) {
        return new DString(this, start, end - start);
    }

    public DString substring(int start) {
        return new DString(this, start);
    }

    public DString extract(int start, int end) {
        return substring(start, end + 1);
    }

    public boolean isIndexWithin(int index) {
        return index >= 0 && index < this.elements.length;
    }

    public char swap(int index, char character) {
        char old = this.elements[index];
        this.elements[index] = character;
        return old;
    }

    public void swap(int indexA, int indexB) {
        char a = this.elements[indexA];
        this.elements[indexA] = this.elements[indexB];
        this.elements[indexB] = a;
    }

    public char getChar(int index) {
        return this.elements[index];
    }

    public void setChar(int index, char character) {
        this.elements[index] = character;
    }

    public void setRegion(int start, int end, char c) {
        int i = 0;
        while(true) {
            if (i == end)
                return;
            this.elements[i++] = c;
        }
    }

    public char[] extractChars(int start, int end) {
        int newLength = end - start;
        char[] newElements = new char[newLength];
        System.arraycopy(elements, start, newElements, 0, Math.min(elements.length - start, newLength));
        return newElements;
    }

    public boolean isEmpty() {
        return this.elements.length == 0;
    }

    public char[] getElements() {
        return this.elements;
    }

    public DString copy() {
        char[] elements = new char[this.elements.length];
        System.arraycopy(this.elements, 0, elements, 0, elements.length);
        return new DString(elements);
    }

    public boolean equals(DString string) {
        if (string.elements.length == this.elements.length) {
            int i = 0;
            while (true) {
                if (i == this.elements.length)
                    return true;
                if (string.elements[i] == this.elements[i++]) {
                    continue;
                }
                return false;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return new String(this.elements);
    }

    @Override
    public DString clone() {
        return copy();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DString) {
            return this.equals((DString) obj);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (int i = 0; i < elements.length; i++) {
            hash = 31 * hash + elements[i];
        }
        return hash;
    }
}
