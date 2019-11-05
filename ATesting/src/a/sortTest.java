package a;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

import javax.jws.Oneway;
import javax.management.Query;

public class sortTest {
	
	public static void main(String[] args) {
		int[] q = {123,23,24,234,242,4,12,43,57,7867564};
		int len = q.length;
		for (int i = 0; i < len; i++) {
			for (int j = len-1; j > i; j--) {
				if (q[j] < q[j-1]) {
					int temp = q[j];
					q[j] = q[j-1];
					q[j-1] = temp;
				}
			}
		}
		for (int i = 0; i < len; i++) System.out.print(q[i]+" ");
		
		int[] a = {12,3,4,56,7,8,987,4};
		System.out.println(Arrays.toString(a));
	}
	
	
}

