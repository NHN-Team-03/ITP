package exercise.exercise3;

import java.util.Objects;

class Node<K, V> {
    private int hash;
    private K key;
    private V value;

    Node<K, V> next;

    Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.hash = hashCode();
        next = null;
    }

    public final K getKey() {
        return key;
    }

    public final V getValue() {
        return value;
    }

    public final int hashCode() {
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }

    public final V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        this.hash = hashCode();
        return oldValue;
    }
}


public class CustomHashMap<K, V> {
    private Node<K, V> head, tail;
    private Node hashTable[];
    private int size;
    private int count;

    public CustomHashMap() {
        hashTable = new Node[100];
        size = 0;
        count = 0;
    }

    public boolean isEmpty() {
        if (size <= 0) {
            return true;
        }
        return false;
    }

    public boolean iscontainKey(K key) {
        Node node = hashTable[key.hashCode() % 100];

        while (node != null) {
            if (node.getKey().hashCode() % 100 == key.hashCode() % 100) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void replaceValue(K key, V value) {
        // hashTable 갱신
        Node node = hashTable[key.hashCode() % 100];
        while (node != null) {
            if (node.getKey().hashCode() % 100 == key.hashCode() % 100) {
                node.setValue(value);
            }
            node = node.next;
        }

        // node 갱신
        node = head;
        while (node != null) {
            if (node.getKey().hashCode() % 100 == key.hashCode() % 100) {
                node.setValue(value);
            }
            node = node.next;
        }
    }

    public void put(K key, V value) {
        Node newNode = new Node(key, value);

        int hashIndex = key.hashCode() % 100;

        if (iscontainKey(key)) {
            replaceValue(key, value);
            return;
        }

        Node hashNode = new Node(key, value);
        if (hashTable[hashIndex] == null) {
            hashTable[hashIndex] = hashNode;
        } else {
            Node nextNode = hashTable[hashIndex];
            while (nextNode.next != null) {
                nextNode = nextNode.next;
            }
            nextNode.next = hashNode;
        }


        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public V get(K key) {
        Node<K, V> node = hashTable[key.hashCode() % 100];
        while (node != null) {
            if (node.getKey().hashCode() % 100 == key.hashCode() % 100) {
                return node.getValue();
            }
            node = node.next;
        }
        return null;
    }


    public void remove(K key) {
        Node node = hashTable[key.hashCode() % 100];
        if (node.getKey().hashCode() % 100 == key.hashCode() % 100) {
            hashTable[key.hashCode() % 100] = node.next;
        } else {

            while (node.next != null) {
                if (node.next.getKey().hashCode() % 100 == key.hashCode() % 100) {
                    Node removeNode = node.next;
                    node.next = removeNode.next;
                    break;
                }
                node = node.next;
            }
        }

        // node 갱신
        node = head;
        if (node.getKey().hashCode() % 100 == key.hashCode() % 100) {
            head = node.next;
        } else {
            while (node.next != null) {
                if (node.next.getKey().hashCode() % 100 == key.hashCode() % 100) {
                    Node removeNode = node.next;
                    node.next = removeNode.next;
                    break;
                }
                node = node.next;
            }
        }


    }

    public int size() {
        return size;
    }
}
