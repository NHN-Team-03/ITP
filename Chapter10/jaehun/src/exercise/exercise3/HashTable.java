package exercise.exercise3;

public class HashTable {
    private class HashNode {
        String key;
        String value;
        HashNode next;

        HashNode(String key, String value) {
            this.key = key;
            this.value = value;
        }

    }

    public HashNode[] hashIndex;

    private static int count;

    HashTable() {
        hashIndex = new HashNode[300];

        count = 0;
    }

    public HashNode get(String key) {
        int keyIndex = key.hashCode();

        if (hashIndex[keyIndex] == null) {
            throw new IllegalStateException("찾으시는 값이 존재하지 않습니다.");
        }

        HashNode runner = hashIndex[keyIndex];
        while (runner != null) {
            if (key.equals(runner.key)) {
                break;
            }

            runner = runner.next;
        }

        return runner;
    }

    public void put(String key, String value) {
        HashNode newNode = new HashNode(key, value);
        count++;

        int newCode = key.hashCode();
        if (hashIndex[newCode] == null) {
            hashIndex[newCode] = newNode;
        } else {
            HashNode runner = hashIndex[newCode];

            while (runner != null) {
                if (key.equals(runner.key)) {
                    runner.value = value;
                    count--;
                }

                if (runner.next == null) {
                    runner.next = newNode;
                    break;
                }

                runner = runner.next;
            }
        }
    }

    public HashNode remove(String key) {
        int keyCode = key.hashCode();

        if(hashIndex[keyCode] == null) {
            throw new IllegalStateException("해시 테이블이 비어 있습니다.");
        }

        if(key.equals(hashIndex[keyCode].key)) {
            count--;
            HashNode removeNode = hashIndex[keyCode];
            hashIndex[keyCode] = null;
            return removeNode;
        }

        HashNode runner = hashIndex[keyCode].next;
        HashNode previous = hashIndex[keyCode];

        while(runner != null) {
            if(key.equals(runner.key)) {
                count--;
                HashNode removeNode = runner;
                previous.next = runner.next;

                return removeNode;
            }

            previous = runner;
            runner = runner.next;
        }

        throw new IllegalStateException("삭제할 노드가 해시 테이블에 존재 하지 않습니다.");
    }

    public boolean containKey(String key) {
        int keyCode = key.hashCode();

        if (hashIndex[keyCode] == null) {
            return false;
        }

        HashNode runner = hashIndex[keyCode];
        while (runner != null) {
            if (key.equals(runner.key)) {
                return true;
            }

            runner = runner.next;
        }

        return false;
    }

    public int size() {
        return count;
    }


}
