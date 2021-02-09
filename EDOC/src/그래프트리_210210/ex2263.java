package �׷���Ʈ��_210210;

 // 1+ 2+ 4+ 8+...
// ������� : Ʈ���� ���� ���������̶� �� �����,,����

// �ο����� ����Ʈ���� �־��� -> �������� ã��
// �ο��� : �� -> ��Ʈ -> ��
// �������� : ��Ʈ -> �� -> ��
// ����Ʈ���� : �� -> �� -> ��Ʈ
/* �̷������� ��� : Ǯ�̸� ���� ���� ��������
 *public void preorder(Node root){
		System.out.print(root.data); //���� ��� ���
		if(root.left!=null) preorder(root.left); //�� ���� ����
		if(root.right!=null) preorder(root.right); //������ ������
	}
 */

import java.util.Scanner;
// �� ��û ����ߴµ� �� �ڵ�� ª������ �̰� �̷��� �������ΰ�
public class ex2263{
    static int [] inOrder = new int[100000];
    static int [] postOrder = new int[100000];
    static int [] position = new int[100001];
    
    static void solve(int is, int ie, int ps, int pe) {
        if(is>ie || ps>pe) return ;
        int root = postOrder[pe];
        System.out.print(root+" ");
        int inRoot = position[root]; //�ο����� ��Ʈ �ε���
        int left = inRoot-is; //����Ʈ������ ���� �ڽ��� ��
        solve(is, inRoot-1, ps, ps+left-1);
        solve(inRoot+1, ie, ps+left, pe-1);
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();    
        
        for(int i=0; i<n; i++)
            inOrder[i] = scan.nextInt();
        for(int i=0; i<n; i++)
            postOrder[i] = scan.nextInt();
        for(int i=0; i<n; i++)
            position[inOrder[i]] = i;
        
        solve(0, n-1, 0, n-1);
    }
 
}








