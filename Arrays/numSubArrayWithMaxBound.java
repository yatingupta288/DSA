class Solution {
    public int numSubarrayBoundedMax(int[] arr, int left, int right) {
        int si = 0;
        int ei = 0;
        int count = 0;
        int n = arr.length;
        int prevcount = 0;
        while(ei < n){
            if(left <= arr[ei] && arr[ei] <= right){
                prevcount = ei - si + 1;
                count += prevcount;
            }else if(arr[ei] < left){
                count += prevcount;
            }else{
                si = ei + 1;
                prevcount = 0;
            }
            ei++;
        }
        return count;
    }
}