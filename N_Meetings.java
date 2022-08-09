//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Meetings{
    public int start;
    public int end;
    public Meetings(int start,int end){
        this.start=start;
        this.end = end;
    }
}

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
          ArrayList<Meetings> list = new ArrayList<Meetings>();
          for(int i=0;i<n;i++){
              list.add(new Meetings(start[i],end[i]));
          }
          
          Collections.sort(list,new Comparator<Meetings>(){
              public int compare(Meetings a,Meetings b){
                  return a.end-b.end;
              }
          });
          int prev=-1,count=0;
          for(Meetings m :  list){
              if(m.start>prev){
                  count++;
                  prev = m.end;
              }
          }
          
          
          return count;
    }
}
