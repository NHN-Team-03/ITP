package exercise.exercise3;

public class HashTable {


    // TODO: ListNode로 Hashtable 구현
    private static class ListNode {
        String key;
        String value;
        ListNode next;
    }

    private ListNode[] table;
    private int count;

    public HashTable() {
        table = new ListNode[64];
    }

    public HashTable(int initSize) {
        if (initSize <= 0) {
            throw new IllegalArgumentException("0보다 작은 값은 들어올 수 없습니다.");
        }
        table = new ListNode[initSize];
    }

    public String get(String key) {
        if (key == null) {
            throw new IllegalArgumentException("null 값이 들어올 수 없습니다.");
        }

        int bucket = hash(key);
        ListNode list = table[bucket];
        while (list != null) {
            if (list.key.equals(key)) {
                return list.value;
            }
            list = list.next;
        }
        return null;
    }

    public void put(String key, String value) {
        if (key == null) {
            throw new IllegalArgumentException("Key는 null 값이 들어올 수 없습니다.");
        }

        int bucket = hash(key);

        ListNode list = table[bucket];
        while (list != null) {
            if (list.key.equals(key)) {
                break;
            }
            list = list.next;
        }

        // 이미 존재하는 키를 입력했을 경우
        if (list != null) {
            list.value = value;
        } else {
            if (count >= 0.75 * table.length) {
                resize();
                bucket = hash(key);
            }

            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.value = value;
            newNode.next = table[bucket];
            table[bucket] = newNode;

            count++;
        }
    }

    private void resize() {
        ListNode[] newTable = new ListNode[table.length * 2];

        for (int i = 0; i < table.length; i++) {
            ListNode list = table[i];

            while (list != null) {
                ListNode next = list.next;

                int hash = (Math.abs(list.key.hashCode())) % newTable.length;
                list.next = newTable[hash];
                newTable[hash] = list;
                list = next;
            }
        }
        table = newTable;
    }

    public void remove(String key) {
        if (key == null) {
            throw new IllegalArgumentException("null 값은 들어올 수 없습니다.");
        }

        int bucket = hash(key);
        ListNode list = table[bucket];

        if (list.key.equals(key)) {
            table[bucket] = table[bucket].next;
            count--;
            return;
        }

        ListNode prev = table[bucket];
        ListNode current = prev.next;

        while (current != null && !(current.key.equals(key))) {
            current = current.next;
            prev = current;
        }

        if (current != null) {
            prev.next = current.next;
            count--;
        }


    }

    public boolean containsKey(String key) {

        int bucket = hash(key);
        ListNode list = table[bucket];

        while (list != null) {
            if (list.key.equals(key)) {
                return true;
            }
            list = list.next;
        }
        return false;
    }

    public int hash(String key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    public int size() {
        return this.count;
    }

    public void dump() {
        if (count == 0) {
            System.out.println("HashTable is empty");
            return;
        }

        int index = 0;
        for (ListNode listNode : table) {
            System.out.print(index++ + ": ");
            while (listNode != null) {
                System.out.print("(" + listNode.key + ", " + listNode.value + ") ");
                listNode = listNode.next;
            }
            System.out.println();
        }
    }


}

