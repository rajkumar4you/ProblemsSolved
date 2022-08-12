//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        ArrayList<ArrayList<Integer>> ar = new ArrayList<ArrayList<Integer>>(101); 
        int count=0,sum=0;
        for (int i = 0; i <= 101; i++)
            ar.add(new ArrayList<Integer>());
            
        for(int i=0;i<n;i++){
            //System.out.println(arr[i].deadline);
            ar.get(arr[i].deadline).add(arr[i].profit);
            //System.out.println(arr[i].profit);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=101;i>0;i--){
             for(Integer x : ar.get(i)){
                // System.out.print(x);
             pq.add(x);
             }
             //System.out.println();
             if(!pq.isEmpty()){
                 count++;
                 int p = pq.peek();
                 //System.out.println(p);
                 sum+=p;
                 pq.remove(p);
             }
        }
        //System.out.println(count+" "+ sum);
        int a1[] =  new int[2];
        a1[0] = count;
        a1[1] = sum;
        
        return a1;
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/