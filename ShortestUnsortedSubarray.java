// 581.
// brute force - make a copy of ip -> sort the copy -> the first and last indices at which there is an element mismatch in ip and sorted copy is the resultant sub array -> time - O(nlogn) -> space - O(n)
//time - O(n) with const space
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        //edge
        if(nums == null || nums.length <= 1)
        {
            return 0;
        }
        
        boolean isSorted = true; //boolean tracks whether the ip is sorted so far or not
        int minimumInUnsortedPart = Integer.MAX_VALUE;
        int maxInUnsortedPart = Integer.MIN_VALUE;
        
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] < nums[i - 1]) //this portion of array is not sorted
            {
                isSorted = false; //reset the sort boolean
            }
            
            if(!isSorted)
            {
                minimumInUnsortedPart = Math.min(minimumInUnsortedPart, nums[i]); //update min in unsorted part
            }
        }
        
        isSorted = true; //reset to find max in 2nd pass
        for(int i = nums.length - 2; i >= 0; i--)
        {
            if(nums[i] > nums[i + 1]) //this part is unsorted
            {
                isSorted = false;
            }
            
            if(!isSorted)
            {
                maxInUnsortedPart = Math.max(maxInUnsortedPart, nums[i]); //update max in unsorted part
            }
        }
        
        int start = 0; //tracks the start and end of result subarray
        int end = 0;
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] > minimumInUnsortedPart) //minimumInUnsortedPart should be at ith index
            {
                start = i;
                break;
            }
        }
        
        for(int i = nums.length - 1; i >= 0; i--)
        {
            if(nums[i] < maxInUnsortedPart) //maxInUnsortedPart should be at ith index
            {
                end = i;
                break;
            }
        }
        
        return (start == end) ? 0 : end - start + 1; //size of sub array
    }
}
