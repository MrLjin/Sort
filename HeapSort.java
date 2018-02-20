
public class HeapSort {

    public static class Heap {
        public int size;
        public int maxsize;
        public int[] heap;

        public Heap(int[] a) throws MyException {
            initHeap(a);
        }

        private void initHeap(int[] a) throws MyException {
            size = 0;
            BuildMaxHeapify(a);
        }

        public boolean hasLeftChild(int i) {
            return (2 * (i + 1) - 1 < size);
        }

        public boolean hasRightChild(int i) {
            return (2 * (i + 1) < size);
        }

        public void BuildMaxHeapify(int[] a) throws MyException {
            heap = new int[a.length];
            maxsize = a.length;
            System.arraycopy(a, 0, heap, 0, a.length);
            size = a.length;
            for (int i = size / 2; i >= 0; i--) {
                MaxHeapify(i);
            }
        }

        public void MaxHeapify(int i) throws MyException {
            if (i >= size)
                throw new MyException("下标不可达：" + String.valueOf(i));
            else {
                int max = i;
                if (hasLeftChild(i)) {
                    int left = 2 * (i + 1) - 1;
                    if (heap[left] > heap[max])
                        max = left;
                }
                if (hasRightChild(i)) {
                    int right = 2 * (i + 1);
                    if (heap[right] > heap[max])
                        max = right;
                }
                if (max != i) {
                    int t = heap[i];
                    heap[i] = heap[max];
                    heap[max] = t;
                    MaxHeapify(max);
                }
            }
        }

        public void printHeap() {
            for (int i = 0; i < size; i++) {
                System.out.print(heap[i] + "\t");
                if ((i + 1) % 20 == 0)
                    System.out.print("\n");
            }
            System.out.print("\n");
        }
    }

    private static Heap heap;
    private static Items items;

    private static void sort() {
        for (int i = 0; i < heap.maxsize - 1; i++) {
            int t = heap.heap[heap.maxsize - i - 1];
            heap.heap[heap.size - 1] = heap.heap[0];
            heap.heap[0] = t;
            heap.size--;
            try {
                heap.MaxHeapify(0);
            } catch (MyException e) {
                e.printStackTrace();
            }
        }
        heap.size = heap.maxsize;
    }

    public static void main(String[] args) {
        items = new Items();
        try {
            heap = new Heap(items.items);
        } catch (MyException e) {
            e.printStackTrace();
        }
        //heap.printHeap();
        long start = System.currentTimeMillis();
        sort();
        long end = System.currentTimeMillis();
        long cost = end - start;
        heap.printHeap();
        System.out.println("耗时：" + cost + "毫秒");
    }

}
