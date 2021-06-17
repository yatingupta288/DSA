class Solution {
    public boolean makesquare(int[] m) {
        int n = m.length;
        Arrays.sort(m);
        if(n < 4)return false;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += m[i];
        }
        
        int side[] = new int[4];
        if(sum % 4 == 0){
            for(int i = 0; i < 4; i++){
                side[i] = sum / 4;
            }
            return helper(m, 0, side);
        }else{
            return false;
        }
        
    }
    
    public boolean helper(int m[], int i, int side[]){
        if(i == m.length){
            if(side[0] == 0 && side[1] == 0 && side[2] == 0 && side[3] == 0){
                return true;
            }else{
                return false;
            }
        }
        
        for(int j = 0; j < 4; j++){
            if(side[j] < m[i])continue;
            side[j] -= m[i];
            if(helper(m, i + 1, side))return true;
            side[j] += m[i];
        }
        
        return false;
    }
}