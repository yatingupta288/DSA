class Solution {
        public List<Integer> sequentialDigits(int low, int high) {
            List<Integer> rv = new ArrayList<Integer>();
            int start_length = (int)Math.log10(low);
            int end_length = (int)Math.log10(high)+2;
            for (int length = start_length; length < end_length; length++) {
                for (int start = 1; start + length <= 10; start++) {
                    int number = start;
                    for (int len = 1; len < length; len++) {
                        number *= 10;
                        number += (len + start);
                    }
                    if (number >= low && number <= high) {
                        rv.add(number);
                    }
                }
            }
            return rv;
        }
    }