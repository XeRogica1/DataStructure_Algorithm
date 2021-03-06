package sparsearray;

public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始11*11二维数组，0表示无子，1表示黑子，2表示白子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //循环输出原始二维数组
        System.out.println("原始二维数组");
        for (int[] row:chessArr1) {
            for (int data:row) {
                System.out.print(data+" ");
            }
            System.out.println();
        }

        //二维数组转换为稀疏数组
        //1.遍历二维数组，获取非0数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("sum=" + sum);
        //2.创建稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //赋值数组属性值
        sparseArr[0][0] = chessArr1[0].length;//行数
        sparseArr[0][1] = chessArr1.length;//列数
        sparseArr[0][2] = sum;//非0值个数
        //添加非零数据
        int count = 0;//count同于计数第几个非零数据
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        //输出稀疏数组
        System.out.println("转换的稀疏数组");
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
        for (int[] row:chessArr1) {
            for (int data:row) {
                System.out.print(data+" ");
            }
            System.out.println();
        }
    }
}
