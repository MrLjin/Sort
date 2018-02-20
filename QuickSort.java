import java.util.Random;

public class QuickSort {
    public static Items item;

    public static int Partition(int p, int q) {
        int r = q, i = p - 1, j = p;
        for (; j < q; j++) {
            if (item.items[j] < item.items[r]) {
                int temp = item.items[++i];
                item.items[i] = item.items[j];
                item.items[j] = temp;
            }
        }
        int temp = item.items[i + 1];
        item.items[i + 1] = item.items[r];
        item.items[r] = temp;
        return i + 1;
    }

    public static int RandomPartition(int p, int q) {
        Random random = new Random();
        int r = random.nextInt(q - p + 1) + p;
        int t = item.items[r];
        item.items[r] = item.items[q];
        item.items[q] = t;
        return Partition(p, q);
    }

    public static void Sort(int p, int q) {
        if (p < q) {

            try {
                int m = Partition(p, q);
                Sort(p, m - 1);
                Sort(m + 1, q);
            } catch (Exception e) {
                System.out.println(p + q);
            }

        }
    }

    public static void main(String[] args) {
        item = new Items();
        long start = System.currentTimeMillis();
        Sort(0, item.num - 1);
        long end = System.currentTimeMillis();
        long cost = end - start;
        //item.showItems();
        System.out.println(item.num + "个数据\t\t0～" + item.range + "数据范围");
        System.out.println("耗时：" + cost + "毫秒");
    }
}
