package note.heap;

import java.util.Comparator;

@SuppressWarnings("unchecked")
public class Heap<E> {

    private final int MAX_CAPACITY = 200;
    private Object[] elements;
    private int size = 0;
    private Comparator<E> comparator;

    public Heap(Comparator<E> comparator) {
        this.elements = new Object[MAX_CAPACITY];
        this.comparator = comparator;
    }

    /**
     * Time: O(logN)
     * Space: O(1)
     */
    public void offer(E element) {
        if (this.size + 1 >= MAX_CAPACITY) {
            throw new IllegalStateException("Heap is full");
        }

        // put last
        this.size++;
        this.elements[this.size] = element;

        heapifyUp(this.size);
    }

    /**
     * Time: O(1)
     * Space: O(1)
     */
    private void heapifyUp(int idx) {
        if (idx == 1) {
            return;
        }

        int parent = idx / 2;
        if (this.comparator.compare((E) this.elements[parent], (E) this.elements[idx]) < 0) {
            swap(parent, idx);
            heapifyUp(parent);
        }
    }

    private void swap(int a, int b) {
        Object temp = this.elements[a];
        this.elements[a] = this.elements[b];
        this.elements[b] = temp;
    }

    /**
     * Time: O(logN)
     * Space: O(1)
     */
    public E poll() {
        if (this.size == 0) {
            return null;
        }

        // get first
        E answer = (E) this.elements[1];
        this.elements[1] = this.elements[this.size];
        this.size--;

        heapifyDown(1);

        return answer;
    }

    /**
     * Time: O(1)
     * Space: O(1)
     */
    private void heapifyDown(int idx) {
        int leftChild = idx * 2;
        int rightChild = idx * 2 + 1;

        if (leftChild > this.size) {
            return;
        }

        int biggerChild;

        if (this.comparator.compare((E) this.elements[leftChild], (E) this.elements[rightChild]) > 0) {
            biggerChild = leftChild;
        } else {
            biggerChild = rightChild;
        }

        if (this.comparator.compare((E) this.elements[idx], (E) this.elements[biggerChild]) < 0) {
            swap(idx, biggerChild);
            heapifyDown(biggerChild);
        }
    }

    /**
     * Time: O(1)
     * Space: O(1)
     */
    public E peek() {
        if (this.size == 0) {
            return null;
        }
        return (E) this.elements[1];
    }

    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        heap.offer(1);
        System.out.println(heap.peek());
        heap.offer(2);
        System.out.println(heap.peek());
        heap.offer(9);
        System.out.println(heap.peek());
        heap.offer(3);
        System.out.println(heap.peek());
        heap.offer(8);
        System.out.println(heap.peek());
        heap.offer(6);
        System.out.println(heap.peek());
        heap.offer(11);
        System.out.println(heap.peek());
        heap.offer(4);
        System.out.println(heap.peek());
        heap.offer(5);
        System.out.println(heap.peek());
        heap.offer(7);
        System.out.println(heap.peek());
        heap.offer(10);
        System.out.println(heap.peek());
        heap.offer(12);
        System.out.println(heap.peek());
        heap.offer(13);
        System.out.println(heap.peek());
        for (int i = 0; i < 13; i++) {
            System.out.println(heap.poll());
            System.out.println(heap.peek());
        }
    }
}
