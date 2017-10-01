/*
    Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<>();
        if(nums.length == 0)
        {
            result.add(temp);
            return result;
        }
        int count[] = new int[nums.length];
        for(int i=0;i<count.length;i++) {
            count[i] = 1;
        }
        
        result = permuteUtil(nums,count,result,temp,0);
        return result;
    }
    
    public List<List<Integer>> permuteUtil(int nums[],int count[],List<List<Integer>> result,List<Integer> temp,int level) {
        if(level == nums.length)
        {
            result.add(temp);
            return null;
        }
        else {
            for(int i=0;i<count.length;i++)
            {
                if(count[i]==0)
                    continue;
                if(temp.size() > level)
                    temp.set(level,nums[i]);
                else
                    temp.add(level,nums[i]);
                count[i]--;
                permuteUtil(nums,count,result,new ArrayList<>(temp),level+1);
                count[i]++;
            }
        }
        return result;
    }
}