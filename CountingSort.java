public class CountingSort {
    public static Items item;

    public static int[] Sort() {
        int[] count = new int[item.range + 1];
        int[] result = new int[item.num];
        for (int i = 0; i < item.num; i++) {
            count[item.items[i]]++;
        }
        for (int i = 1; i < item.range + 1; i++) {
            count[i] += count[i - 1];
        }
        for (int i = item.num - 1; i >= 0; i--) {
            result[--count[item.items[i]]] = item.items[i];
        }
        return result;
    }

    public static void main(String[] args) {
        item = new Items();
        long start = System.currentTimeMillis();
        int[] result = Sort();
        long end = System.currentTimeMillis();
        long cost = end - start;
//        for (int i = 0; i < result.length; i++) {
//            System.out.print(result[i] + "\t");
//            if ((i + 1) % 20 == 0)
//                System.out.print("\n");
//        }
        System.out.println(item.num + "个数据\t\t0～" + item.range + "数据范围");
        System.out.println("耗时：" + cost + "毫秒");
    }

}
