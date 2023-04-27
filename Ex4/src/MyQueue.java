public class MyQueue {
    private Integer[] arr = new Integer[10];
    private int size = 0;

    int getSize() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void enqueue(int item) {
        arr[size++] = item;
    }

    int dequeue() {
        int temp = arr[0];
        Integer[] arr2 = new Integer[arr.length + 1];
        System.arraycopy(arr, 1, arr2, 0, arr.length - 1);
        arr = arr2;
        size--;
        return temp;
    }

    int first() {
        return arr[0];
    }
}
