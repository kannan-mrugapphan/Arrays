// 881.
// time - O(nlogn)
// space - constant
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        //edge
        if(people == null || people.length == 0)
        {
            return 0; 
        }
        
        int boatCapacity = 2; //max people in boat simultaneously
        //try to pair the most heaviest person with the most lightest person in 1 boat
        Arrays.sort(people);
        int lightest = 0;
        int heaviest = people.length - 1;
        int boats = 0; //return value
        
        while(lightest <= heaviest) 
        {
            int currentOccupancy = 1; //the heaviest person is assigned the boat
            int currentWeight = people[heaviest];
            //try to combine the current lightest in the same boat as long as limit and capacity conditions are true
            while(lightest != heaviest && currentOccupancy < boatCapacity && currentWeight + people[lightest] <= limit)
            {
                currentOccupancy++; //include the lightest person in the same boat
                currentWeight += people[lightest];
                lightest++;
            }
            heaviest--;
            boats++;
        }
        
        return boats;
    }
}
