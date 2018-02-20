public class MergeSort {
    public static Items items = new Items();


    public static void sort(int p, int r) {
        if (p < r) {
            try {
                int q = (p + r) / 2;
                sort(p, q);
                sort(q + 1, r);
                merge(p, q, r);

            } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                System.out.println("p=" + p + " r=" + r);
            }
        }
    }

    public static void merge(int p, int q, int r) {
        int n1 = q - p + 2;
        int n2 = r - q + 1;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(items.items, p, L, 0, n1 - 1);
//        for (int i = 0; i < n1 - 1; i++) {
//            L[i] = items.items[p + i];
//        }
        L[n1 - 1] = 2147483647;
        System.arraycopy(items.items, q + 1, R, 0, n2 - 1);
//        for (int i = 0; i < n2 - 1; i++) {
//            R[i] = items.items[q + i + 1];
//        }
        R[n2 - 1] = 2147483647;
        int m = 0, n = 0;
        for (int i = p; i <= r; i++) {
            if (L[m] < R[n]) {
                items.items[i] = L[m];
                m++;
            } else {
                items.items[i] = R[n];
                n++;
            }
        }
    }

    public static void merge_for(int p, int q, int r){
        int n1 = q - p + 2;
        int n2 = r - q + 1;
        int[] L = new int[n1];
        int[] R = new int[n2];
//        System.arraycopy(items.items, p, L, 0, n1 - 1);
        for (int i = 0; i < n1 - 1; i++) {
            L[i] = items.items[p + i];
        }
        L[n1 - 1] = 2147483647;
//        System.arraycopy(items.items, q + 1, R, 0, n2 - 1);
        for (int i = 0; i < n2 - 1; i++) {
            R[i] = items.items[q + i + 1];
        }
        R[n2 - 1] = 2147483647;
        int m = 0, n = 0;
        for (int i = p; i <= r; i++) {
            if (L[m] < R[n]) {
                items.items[i] = L[m];
                m++;
            } else {
                items.items[i] = R[n];
                n++;
            }
        }
    }

    public static void main(String[] args) {
//        items.showItems();
        long start = System.currentTimeMillis();
        sort(0, items.num - 1);
        long end = System.currentTimeMillis();
//        System.out.println("\n\n\n\n排序后：\n\n");
//        items.showItems();
        long cost = end - start;
        System.out.println("耗时：" + cost + "毫秒");
    }


}
