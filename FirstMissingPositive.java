// 41.
// logic: the first missing positive will always lie between 1 and n+1 irrespective of the values in array
// brute force: make a set version of the i/p, for all numbers between 1 and n+1, check if it is present in the set, if not return it -> time - O(n), space - O(n)

//time - O(n)
//space - O(1)

class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return 1; //1st missing +ve
        }
        
        boolean isOnePresent = false; //checks if 1 is presnt in nums
        //replace all the negatives, zeros and positive numbers with values above size of nums to 1
        //this is done as these values don't contribute to anything
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 1)
            {
                isOnePresent = true;
            }
            else if(nums[i] <= 0 || nums[i] > nums.length)
            {
                nums[i] = 1;
            }
        }
        
        if(!isOnePresent)
        {
            return 1;
        }
        
        //make the corresponding indices as -ve
        for(int i = 0; i < nums.length; i++)
        {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0)
            {
                nums[index] *= -1;
            }
        }
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] > 0)
            {
                return i + 1;
            }
        }
        
        return nums.length + 1; //if i/p = [1,2,3], ans = 4(size of nums + 1)
    }
}
