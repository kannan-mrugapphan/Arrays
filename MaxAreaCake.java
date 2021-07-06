// 1465.
// brute force - for every possible width (difference in elements of vertical cuts) and for every possible heights (diff in elements of hor cuts)
//compute the area and update the max - O(mn)

// max area = max width * max height
// time - O(nlogn + mlogm)
// space - constant

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts); //sort the arrays
        Arrays.sort(verticalCuts);
        
        //1st cut - diff between 0th index and 0
        //last cut - diff between h(or w) and last index
        int maxHeight = Math.max(horizontalCuts[0] - 0, h - horizontalCuts[horizontalCuts.length - 1]);
        int maxWidth = Math.max(verticalCuts[0] - 0, w - verticalCuts[verticalCuts.length - 1]);
    
        //for each diff update max
        for(int i = 1; i < horizontalCuts.length; i++)
        {
            maxHeight = Math.max(maxHeight, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        
        for(int i = 1; i < verticalCuts.length; i++)
        {
            maxWidth = Math.max(maxWidth, verticalCuts[i] - verticalCuts[i - 1]);
        }
        
        long ans = 1L * maxHeight * maxWidth;
        
        return  (int) (ans % 1000000007);
    }
}
