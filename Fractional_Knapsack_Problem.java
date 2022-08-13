//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item a[], int n) 
    {
       /* for(int i=0;i<n;i++){
            a[i].value = a[i].value/a[i].weight;
            System.out.println(a[i].value+" "+a[i].weight);
        }*/
        Arrays.sort(a,new Comparator<Item>(){
            public int compare(Item x,Item y){
                double d1 = (double)(y.value)/(double)(y.weight);
                double d2 = (double)(x.value)/(double)(x.weight);
                if(d1>d2)
                return 1;
                else if(d1==d2)
                return 0;
                else
                return -1;
            }
        });
       // (x,y)->((double)y.value)/((double)y.weight)-((double)x.value/(double)x.weight));
        /*for(int i=0;i<n;i++){
            System.out.println(a[i].value);
        }*/
        double sum=0;
        for(int i=0;i<n;i++){
            if(W<=0){
                break;
            }
            if(a[i].weight<=W){
            sum+= (a[i].value);
                W-=a[i].weight;
            }
            else{
                double d = (double)a[i].value/(double)a[i].weight;
                //System.out.println(d);
                sum+=(d)*(W);
                W-=W;
            }
            
            //System.out.println(a[i].value);
        }
        return sum;
    }
}