package example;

import java.util.Arrays;

public class DynamicArrayOfInt {
    
    private int[] items = new int[8];
    private int itemCt;

    public int get(int index) {
        if (index < 0 || index >= itemCt) {
            throw new ArrayIndexOutOfBoundsException("Illegal index, " + index);
        }
        return items[index];
    }

    public void set(int index, int item) {
        if (index < 0 || index >= itemCt) {
            throw new ArrayIndexOutOfBoundsException("Illegal index, " + index);
        }
        items[index] = item;
    }

    public int size() {
        return itemCt;
    }

    public void add(int item) {
        if (itemCt == items.length) {
            items = Arrays.copyOf(items, 2 * items.length);
        }
        items[itemCt] = item;
        itemCt++;
    }

    public void remove(int index) {
        if (index < 0 || index >= itemCt) {
            throw new ArrayIndexOutOfBoundsException("Illegal index, " + index);
        }
        for (int i = index + 1; i < itemCt; i++) {
            items[i - 1] = items[i];
        }
        itemCt--;
    }
}
