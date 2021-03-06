package sparsearray;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SparseArrayInput {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SparseArrayIO"));
        int[][] sparseArr = (int[][]) ois.readObject();
        System.out.println("IO流获取转换的稀疏数组");
        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[i].length; j++) {
                System.out.print(sparseArr[i][j] + " ");
            }
            System.out.println();
        }

        //将稀疏数组还原成二维数组
        //1.根据稀疏数组第一行的数据创建数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        //2.遍历稀疏数组第二行开始，赋值数据
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println("转换的二维数组");
        for (int[] row:chessArr2) {
            for (int data:row) {
                System.out.print(data+" ");
            }
            System.out.println();
        }
    }
}
