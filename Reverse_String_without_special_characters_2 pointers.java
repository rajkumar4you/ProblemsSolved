import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


@FunctionalInterface
interface Predicate{
	
	boolean test(int n);
	
}

public class Test {
    public static String swap(String str ,int left, int right) {
    	StringBuffer sbr  = new StringBuffer(str);
    	sbr.setCharAt(right, str.charAt(left));
    	sbr.setCharAt(left,str.charAt(right));
    	return sbr.toString();
    }
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	String s = sc.nextLine();
	
	//String s2="";
	int left=0,right=s.length()-1;
	
	while(left<right) {
		//if(StringUtils.isAlphanumeric(s.charAt(left)))
		if(!(s.charAt(left)>='a' && s.charAt(left)<='z')) {
			left++;
		}
		else if(!(s.charAt(right)>='a' && s.charAt(right)<='z')) {
			right--;
		}
		else {
			s = swap(s,left,right);
			left++;
			right--;
		}
		
	}
	System.out.print(s);
	
	}

}
