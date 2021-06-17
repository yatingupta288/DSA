class Solution {
    public int reductionOperations(int[] n) {
        int res = 0, sz = n.length;
        Arrays.sort(n);
        for (int j = sz - 1; j > 0; --j)
            if (n[j - 1] != n[j]){
                System.out.println(sz - j);
                res += sz - j;         //sz - j tells about the no. of same elements ahead
            }
        return res;
    }
}

// TLE:
//  long j = 0;
//     public int reductionOperations(int[] nums) {
//         long a[] = FindMAndS(nums);
//         if(nums[(int)a[0]] != nums[(int)a[1]]){
//             j++;
//             nums[(int)a[0]] = nums[(int)a[1]];
//             reductionOperations(nums);
//         }else{
//             return 0;
//         }
//         return (int)j;
//     }
    
//     public long[] FindMAndS(int nums[]){
//         long arr[] = new long[2];
//         int max = 0;
//         int index = 0;
//         int smax = 0;
//         for(long i = 0; i < nums.length; i++){
//             if(max < nums[(int)i]){
//                 max = nums[(int)i];
//                 index = (int)i;
//             }
//         }
//         arr[(int)0] = index;
//         index = 0;
        
//         for(long i = 0; i < nums.length; i++){
//             if(nums[(int)i] != max){
//                 if(nums[(int)i] > smax){
//                     smax = nums[(int)i];
//                     index = (int)i;
//                 }
//             }
//         }
//         arr[(int)1] = index;
//         return arr;
//     }