package example;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * TreeSetComparableTest
 */
public class TreeSetComparableTest {
    public static void main(String[] args) {
        TreeSet<Member> treeSet = new TreeSet<>();
        treeSet.add(new Member(1, "a"));
        treeSet.add(new Member(1, "b"));

        Iterator<Member> iter = treeSet.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next().id);
        }
    }

    static class Member implements Comparable<Member> {
        private int id;
        private String name;

        public Member(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public int hashCode() {
            final int PRIME = 31;
            int result = 1;
            result = PRIME * result + this.id;
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) {
                throw new NullPointerException("비교하고자 하는 object가 null입니다.");
            }

            if (this.getClass() != o.getClass()) {
                return false;
            }

            Member other = (Member) o;
            return ((this.id == other.id) && this.name.equals(other.name));
        }

        @Override
        public int compareTo(Member o) {
            if (this.id == o.id) {
                return this.name.compareTo(o.name);
            }
            return this.id - o.id;
        }

    }

}