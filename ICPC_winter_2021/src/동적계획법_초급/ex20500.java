package ������ȹ��_�ʱ�;
/*
 * 15��� : �� �ڸ��� ���� 3�� ����̸鼭 �����ڸ��� 0�Ǵ�5 -> �����ڸ� 5
- N : 4
 ->   - - - 5
 - N : 5
 ->   - - - - 5 
 */
import java.util.*;

public class ex20500 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] dp = new long[1516];
		dp[0]=dp[1]=0;
		dp[2]=dp[3]=1;
		for (int i=1 ; i<=N ; i++) {
			dp[i]=0;
		}
	}
}
