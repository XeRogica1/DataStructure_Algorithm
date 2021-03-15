package kmp;

import java.util.Arrays;

public class KMPAlgorithm {
    public static void main(String[] args) {
        String s1 = "BBC ABCDAB ABCDABCDABDE";
        String s2 = "ABCDABD";
        int[] kmpCode = kmpCode("ABCDABA");
        System.out.println("部分匹配值表:" + Arrays.toString(kmpCode));
        int index = kmpSearch(s1, s2, kmpCode);
        System.out.println(index);
    }

    //获取字符串的部分匹配值
    public static int[] kmpCode(String str) {
        //创建int数组保存部分匹配值
        int[] code = new int[str.length()];
        //字符串长度为1则部分匹配值为0
        code[0] = 0;
        for (int i = 1, j = 0; i < str.length(); i++) {
            //字符不相等时，j后退至初始位尝试匹配
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = code[j - 1];
            }
            //字符相等时，匹配值+1
            if (str.charAt(i) == str.charAt(j)) {
                j++;
                code[i] = j;
            }
        }
        return code;
    }

    /**
     *kmp算法查找子串在源字符串第一次出现的下标
     * @param str1 源字符串
     * @param str2 查找的子串
     * @param code 子串的部分匹配值
     * @return 子串的下标,-1代表未找到
     */
    public static int kmpSearch(String str1, String str2,int[] code){
        //i遍历源字符串，j遍历子串
        for (int i = 0,j=0 ; i < str1.length(); i++) {
            //调整j
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = code[j - 1];
            }
            //找到匹配的第一个值
            if (str1.charAt(i)==str2.charAt(j)){
                j++;
            }
            //找到匹配字符串
            if (j==str2.length()){
                return i-j+1;
            }
        }
        //没找到匹配
        return -1;
    }
}
