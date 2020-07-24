public class Main {
    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println(obj.partitionArray(new int[]{1, 2, 3, 4}, 2)); //true -[1,2], [3,4]
        System.out.println(obj.partitionArray(new int[]{1, 2, 3, 4}, 3)); //false 
        System.out.println(obj.partitionArray(new int[]{1, 2, 3, 3}, 2)); //true - [1,3], [2, 3]
        System.out.println(obj.partitionArray(new int[]{3, 6, 8, 3, 6, 8, 3, 6, 8}, 3)); //true - [3, 6, 8], [3, 6, 8], [3, 6, 8]
        System.out.println(obj.partitionArray(new int[]{1, 2, 3, 1, 2, 3, 1, 2, 2}, 3)); //false
        System.out.println(obj.partitionArray(new int[]{1}, 1)); //true - [1]
        System.out.println(obj.partitionArray(new int[]{1, 2}, 2)); //true - [1, 2]
    }
    
    //time - O(n)
    //space - O(n)
    public boolean partitionArray(int[] nums, int k) {
        //nums has to be broken into subsequences such that each subsequence is of length k and there should be no duplicates in each sequence
        //edge - nums cannot be broken into subsequences of length k if length of nums is not divisble by k
        if(nums.length % k != 0)
        {
            return false;
        }
        
        HashMap<Integer, Integer> counts = new HashMap<>(); //tracks the count of each element in nums[]
        int maxFreq = 0; //max frequency in nums[]
        for(int num : nums)
        {
            counts.put(num, counts.getOrDefault(num, 0) + 1); //update freq of num
            maxFreq = Math.max(maxFreq, counts.get(num)); //update max freq
        }
        
        //if the max freq is less than equal to # of subsequences = nums.length / k, then the max freq element and thus other elements can be broken into subsequences
        return (maxFreq <= nums.length / k);
    }
}
