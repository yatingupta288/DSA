class NumArray {
    private class segmentTree{
        int start, end;
        segmentTree left, right;
        int sum;
        
        segmentTree(int start, int end){
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }
    segmentTree root = null;
    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }
    
    private segmentTree buildTree(int[] nums, int start, int end){
        if(start > end){
            return null;
        }else{
            segmentTree ret = new segmentTree(start, end);
            if(start == end){
                ret.sum = nums[start];
            }else{
                int mid = (start + end)/2;
                ret.left = buildTree(nums, start, mid);
                ret.right = buildTree(nums, mid + 1, end);
                ret.sum = ret.left.sum + ret.right.sum;
            }
            return ret;
        }
    }
    
    public void update(int index, int val) {
        updateHelper(root, index, val);
    }
    
    private void updateHelper(segmentTree root, int index, int val){
        if(root.start == root.end){
            root.sum = val;
        }else{
            int mid = (root.start + root.end)/2;
            if(index <= mid){
                updateHelper(root.left, index, val);
            }else{
                 updateHelper(root.right, index, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }
    
    public int sumRange(int left, int right) {
         return sumRangehelper(root, left, right);
    }
    
    private int sumRangehelper(segmentTree root, int start, int end){
        if(root.start == start && root.end == end){
           return root.sum;
        }else{
            int mid = (root.start + root.end)/2;
            if(mid >= end){
                return sumRangehelper(root.left, start, end);
            }else if(mid + 1 <= start){
                return sumRangehelper(root.right, start, end);
            }else{
                return sumRangehelper(root.left, start, mid) + sumRangehelper(root.right, mid + 1, end);
            }
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */