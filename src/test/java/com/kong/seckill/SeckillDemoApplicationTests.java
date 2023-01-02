package com.kong.seckill;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SeckillDemoApplicationTests {
    private static List<List<Integer>> list = new ArrayList();
    private static List<Integer> path = new ArrayList();
    public static void main(String[] args) {
        int nums[] = new int[3];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 2;
        //nums 可能包含重复元素 返回所有可能子集 不能包含重复子集 去重 used数组
        boolean[] used = new boolean[nums.length];
        new SeckillDemoApplicationTests().backtracking(nums, 0, used);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    public void backtracking(int[] nums, int startIndex, boolean[] used) {
        list.add(new ArrayList(path));
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, i + 1, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }


}
