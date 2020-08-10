// 1375.
// time - O(n)
// space - constant
class Solution {
    public int numTimesAllBlue(int[] light) {
        //edge
        if(light == null || light.length == 0)
        {
            return 0;
        }
        int right = 0; //right at any point tracks right most bulb between 1 and N that is lit - initially 0 as no bulbs are lit
        int result = 0; //return value
        for(int i = 1; i <= light.length; i++)
        {
            int currentBulb = light[i - 1];
            right = Math.max(right, currentBulb); //update right if current is more towards right
            //if at any instance, the right most bulb that is lit is same as the time instant i, it means all bulbs before i are lit - so increase result by 1
            if(right == i) 
            {
                result++;
            }
        }
        return result;
    }
}
