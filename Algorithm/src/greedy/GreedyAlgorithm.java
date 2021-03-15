package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");
        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("深圳");
        hashSet3.add("杭州");
        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");
        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        HashSet<String> allAreas = new HashSet<>();
        allAreas.addAll(hashSet1);
        allAreas.addAll(hashSet2);
        allAreas.addAll(hashSet3);
        allAreas.addAll(hashSet4);
        allAreas.addAll(hashSet5);

        //存放已选的电台的集合
        ArrayList<String> selected = new ArrayList<>();
        //临时集合，保存遍历的电台覆盖地区与当前未被覆盖地区的交集数量
        HashSet<String> tempSet = new HashSet<>();
        //定义maxKey，保存遍历过程中能够覆盖当前未被覆盖地区最大数量的电台
        //如果不为空则放入集合中
        String maxKey = null;
        while (allAreas.size() != 0) {
            //每次循环清空maxkey
            maxKey = null;
            //遍历broadcast取出对应key
            for (String key : broadcasts.keySet()) {
                //每次循环清空临时集合
                tempSet.clear();
                //取出key能够覆盖的地区
                HashSet<String> area = broadcasts.get(key);
                tempSet.addAll(area);
                //将tempset与allareas集合取交集，交集的值赋给tempset
                tempSet.retainAll(allAreas);
                //如果当前key覆盖的值大于0且maxkey为空或当前电台覆盖区域交集大于maxkey覆盖区域交集，则将当前电台赋给maxkey
                HashSet<String> maxKeySet = null;
                if (maxKey != null) {
                    maxKeySet = broadcasts.get(maxKey);
                    maxKeySet.retainAll(allAreas);
                }
                if (tempSet.size() > 0 &&
                        (maxKey == null || tempSet.size() > maxKeySet.size())) {
                    maxKey = key;
                }
            }
            //找到当前轮的最优解
            if (maxKey != null) {
                //加入已选电台集合
                selected.add(maxKey);
                //已选电台覆盖的区域从总区域中清除
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }

        System.out.println(selected);
    }
}
