package ����_ť_��;

import java.util.*;
import java.io.*;

public class ex10025 {
	public static void main(String[] args) throws Exception{
	       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       StringTokenizer st = new StringTokenizer(br.readLine());
	       int N = Integer.parseInt(st.nextToken());   	// �����絿��
	       int M = Integer.parseInt(st.nextToken()); 		// ��ǥ, �Ÿ�
	       
	       int[] ice = new int[1000000];
	       int max = 0, start=0, end=0, sum=0,ans = 0;
	       
	       for ( int i = 0 ; i < N ; i++){
	           st = new StringTokenizer(br.readLine());
	           int val = Integer.parseInt(st.nextToken());
	           int idx = Integer.parseInt(st.nextToken());
	           ice[idx] = val;                           // ��ǥ�� ���� ���� ����       
	           max  = Math.max(max,idx );      // ������ ���� ��ǥ ����
	          }
	       
	       while(end<= max) {
	     	  sum += ice[end];
	     	  ans = Math.max(sum, ans);
	     	  end++;
	     	  
	     	  if(end>M*2) {
	     		  sum -= ice[start];
	     		  start+=1;	  
	     	  } 
	       }
	       System.out.println(ans);	       
	}
}