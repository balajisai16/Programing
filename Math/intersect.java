/*
	Given two arrays, write a function to compute their intersection.

		Example:
		Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

		Note:
		Each element in the result should appear as many times as it shows in both arrays.
		The result can be in any order.
		Follow up:
		What if the given array is already sorted? How would you optimize your algorithm?
		What if nums1's size is small compared to nums2's size? Which algorithm is better?
		What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0)
            return new int[0];
        Map<Integer,Integer> hashMap1 = new HashMap<Integer,Integer>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i< nums1.length;i++) {
            if(hashMap1.containsKey(nums1[i]))
                    hashMap1.put(nums1[i],hashMap1.get(nums1[i]) + 1);
                else
                    hashMap1.put(nums1[i],1);
        }
        for(int i=0; i< nums2.length;i++) {
            if(hashMap1.containsKey(nums2[i]) && hashMap1.get(nums2[i]) >= 1) {
                list.add(nums2[i]);
                hashMap1.put(nums2[i],hashMap1.get(nums2[i]) - 1);
            }
        }
        int result[] = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}