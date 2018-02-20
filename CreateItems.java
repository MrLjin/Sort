import java.io.*;
import java.util.Random;

import static java.lang.System.exit;

public class CreateItems {
    public int num = 1000000;
    public int[] items;
    public int range = 80000;


    public CreateItems() {
        items = new int[num];
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            items[i] = random.nextInt(range);
        }
        Write2File();
    }

    public void Write2File() {
        File file = new File("items.txt");
        try {
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    System.out.println("文件创建失败！");
                    exit(1);
                }
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(String.valueOf(num) + "\t");
            bufferedWriter.write(String.valueOf(range) + "\t");
            for (int i = 0; i < num; i++) {
                bufferedWriter.write(String.valueOf(items[i]));
                bufferedWriter.write("\t");
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            System.out.println("写入成功！生成了一个大小为" + num + "，范围为0～" + range + "的随机数组");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CreateItems createItems = new CreateItems();
    }
}