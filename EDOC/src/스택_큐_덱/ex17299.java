package ����_ť_��;

import java.util.*;
import java.io.*;

public class ex17299{
    public static void main(String args[]) throws IOException {
        // ���ҽ� ���� �� �ʱ�ȭ
        Stack<Integer> s = new Stack<Integer>(); // ���� Ƚ�� �� �� �ڷᱸ��(����) �̿�
        
        // input �Է�
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // ������ ũ��
        int[] a = new int[n]; // ���� ������ �迭
        int[] f = new int[1000001]; // ������ Ƚ�� ������ �迭 (1<=����<=1,000,000)
        int[] ngf = new int[n]; // ����ū���� ������ �迭
        String[] temp = br.readLine().split(" ");
        for(int i = 0; i < n; i++) { // ���� �����
            a[i] = Integer.parseInt(temp[i]);
            f[a[i]] += 1;
        }
        
        s.push(0);
        for (int i = 0; i < n; i++) {
            if(s.isEmpty()) {
                s.push(i);
            }
            while(!s.isEmpty() && f[a[s.peek()]] < f[a[i]]) {
                // ����ū�� ���
                ngf[s.pop()] = a[i];
            }
            s.push(i);
        }

        while(!s.isEmpty()) {
            // ���� ���ÿ� �����ִ� �ε������� �������� �ش� ��ġ�� a[i]�� ����ū���� �������� �ʴ´�.
            ngf[s.pop()] = -1;
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int num : ngf) {
            bw.append(num + " ");
        }
        
        bw.write("\n");
        bw.flush();
        
    }
}