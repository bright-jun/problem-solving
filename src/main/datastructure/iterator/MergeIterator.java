package datastructure.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MergeIterator {

    /*
     * 두 개의 정렬된 iterator가 주어졌을 때
     * 하나의 정렬된 iterator를 반환하는 메서드를 작성하시오
     */
    /*
     * https://helloacm.com/how-to-merge-two-list-iterators-in-java/
     */
    static class Data {
        int idx;
        String name;

        public Data(int idx, String name) {
            super();
            this.idx = idx;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Data [idx=" + idx + ", name=" + name + "]";
        }
    }

    Iterator<Data> mergeIterator(Iterator<Data> it1, Iterator<Data> it2) {

        List<Data> res = new ArrayList<>();

        Data v1 = it1.hasNext() ? it1.next() : null;
        Data v2 = it2.hasNext() ? it2.next() : null;

        while (v1 != null && v2 != null) {
            // pick the smaller one
            if (v1.idx < v2.idx) {
                res.add(v1);
                // pick next one
                v1 = it1.hasNext() ? it1.next() : null;
            } else {
                res.add(v2);
                // pick next one
                v2 = it2.hasNext() ? it2.next() : null;
            }
        }

        // v2 == null, addAll of v1
        while (v1 != null) {
            res.add(v1);
            v1 = it1.hasNext() ? it1.next() : null;
        }
        // v1 == null, addAll of v1
        while (v2 != null) {
            res.add(v2);
            v2 = it2.hasNext() ? it2.next() : null;
        }

        return res.iterator();
    }

    public static void main(String[] args) {
        MergeIterator ie = new MergeIterator();
        List<Data> l1 = Arrays.asList(new Data(0, "A"), new Data(2, "C"), new Data(4, "E"));
        List<Data> l2 = Arrays.asList(new Data(1, "B"), new Data(3, "D"), new Data(5, "F"));
        Iterator<Data> ls = ie.mergeIterator(l1.iterator(), l2.iterator());
        while (ls.hasNext()) {
            System.out.println(ls.next());
        }
    }
}
