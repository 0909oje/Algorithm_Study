package SUAPC;

import java.util.*;

public class K {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		
		int num=0, pre = 0, now=0;

        for (int i = 2; i <= N; i++) {
                while (N % i == 0) {
                    arr[now]=i ;
                    now++; // 소인수 순서대로 배열에 넣음
                    N = N/i;
                    num++;
                }
        }
        
        Arrays.sort(arr);

        now=0; // arr[j] 꺼내오기 용
        int check=0;
        if(num<=3)  System.out.println("-1"); 
        else { // 합성소인수 만들 수 있을 떄
        	if(num%2==0 && N%2==0) { // num이 짝수, N 짝수
        		while(check!=num) {
        			if(arr[now]==0) {
        				now++;
        				continue; // 0이면 패스
        			}
        			
        			if(now%2!=0) pre = arr[now]; // index가 홀수인 수 * 짝수인 수
        			else {
        				int ans = pre*arr[now];
        				System.out.print(ans+" ");
        			}
        			now++; check++;
        		}
        	}else if(num%2!=0 && N %2==0) { // num이 홀수, N 짝수
        		while(check!=num-2) {
        			if(arr[now]==0) {
        				now++;
        				continue; // 0이면 패스
        			}
        			
        			if(now%2==0) pre = arr[now]; // index가 짝수 * 홀수
        			else {
        				int ans = pre*arr[now];
        				System.out.print(ans+" ");
        			}
        			now++; check++;
        		}
        		int ans = arr[now]*arr[now+1]*arr[now+2];
        		System.out.print(ans+" ");
        	}else if (num%2==0 && N %2!=0) { // num이 짝수, N 홀수
        		while(check!=num) {
        			if(arr[now]==0) {
        				now++;
        				continue; // 0이면 패스
        			}
        			
        			if(now%2==0) pre = arr[now]; // index 짝수 * 홀수
        			else {
        				int ans = pre*arr[now];
        				System.out.print(ans+" ");
        			}
        			now++; check++;
        		}
        	} else if (num%2!=0 && N %2!=0) { // num이 홀수, N 홀수
        		while(check!=num-2) {
        			if(arr[now]==0) {
        				now++;
        				continue; // 0이면 패스
        			}
        			
        			if(now%2!=0) pre = arr[now]; // index가 홀수인 수 * 짝수인 수
        			else {
        				int ans = pre*arr[now];
        				System.out.print(ans+" ");
        			}
        			now++; check++;
        		}
        		int ans = arr[now]*arr[now+1]*arr[now+2];
        		System.out.print(ans+" ");
        	} 
        }
	}
}
