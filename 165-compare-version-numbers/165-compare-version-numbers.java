class Solution {
    public int compareVersion(String version1, String version2) {
        String v1[] = version1.split("\\.");
        String v2[] = version2.split("\\.");
        
        int n = v1.length > v2.length ? v1.length : v2.length;
        
        for(int i = 0; i < n; i++){
            Integer a = i <v1.length ? Integer.parseInt(v1[i]):0;
            Integer b = i <v2.length ? Integer.parseInt(v2[i]):0;
            int val = a.compareTo(b);
            if(val != 0){
                return val;
            }
        }
        
        return 0;
    }
}