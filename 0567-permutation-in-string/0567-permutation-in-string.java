class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1freq = new int [26];
        int[] s2freq = new int [26];

        int l=0;

        if (s1.length() > s2.length()) return false;

        for(char c : s1.toCharArray()){
            s1freq[c-'a']++;
        }
        for(int r = 0; r< s2.length(); r++){
                s2freq[s2.charAt(r)-'a']++;

                if(r-l+1>s1.length()){
                 s2freq[s2.charAt(l)-'a']--;
                 l++;
                }
                if(r-l+1 == s1.length()){
                  if(Arrays.equals(s1freq,s2freq)){
                     return true;
                  }
                }
            }

        return false; 
    }
}