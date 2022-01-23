class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int number = 0;
        List<Integer> list = new ArrayList<>();
        for(int digit = 1; digit < 9; digit++){ // first digit range
            number = digit;
            int next = number; 
            while(number <= high && next < 10){
                if(number >= low){
                    list.add(number);
                }
                number = number * 10  + ++next;
            }
        }
        Collections.sort(list);
        return list;
    }
}

// 1. find the first digit of the numbers
// 2. iterate the number and add the digits
// 3. 