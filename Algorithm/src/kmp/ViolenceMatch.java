package kmp;

public class ViolenceMatch {
    public static void main(String[] args) {
        String s1 = "BBC ABCDAB ABCDABCDABDE";
        String s2 = "ABCDABD";
        int index = violenceMatch(s1,s2);
        System.out.println("index="+index);
    }

    public static int violenceMatch(String str1, String str2) {
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        int s1len = str1.length();
        int s2len = str2.length();

        int i = 0;//指向str1的下标
        int j = 0;//指向str2的下标
        while (i < s1len && j < s2len) {//防止下标越界
            if (c1[i] == c2[j]) {
                //成功匹配
                i++;
                j++;
            } else {
                //未成功匹配
                i = i - (j - 1);
                j = 0;
            }
        }
        if (j==s2len){
            return i-j;
        }else {
            return -1;
        }
    }
}
