class Compute {
    
    public void rotate(long arr[], long n)
    {
        long temp;
        temp = arr[(int)(n - 1)];
        for(long i = n - 1; i > 0; i--){
            System.out.println(arr[(int)i]);
            arr[(int)i] = arr[(int)i - 1];
        }
        arr[(int)0] = temp;
    }
}