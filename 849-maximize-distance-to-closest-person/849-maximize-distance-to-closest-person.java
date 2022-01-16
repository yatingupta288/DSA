class Solution {
    public int maxDistToClosest(int[] seats) {
        int left = 0;
        int right = 0;
        int count1 = 0;
        int count2 = 0;
        int i = 0;
        int res = Integer.MIN_VALUE;
        while(i < seats.length){
            if(seats[i] == 0){
                left = right = i;
                while(seats[left] != 1){
                    if(left == 0){
                        count1 = Integer.MAX_VALUE;
                        break;
                    }
                    left--;
                    count1++;
                }
                while(seats[right] != 1){
                    right++;
                    count2++;
                    if(right == seats.length){
                        count2 = Integer.MAX_VALUE;
                        break;
                    }
                }
                // System.out.print(count1 + " " + count2 + "*");
                res = Math.max(res, Math.min(count1, count2));
                count1 = 0;
                count2 = 0;
            }
            i++;
        }
        return res;
    }
}