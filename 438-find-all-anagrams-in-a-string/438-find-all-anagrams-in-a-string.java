class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length())return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        int count = 0;
        int a[] = new int[26];
        for(int k = 0; k < p.length(); k++){
            a[p.charAt(k) - 'a']++;
        }
        while(j < s.length()){
            if(a[s.charAt(j) - 'a'] > 0){
                a[s.charAt(j) - 'a']--;
                j++;
                count++;
            }else{
                count--;
                a[s.charAt(i) - 'a']++;
                i++;
            }
            if(count == p.length()){
                list.add(i);
            }
        }
        return list;
    }
}