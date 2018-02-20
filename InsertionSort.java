public class InsertionSort {
    public static Items items;

    public static void Sort() {
        for (int i = 1; i < items.num; i++) {
            int x = items.items[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (items.items[j] > x) {
                    items.items[j + 1] = items.items[j];
                }
            }
            items.items[j + 1] = x;
        }
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
