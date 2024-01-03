package exercise.exercise3;

public class HashMap<K, V> {
    private HashNode<K, V>[] hashTable;
    private int size;

    public HashMap(int size) {
        this.size = size;
        this.hashTable = new HashNode[size];
    }

    public int hashCode(K key) {
        return (Math.abs(key.hashCode())) % size;
    }

    public void put(K key, V value) {
        HashNode<K, V> newNode = new HashNode<>(key, value);
        int index = hashCode(key);
        if (hashTable[index] == null) {
            hashTable[index] = newNode;
            return;
        }

        HashNode<K, V> runner = hashTable[index];
        while (runner.next != null) {
            runner = runner.next;
        }
        runner.next = newNode;
    }

    public boolean containsKey(K key) {
        int index = hashCode(key);
        HashNode<K, V> runner = hashTable[index];
        while (runner != null) {
            if (runner.key.equals(key)) {
                return true;
            }
            runner = runner.next;
        }

        return false;
    }

    public HashNode<K, V> get(K key) {
        int index = hashCode(key);
        HashNode<K, V> runner = hashTable[index];
        while (runner != null) {
            if (runner.key.equals(key)) {
                return runner;
            }
        }
        System.out.println("잘못된 key값을 입력하셨습니다.");
        return null;
    }

    public V remove(K key) {
        if (!containsKey(key)) {
            System.out.println("해당 key값은 없습니다.");
            return null;
        }
        int index = hashCode(key);
        HashNode<K, V> runner = hashTable[index];
        if (runner.key.equals(key)) {
            hashTable[index] = runner.next;
            return runner.value;
        }

        HashNode<K, V> previous = hashTable[index];
        runner = runner.next;

        while (runner != null) {
            if (runner.key.equals(key)) {
                previous.next = runner.next;
                return runner.value;
            }
            previous = runner;
            runner = runner.next;
        }

        System.out.println("remove하려는 key값이 없습니다.");
        return null;
    }

    public int size() {
        int count = 0;
        HashNode<K, V> runner;
        for (int i = 0; i < hashTable.length; i++) {
            runner = hashTable[i];
            while (runner != null) {
                count++;
                runner = runner.next;
            }
        }

        return count;
    }

    public void printHashMap() {
        HashNode<K, V> runner;
        for (int i = 0; i < hashTable.length; i++) {
            System.out.print("index " + i + " : ");
            runner = hashTable[i];
            while (runner != null) {
                System.out.print(runner.value + " -> ");
                runner = runner.next;
            }
            System.out.println();
        }
    }

    class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
            next = null;
        }

        @Override
        public String toString() {
            return "key : " + this.key + ", value : " + this.value;
        }
    }
}
