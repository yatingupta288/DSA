class Solution {
    public boolean validMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while(left < arr.length - 1 && arr[left] < arr[left + 1]){
            left++;
        }
        
        while(right > 0 && arr[right - 1] > arr[right]){
            right--;
        }
        // System.out.print(arr[left] + " " + arr[right]);
        if(left!= 0 && right != arr.length - 1 && left == right)return true;
        return false;
    }
}