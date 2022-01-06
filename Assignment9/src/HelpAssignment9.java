import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

public class HelpAssignment9 {

    public static int find_Min(int[] numb, int start_ind, int end_Ind){
        if (start_ind == end_Ind) {
             return numb[start_ind];
        }

       int value = find_Min(numb, start_ind + 1,end_Ind);

       if (numb[start_ind] < value)
             return numb[start_ind];
       else
             return value;
    }

    public static int compute_Sum_evenindex(int[] numb, int start_ind, int end_Ind){
        if (start_ind > end_Ind) {
             return 0;
        }
        if (start_ind%2==0)
             return numb[start_ind] + compute_Sum_evenindex(numb, start_ind + 1,end_Ind);
        else
             return 0 + compute_Sum_evenindex(numb, start_ind + 1,end_Ind);
     }

    public static int count_Divisible3(int[] numb, int start_ind, int end_Ind){
        if (start_ind == end_Ind) {
            if(numb[start_ind]%3==0)
                return 1;
            return 0;
        }

        if (numb[start_ind] > 0 && numb[start_ind]%3==0){
            System.out.println("="+numb[start_ind]);
             return 1 + count_Divisible3(numb, start_ind + 1,end_Ind);
        } else
             return 0 + count_Divisible3(numb, start_ind + 1,end_Ind);
     }

    public static int find_MaxOfLessfirst(int[] numb, int start_ind, int end_Ind, int firstNumber){
        if (start_ind == end_Ind) {
            if(numb[start_ind]<firstNumber)
                return numb[start_ind];
            return 0;
        }

       int value = find_MaxOfLessfirst(numb, start_ind + 1,end_Ind,firstNumber);

       if (numb[start_ind] > value && numb[start_ind] < firstNumber)
             return numb[start_ind];
        else
             return value;
     }

    public static void main(String[] args) throws IOException {
         BufferedReader reader11 = new BufferedReader(new InputStreamReader(System.in));
         String line11;
         int arr[] = new int[100];
         int i1 =0;
         while ((line11 = reader11.readLine()) != null) {
             arr[i1]=Integer.parseInt(line11);
             if(arr[i1]==0)
                break;
             i1++;
         }
         reader11.close();
         int start_ind=0;
         int end_Ind = i1;
         int numb[] = new int[end_Ind+1];

         System.arraycopy(arr, 0, numb, 0, end_Ind+1);
         System.out.println("The min value is : "+find_Min(numb, start_ind, end_Ind));
         System.out.println("The sum of even value is : "+compute_Sum_evenindex(numb, start_ind, end_Ind));
         System.out.println("divisible by 3 is : "+count_Divisible3(numb, start_ind, end_Ind));
         System.out.println("The maximum numb less than the first value is : "+find_MaxOfLessfirst(numb, start_ind, end_Ind, numb[0]));
    }
}

