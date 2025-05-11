import java.util.*;
// class Solution{
//     public static int quick(int[] arr,int low,int high)
//     {
//             int pivot = arr[low];
//             int i = low;
//             int j = high;
//             while(i<j)
//             {
//                 while(i<high &&  arr[i]<= pivot)
//                 {
//                     i++;
//                 }
//                 while(j>low && arr[j]>pivot)
//                 {
//                     j--;
//                 }
//                 if(i<j)
//                 {
//                     int temp = arr[i];
//                     arr[i] = arr[j];
//                     arr[j] = temp;
//                 }
//             }
//             int temp = arr[low];
//             arr[low] = arr[j];
//             arr[j] = temp;
//             return j;
//     }


//     public static void quicksort(int[] arr,int low,int high)
//     {
//         if(low<high)
//         {
//             int mid = quick(arr,low,high);
//             quicksort(arr,low,mid-1);
//             quicksort(arr,mid+1,high);
//         }
//     }
// }

// class Solution{
//     public static void mergesort(int[] arr,int low,int high)
//     {
//         if(low>=high)
//         {
//             return;
//         }
//         int mid = (low+high)/2;
//         mergesort(arr,low,mid);
//         mergesort(arr,mid+1,high);
//         merge(arr,low,mid,high);
//     }

//     public static void merge(int[] arr,int low,int mid,int high)
//     {
//         int i = low;
//         int j = mid+1;
//         int[] temp = new int[0];
//         if( i<=mid && j<=high)
//         {
//             while(i<=mid && j<=high)
//             {
//                 temp = Arrays.copyOf(temp,temp.length+1);
//                 if(arr[i]<arr[j])
//                 {
//                     temp[temp.length-1] = arr[i];
//                     i++;
//                 }
//                 else
//                 {
//                     temp[temp.length-1] = arr[j];
//                     j++;
//                 }
//             }
//             while(i<=mid)
//             {
//                 temp = Arrays.copyOf(temp,temp.length+1);
//                 temp[temp.length-1] = arr[i];
//                 i++;
//             }

//             while(j<=high)
//             {
//                 temp = Arrays.copyOf(temp,temp.length+1);
//                 temp[temp.length-1] = arr[j];
//                 j++;
//             }
//             int k = 0;
//             for(int it=low;it<=high;it++)
//             {
//                 arr[it] = temp[k];
//                 k++;
//             }
//         }
//     }
// }

public class Sort
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[0];
        int n = sc.nextInt();
        for(int i=0;i<n;i++)
        {
            arr = Arrays.copyOf(arr,arr.length+1);
            arr[arr.length-1] = sc.nextInt();
        }

    //selection sort
    //    for(int i=0;i<arr.length;i++)
    //    {
    //         int mini = i;
    //         for(int j=i;j<arr.length;j++)
    //         {
    //             if(arr[mini]>arr[j])
    //             {
    //                 mini = j;
    //             }
    //         }
    //         int temp = arr[i];
    //         arr[i] = arr[mini];
    //         arr[mini] = temp;
    //    }


    //insertion sort
    // for(int i=1;i<arr.length;i++)
    // {
    //     int j = i;
    //     int temp = arr[j];
    //     while(j>0 && arr[j-1]>temp)
    //     {
    //         arr[j] = arr[j-1];
    //         j--;
    //     }
    //      arr[j] = temp;
    // }


    //bubble sort
    // for(int i=0;i<arr.length;i++)
    // {
    //     for(int j=0;j<arr.length-i-1;j++)
    //     {
    //         if(arr[j]>arr[j+1])
    //         {
    //             int temp = arr[j];
    //             arr[j] = arr[j+1];
    //             arr[j+1] = temp;
    //         }
    //     }
    // }
    //bubble sort another one
    // for(int i=0;i<arr.length;i++)
    // {
    //     for(int j=1;j<arr.length-i;j++)
    //     {
    //         if(arr[j]<arr[j-1])
    //         {
    //             int temp = arr[j];
    //             arr[j] = arr[j-1];
    //             arr[j-1] = temp;
    //         }
    //     }
    // }

    //Mergesort
    // Solution.mergesort(arr,0,arr.length-1);

    //Quicksort
    // Solution.quicksort(arr,0,arr.length-1);

       System.out.println("ans_____________________");
       for(int i=0;i<arr.length;i++)
       {
        System.out.println(arr[i]);
       }

    }
}