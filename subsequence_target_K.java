import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
   /* public static String swap(String str ,int left, int right) {
    	StringBuffer sbr  = new StringBuffer(str);
    	sbr.setCharAt(right, str.charAt(left));
    	sbr.setCharAt(left,str.charAt(right));
    	return sbr.toString();
    } */
	
	public static void subSequence(int a[],int i,int n,int k,int sum,ArrayList<Integer> list) {
		if(i==n)
			return;
		if(sum==k) {
			System.out.println(list);
			return;
		}
		list.add(a[i]);
		subSequence(a,i+1,n,k,sum+a[i],list);
		list.remove(Integer.valueOf(a[i]));
		subSequence(a,i+1,n,k,sum,list);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++)
			a[i] = sc.nextInt();
		int k = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		subSequence(a,0,n,k,0,list);
	}

}
