// 1004.
// time - O(n)
// space - constant
class Solution {
    public int longestOnes(int[] A, int K) {
        //edge
        if(A == null || A.length == 0)
        {
            return 0;
        }
        int start = 0; //tracks the current snippet
        int end = 0;
        int count = 0; //number of 0s in current snippet
        int result = 0; //return value
        while(end < A.length)
        {
            if(A[end] == 1)
            {
                //end can be part of a valid snippet
                end++;
            }
            else //current num is 0
            {
                if(count < K) //current 0 can be flipped and used 
                {
                    count++; //flipping current 0
                    end++;
                }
                else //current 0 cant be used
                {
                    //current snippet cant be expanded further
                    result = Math.max(result, end - start); //end is not part of current snippet
                    if(A[start] == 0)
                    {
                        count--; //flipping back the 0 pointed to by start
                    }
                    start++; //increase start to shrink the current snippet
                }
            }
        }
        result = Math.max(result, end - start); //calculate the last snippet too
        return result;
    }
}
