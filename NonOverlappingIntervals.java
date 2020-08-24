// 435.
// time - O(n logn)
// space - constant
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //edge
        if(intervals == null || intervals.length == 0)
        {
            return 0;
        }
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]); //sort intervals based on start times
        //compare intervals in pairs
        // case 1 - non overlapping intervals - no removal needed
        //     -----
        //           ------
        // case 2 - overlapping intervals - remove the interval with highest end time as it may overlap with subsequent intervals
        //     ------------
        //            ----------
        // case 3 - nested case - remove the long duration interval as it is more probable to overlap with others
        //     -----------
        //         ----
        int current = 0; //1st interval in current pair
        int next = 1; //2nd interval in current pair
        int result = 0;
     
        while(next < intervals.length)
        {
            if(intervals[current][1] <= intervals[next][0])
            {
                //next interval doesnt overlap with current interval - so no deletion needed
                current = next;
                next++;
            }
            else if(intervals[current][1] <= intervals[next][1]) //next interval ends after current ends - remove next
            {
                result++;
                next++;
            }
            else if(intervals[current][1] >= intervals[next][1]) //next ends before current - remove current
            {
                result++;
                current = next;
                next++;
            }
        }
        
        return result;
    }
}
