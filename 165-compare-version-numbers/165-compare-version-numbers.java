class Solution {
    public int compareVersion(String version1, String version2) {
        String v1[] = version1.split("\\.");
        String v2[] = version2.split("\\.");
        int i = 0;
        int j = 0;
        
        int num1 = 0;
        int num2 = 0;
        int n = Math.max(v1.length, v2.length);
        while(i < n){
            while(i < v1.length && j < v1[i].length()){
                num1 = num1 * 10 + v1[i].charAt(j) - '0';
                j++;
            }
            j = 0;
            while(i < v2.length && j < v2[i].length()){
                num2 = num2 * 10 + v2[i].charAt(j) - '0';
                j++;
            }
            j = 0;
            i++;
            if(num1 > num2){
                return 1;
            }else if(num1 < num2){
                return -1;
            }else{
                num1 = 0;
                num2 = 0;
                continue;
            }
        }
        return 0;
    }
}