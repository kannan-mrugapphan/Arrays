public class Main {
    public static void main(String[] args) {
        System.out.println(findK(new int[]{3, 2, -2, 5, -3 })); //3
        System.out.println(findK1(new int[]{3, 2, -2, 5, -3 })); //3
        System.out.println(findK(new int[]{1, 2, 3, -4})); //0
        System.out.println(findK1(new int[]{1, 2, 3, -4})); //0
    }
    
    //find largest k such that k and -k are in nums[]
    //time - O(n)
    //space - O(n)
    public static int findK(int[] nums) {
        HashSet<Integer> negatives = new HashSet<>(); //tracks -ve numbers
        for(int num : nums)
        {
            if(num < 0)
            {
                negatives.add(num);
            }
        }
        int result = 0; //return value - return 0 if no such k is present
        for(int num : nums)
        {
            if(num > 0 && negatives.contains(-num)) //if num is +ve and -(num) was seen before update result
            {
                result = Math.max(result, num);
            }
        }
        return result;
    }
    
    //time - O(n logn)
    //space - constant
    public static int findK1(int[] nums) {
        Arrays.sort(nums);
        int result = 0; //return value
        int low = 0;
        int high = nums.length - 1;
        while(low < high)
        {
            if(nums[low] + nums[high] == 0)
            {
                //valid pair is found - update result and return as this is the largest k(sorting)
                result = Math.max(result, nums[high]);
                return result;
            }
            else if(nums[low] + nums[high] < 0) //low is more -ve than high
            {
                low++;
            }
            else //sum is positive and high is more +ve
            {
                high--;
            }
        }
        return result;
    }
}
