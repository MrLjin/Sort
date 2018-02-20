public class BucketSort {
    public static Items items;

    public static class Node {
        public Node head = null;
        public int data = 0;
        public Node next = null;
        public boolean list = true;

    }

    public static void Sort() {
        int divide = 1000;
        int bucketNum = items.range / divide;
        Node[] bucket = new Node[bucketNum];

        //Init bucket list
        for (int i = 0; i < bucketNum; i++) {
            bucket[i] = new Node();
        }

        //Put data into buckets
        for (int i = 0; i < items.num; i++) {
            Node next = new Node();
            next.data = items.items[i];
            next.list = false;
            if (bucket[items.items[i] / divide].next != null)
                bucket[items.items[i] / divide].next.head = next;
            next.head = bucket[items.items[i] / divide];
            next.next = bucket[items.items[i] / divide].next;
            bucket[items.items[i] / divide].next = next;
        }

        //Sort each bucket data -- Insertion Sort
        for (int i = 0; i < bucketNum; i++) {
            if (bucket[i].next != null && bucket[i].next.next != null) {
                Node node = bucket[i].next.next;
                while (node != null) {
                    Node p;
                    for (p = node.head; !p.list; p = p.head) {
                        if (p.data <= node.data)
                            break;
                    }
                    Node next = node.next;
                    if (p != node.head) {
                        p.next.head = node;
                        node.next = p.next;
                        p.next = node;
                        node.head = p;
                    }
                    node = next;
                }
            }
        }

        //Print all of the data in order
//        int t = 0;
//        for (int i = 0; i < bucketNum; i++) {
//            Node node = bucket[i].next;
//            while (node != null) {
//                System.out.print(node.data + "\t");
//                if (++t % 20 == 0)
//                    System.out.println();
//                node = node.next;
//            }
//        }
    }

    public static void main(String[] args) {
        items = new Items();
        long start = System.currentTimeMillis();
        Sort();
        long end = System.currentTimeMillis();
        long cost = end - start;

        System.out.println(items.num + "个数据\t\t0～" + items.range + "数据范围");
        System.out.println("耗时：" + cost + "毫秒");

    }
}
