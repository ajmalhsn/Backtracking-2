// Time Complexity : O(2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// I have added both the iterative and recursive solution for this problem

// The logic is that we basically go over the array of list already present
// and keep on adding elements and inserting them as new list in the existing array of list

// we make use of for loop recursion where we keep track of the current index 
//based on which the element is added in the list

// Your code here along with comments explaining your approach
import java.util.ArrayList;
import java.util.List;

class Subsets {
    static List<List<Integer>> result;

    public static void main(String args[]) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums).toString());
    }

    public static List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        result.add(new ArrayList<>());
        // helper(nums, 0 , new ArrayList<>());
        
        for(int i = 0; i < nums.length; i++) {
            int size = result.size();
            
            for(int j = 0; j < size; j++) {
            List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
            // result.add(temp);
        }
        return result;
    }
    
    public static void helper( int[] nums, int idx, List<Integer> path) {
        
        result.add(path);
        for(int i = idx; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>(path);
            temp.add(nums[i]);
            helper(nums,i + 1, temp);
            // path.remove(path.size() - 1);
        }
        
    }
}