// 239.
// time - O((n - k + 1) + k);
// space - O(k);
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //edge
        if(nums == null || nums.length == 0)
        {
            return new int[0];
        }
        //number of possible sub arrays of size k in an array of size n is n - k + 1
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> support = new ArrayDeque<>(); //a doubly ended queue to maintain max in each sub array
        int start = 0; //possible starts of diff sub arrays
        int current = 0; //iteration pointer on nums[]
        while(start <= nums.length - k)
        {
            while(current - start + 1 <= k)
            {
                //as long as rear of deque is smaller than current, poll from last
                while(support.size() != 0 && nums[support.peekLast()] < nums[current])
                {
                    support.pollLast();
                }
                //if current element doen't beat the max in this sub array, insert into end
                if(support.size() == 0 || nums[support.peekLast()] >= nums[current])
                {
                    support.offerLast(current);
                }
                current++;
                
            }
            //at this point k elements are processed
            //add the max in this sub array (front of deque) to result[]
            result[start] = nums[support.peekFirst()];
            if(nums[start] == result[start])//if start points to max remove start from deque
            {
                support.pollFirst();
            }
            start++; //explore next sub array
        }
        return result;
    }
}
