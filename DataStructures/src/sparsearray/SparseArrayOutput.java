package sparsearray;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SparseArrayOutput {
    public static void main(String[] args) throws IOException {
        int[][] chessArr = new int[11][11];
        chessArr[0][1] = 1;
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        //循环输出原始二维数组
        System.out.println("原始二维数组");
        for (int[] row:chessArr) {
            for (int data:row) {
                System.out.print(data+" ");
            }
            System.out.println();
        }
        //二维数组转换为稀疏数组
        //1.遍历二维数组，获取非0数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("sum=" + sum);
        //2.创建稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //赋值数组属性值
        sparseArr[0][0] = chessArr[0].length;//行数
        sparseArr[0][1] = chessArr.length;//列数
        sparseArr[0][2] = sum;//非0值个数
        //添加非零数据
        int count = 0;//count同于计数第几个非零数据
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }

        //序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SparseArrayIO"));
        oos.writeObject(sparseArr);
        oos.flush();
        oos.close();
    }
}
