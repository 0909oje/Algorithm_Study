import java.io.*;
import java.util.*;

public class Problem04 {
	public static void main(String[] args) {
		try {
			FileReader in = new FileReader("src\\test.txt");  
			int c;
			Scanner sc = new Scanner(System.in);
			while ((c = in.read()) != -1 ) { // �� ���ھ� ���� ������ �д´�.
				System.out.print((char)c);
				//�ٶ�� ������
				if((char)c==('\n')) {
					try {
						Thread.sleep(1000000);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				//q�Է¹�����
				if (sc.next().charAt(0)=='q')
					break;
			}
			in.close();
		}
		catch (IOException e) {
			System.out.println("����� ����");
		}

	}

}
