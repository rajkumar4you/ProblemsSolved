class Solution {
    public void permutations(int a[],List<List<Integer>> list, ArrayList<Integer> ds,int vis[],int i,int n){
        for(int k=0;k<n;k++){
            if(vis[k]==0){
                vis[k]=1;
                ds.add(a[k]);
                permutations(a,list,ds,vis,k,n);
                vis[k]=0;
                ds.remove(ds.size()-1);
            }
        }
        if(ds.size()==n)
         list.add(new ArrayList<>(ds));
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        int vis[] =  new int[n];
        permutations(nums,list,new ArrayList<>(),vis,0,n);
        return list;
    }
}