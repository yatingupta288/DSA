class Solution {
    public boolean rotateString(String s, String B) {
        if(s.length() != B.length()){
            return false;
        }
        
        if(s.length() == 0)return true;
        
        int si = 0;
        int bi = 0;
//         while( traversingS < s.length() || traversingB){
//             if(traversingS < s.length() && s.charAt(traversingS) == B.charAt(traversingB%B.length())){
//                 traversingS++;
//             }else{
//                 traversingS = 0;
//             }
            
//             treversingB++;
//         }
        
        for(int i = 0; i < B.length(); i++){
            bi = i;
            while(bi < B.length() && s.charAt(si) != B.charAt(bi)){
                bi++;
            }
            
            if(bi == B.length()){
                return false;
            }
            
            for(int k = 0; k < s.length(); k++){
                if(s.charAt(k) != B.charAt((k + bi)%B.length())){
                    break;
                }
                
                if(k == s.length() - 1)return true;
            }
            i = bi;
        }
        
        return false;
        
    }
}