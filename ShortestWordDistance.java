// 243. , 244. , 245.
// time -O(n) - assuming word comparison is constant
// space - O(1)
// word1 and word 2 are unique
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        //edge
        if(words == null || words.length <= 1)
        {
            return 0;
        }
        
        int word1Index = -1; //tracks the indices at which word1 occurs
        int word2Index = -1; //tracks the indices at which word2 occurs
        
        int minDistance = Integer.MAX_VALUE; //return value
        
        for(int i = 0; i < words.length; i++)
        {
            if(word1.equals(words[i]))
            {
                word1Index = i; //word1 found - update the respective pointer
            }
            
            if(word2.equals(words[i]))
            {
                if(word1.equals(word2)) //both target words are same
                {
                    //restore the old index in word1Index and update word2Index to this index
                    word1Index = word2Index; 
                }
                word2Index = i; //word2 found - update the respective pointer
            }
            
            if(word1Index != -1 && word2Index != -1) //both words found
            {
                //update result if possible
                minDistance = Math.min(minDistance, Math.abs(word1Index - word2Index)); 
            }
        }
        
        return minDistance;
    }
}

// 244.
// time - O(n + ql) -> n is the length of words for building the map, l is the time for each query q
// space - O(n)
class WordDistance {
    
    HashMap<String, List<Integer>> wordIndices; //tracks the indices at which each word occurs
    
    public WordDistance(String[] words) {
        wordIndices = new HashMap<>();
        for(int i = 0; i < words.length; i++)
        {
            //for each word update the map with the new index
            if(!wordIndices.containsKey(words[i]))
            {
                wordIndices.put(words[i], new ArrayList<>()); 
            }
            wordIndices.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        //the wordIndices list are sorted due to the nature of population of the map
        List<Integer> word1Indices = wordIndices.get(word1);
        List<Integer> word2Indices = wordIndices.get(word2);
        
        int minDistance = Integer.MAX_VALUE; //return value
        int i = 0; //iteration ptr for 1st list
        int j = 0; //iteration ptr for 2nd list
        
        //as long as both lists have elements
        while(i < word1Indices.size() && j < word2Indices.size())
        {
            int word1Index = word1Indices.get(i); //get the indices
            int word2Index = word2Indices.get(j);
            
            //update the minDistance if possible and move i or j based upon the smaller index
            minDistance = Math.min(minDistance, Math.abs(word2Index - word1Index));
            if(word1Index < word2Index)
            {
                i++;
            }
            else if(word2Index < word1Index)
            {
                j++;
            }
        }
        
        return minDistance;
    }
}
