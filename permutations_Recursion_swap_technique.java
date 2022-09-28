class Solution {
    
 void permutations(List<List<Integer>> list, List<Integer> ds,int ind, int n){
     if(ind==n){
         list.add(new ArrayList<>(ds));
         return;
     }
     for(int k=ind;k<n;k++){
         Collections.swap(ds,ind,k);
         //System.out.println(ind+" "+ds);
         permutations(list,ds,ind+1,n);
         Collections.swap(ds,ind,k);
     }
 }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        ArrayList<Integer> ds = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
           ds.add(nums[i]);
        }
        //System.out.println(ds);
        permutations(list,ds,0,n);
        return list;
    }
}