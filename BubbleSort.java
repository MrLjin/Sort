public class BubbleSort {
        public static Items items = new Items();


        public static void bubble(int n) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (items.items[j] > items.items[j + 1]) {
                        int t = items.items[j];
                        items.items[j] = items.items[j + 1];
                        items.items[j + 1] = t;
                    }
                }
            }
        }

        public static void main(String[] args) {
            //items.showItems();
            long start = System.currentTimeMillis();
            bubble(items.num);
            long end = System.currentTimeMillis();
            long cost = end - start;
            //System.out.println("\n\n\n\n排序后：\n\n");
            //items.showItems();
            System.out.println("耗时：" + cost + "毫秒");
        }
}
