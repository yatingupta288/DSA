class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]); 
        for(int j[]: boxTypes){
            pq.add(j);
        }
        int maxsize = 0;
        int maxunits = 0;
        while(!pq.isEmpty()){
            int[] curbox = pq.poll();
            if(maxsize <= truckSize){
                int s = truckSize - maxsize;
                if(curbox[0] > s){
                    maxsize += s;
                    maxunits += s * curbox[1];
                }else{
                    maxsize += curbox[0];
                    maxunits += curbox[0] * curbox[1];
                }
            }
        }
        
        return maxunits;
    }
}

class Solution {

    // TC : O(nlogn)
    // SC : O(1)
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Sort on the basis of unit in the box in decreasing order
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int maxUnitOfboxes = 0;
        for (int[] box : boxTypes) {
            int noOfBoxes = box[0];
            int noOfUnits= box[1];

            if (truckSize >= noOfBoxes) {
                maxUnitOfboxes += noOfBoxes * noOfUnits;
                truckSize -= noOfBoxes;
            }else {
                maxUnitOfboxes += truckSize * noOfUnits;
                return maxUnitOfboxes;
            }
        }
        return maxUnitOfboxes;
    }
}