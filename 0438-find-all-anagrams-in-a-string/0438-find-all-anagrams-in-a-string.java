class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans= new ArrayList <>();

        int[] pfreq= new int[26];
        int[] wfreq= new int[26];

        if(s.length()<p.length()){
            return ans;
        }

        for(char c: p.toCharArray()){
            pfreq[c-'a']++;
        }

        int l=0;

        for(int r=0;r<s.length();r++){
              wfreq[s.charAt(r)-'a']++;
        

            if(r-l+1 > p.length()){
              wfreq[s.charAt(l)-'a']--;
              l++;
            }

            if(r-l+1 == p.length()){
              if (Arrays.equals(pfreq,wfreq)){
                ans.add(l);
              }
            }
        }

        return ans;
    }
}