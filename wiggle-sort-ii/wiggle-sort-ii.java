class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        int a[] = new int[nums.length];
        int j = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            if(j > n){
                j = 0;
            }
            a[j] = nums[i];
            j = j + 2;
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = a[i];
        }
    }
    
    public int[] Swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        
        return nums;
    }
}