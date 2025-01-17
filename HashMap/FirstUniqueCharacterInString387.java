/* 
 * 387.First Unique Character in a String
 *Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
Example 1:

Input: s = "leetcode"

Output: 0

Explanation:

The character 'l' at index 0 is the first character that does not occur at any other index.

Example 2:

Input: s = "loveleetcode"

Output: 2

Example 3:

Input: s = "aabb"

Output: -1

Constraints:
1 <= s.length <= 105
s consists of only lowercase English letters.
 */
import java.util.Map;
import java.util.HashMap;

 class FirstUniqueCharacterInString387 {
    public int firstUniqChar(String s) {
        Map<Character,Integer> frequencyMap=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            frequencyMap.put(ch,frequencyMap.getOrDefault(ch,0)+1);
        }

        for(int i=0;i<s.length();i++){
            if(frequencyMap.get(s.charAt(i))==1){
                return i;
            }
        }

        return -1;
    }
    /* Another approach using array:
     * public int firstUniqChar(String s) {
        int[] frequency=new int[26];

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            frequency[ch-'a']++;
        }

        for(int i=0;i<s.length();i++){
            if(frequency[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }
     */
    

    public static void main(String[] args) {
        //test
        System.out.println(new FirstUniqueCharacterInString387().firstUniqChar("leetcode"));
    }    
}