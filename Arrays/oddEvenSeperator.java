import java.io.*;

class solution {
    
    public static void rearrange(int arr[] , int n){
        int i = 0;
        int j = 0;
        int temp;
        while(i < arr.length){
            if(arr[i] > 0){
                i++;
            }else{
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }
        }
    }
    
	static void printArray(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
 
    // Driver code
    public static void main(String args[])
    {
        int arr[] = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
        int n = arr.length;
 
        rearrange(arr, n);
        printArray(arr, n);
    }
}