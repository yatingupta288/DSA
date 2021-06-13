// class MyCalendar {
//     private List<int[]> books = new ArrayList<>();
//     public boolean book(int start, int end) {
//         for (int[] b : books)
//             if (Math.max(b[0], start) < Math.min(b[1], end)) return false;
//         books.add(new int[]{ start, end });
//         return true;
//     }
// }

class MyCalendar {
    TreeMap<Integer, Integer> calender = new TreeMap<>();
    public MyCalendar() {
        calender = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        if(calender.floorEntry(start) != null && calender.floorEntry(start).getValue() > start){
            return false;
        }
        
        if(calender.ceilingEntry(start) != null && calender.ceilingEntry(start).getKey() < end){
            return false;
        }
        
        calender.put(start, end);
        return true;
    }
}

// class MyCalendar {
//     TreeSet<int[]> books = new TreeSet<int[]>((int[] a, int[] b) -> a[0] - b[0]);

//     public boolean book(int s, int e) {
//         int[] book = new int[] { s, e }, floor = books.floor(book), ceiling = books.ceiling(book);
//         if (floor != null && s < floor[1]) return false; // (s, e) start within floor
//         if (ceiling != null && ceiling[0] < e) return false; // ceiling start within (s, e)
//         books.add(book);
//         return true;
//     }
// }

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */