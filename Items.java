import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Items {
    public int num;
    public int[] items;
    public int range = 2147480022;

    public Items() {
//        num = 1000000;
//        items = new int[num];
//        Random random = new Random();
//        for (int i = 0; i < num; i++) {
//            items[i] = random.nextInt(range);
//        }


        readFromFile();
    }

    public void readFromFile() {
        File file = new File("./src/items.txt");
        try {
            InputStream inputStream = new FileInputStream(file);
            byte[] b = new byte[(int) file.length()];
            inputStream.read(b);
            String str = new String(b);
            String[] number = str.split("\t");
            num = Integer.parseInt(number[0]);
            range = Integer.parseInt(number[1]);
            items = new int[num];
            for (int i = 0; i < num; i++) {
                items[i] = Integer.parseInt(number[i + 2]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showItems() {
        for (int i = 0; i < num; i++) {
            System.out.print(items[i] + "\t");
            if ((i + 1) % 20 == 0)
                System.out.print("\n");
        }
    }

}
