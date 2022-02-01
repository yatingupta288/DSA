class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        st.push(n - 1);
        int r[] = new int[n];
        r[n-1] = n;
        for(int i = n - 2; i >= 0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            
            if(st.size() == 0){
                r[i] = n;
            }else{
                r[i] = st.peek();
            }
            
            st.push(i);
        }
        
        st = new Stack<>();
        int l[] = new int[n];
        l[0] = -1;
        st.push(0);
        for(int i = 1; i < n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            
            if(st.size() == 0){
                l[i] = -1;
            }else{
                l[i] = st.peek();
            }
            
            st.push(i);
        }
        
        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, heights[i] * (r[i] - l[i] - 1));
        }
        return max;
    }
}