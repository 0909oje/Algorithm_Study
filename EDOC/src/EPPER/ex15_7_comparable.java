package EPPER;

// ���� ȸ�ǽ� ������ �Ȱ��� ����

import java.util.*; 

public class ex15_7_comparable {
	public static class Person implements Comparable<Person>{
		int start;
		int end;
		public Person(int start, int end) {
			this.start=start;
			this.end=end;
		}
		 @Override
		 // ����ð� �������� ���� �� ������ ���۽ð� ��������
		    public int compareTo(Person p){
		    	if(this.end!=p.end)  return this.end-p.end; 
		    	else  return this.start-p.start;
		    }
	}
	
	  public static int solution(Person p[], int num){      
	      int answer = 0, N = num; // N�� �л� ��
	      int i, j, tmp, e1 = -1, e2 = -1; // e1, e2�� �� �ڸ��� �ǹ��մϴ�.
	      
	      Arrays.sort(p);	      
	      
	      for(i = 0; i < N; i++){
	          if(e1 <= p[i].start){ // 1�� �ڸ��� ����ִٸ� �л��� �Ҵ��մϴ�.
	              e1 = p[i].end; // 1�� �ڸ��� �л��� ���� �ð��� �����մϴ�.
	              answer++; 
	          }else if(e2 <= p[i].start){ // 2�� �ڸ��� ��� �ִٸ� �л��� �Ҵ��մϴ�.
	              e2 = e1; // �̹� �ڸ��� �Ҵ�� �л��� ���� �ð��� �����մϴ�.
	              e1 = p[i].end; // 1�� �ڸ��� �л��� ���� �ð��� �����մϴ�.
	              answer++;
	          }
	      }
	      return answer; // �л��� �Ҵ�� Ƚ���� ������ answer�� ��ȯ�մϴ�.
	  }
	  
	  public static void main(String args[]) {
		  Scanner sc = new Scanner(System.in);
		  int N = sc.nextInt();
		  
		  int s[] = new int[N];
		  int e[] = new int[N];
		  Person[] p = new Person[N];
		  for(int i=0 ; i<N ; i++) s[i]=sc.nextInt();
		  for(int i=0 ; i<N ; i++) e[i]=sc.nextInt();
		  for(int i=0 ; i<N ; i++) p[i]=new Person(s[i], e[i]);
		  
		  System.out.println(solution(p, N));
	  } 
	}
