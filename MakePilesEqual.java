//Alexa is given n piles of equal or unequal heights. In one step, Alexa can remove any number of boxes from the pile which has the maximum height and try to make it equal to the one which is just lower than the maximum height of the stack. Determine the minimum number of steps required to make all of the piles equal in height.
public class Main {
    public static void main(String[] args) {
        System.out.println(findMoves(new Integer[] {1,1,2,2,2,3,3,3,4,4})); //15
        System.out.println(findMoves(new Integer[] {1,2,2,3,3,4})); //9
        System.out.println(findMoves(new Integer[] {1,2,5})); //3
        System.out.println(findMoves(new Integer[] {1,2,4})); //3
        System.out.println(findMoves(new Integer[] {4,4,8,8})); //2
        System.out.println(findMoves(new Integer[] {4,8,8})); //2
        System.out.println(findMoves(new Integer[] {10,10})); //0
        System.out.println(findMoves(new Integer[] {10})); //0
    }
    
    //eg - [1,1,2,2,2,3,3,3,4,4] - 15
    //sort in reverse order - [4,4,3,3,3,2,2,2,1,1]
    //2 moves to get [3,3,3,3,3,2,2,2,1,1]
    //5 moves to get [2,2,2,2,2,2,2,2,1,1]
    //8 moves to get [1,1,1,1,1,1,1,1,1,1]
    //approach - sort the array in descending order as the largest pile has to be processed first
    //every time a different number is seen, count the number of elemnts in nums[] before the current and add to result
    //time - O(n logn)
    //space - constant
    private static int findMoves(Integer[] nums) {
        //edge
        if(nums == null || nums.length < 2)
        {
            return 0; //no moves needed
        }
        Arrays.sort(nums, (Integer a, Integer b) -> b - a); //sort in descending order
        int moves = 0; //return value;
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] != nums[i - 1]) //different number is seen
            {
                //add number of elements before i to result which is same as i
                moves += i;
            }
        }
        return moves;
    }
}
