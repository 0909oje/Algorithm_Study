package ��������_�÷��̵�ͼ�;
	import java.io.*;
	import java.util.Arrays;
	import java.util.StringTokenizer;

	public class ex1865_���۹��� {
	    // �� ������ �����ϱ� ���� Ŭ����
	    // static���� ������ ������ ���� ������ ���ؼ�.
	    static class Road{
	        // ��߳��
	        int start;
	        // �������
	        int end;
	        // �ɸ��� �ð�
	        int cost;

	        public Road(int start, int end, int cost){
	            this.start = start;
	            this.end = end;
	            this.cost = cost;
	        }
	    }

	    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    private static final int INF = 500 * 10_000;
	    static int n, m, w;
	    static Road[] roads;
	    static int[] dist;

	    public static void main(String[] args) throws IOException {
	        int testCnt = Integer.parseInt(br.readLine());
	        StringBuilder sb = new StringBuilder();

	        // �׽�Ʈ ������ŭ �ݺ�
	        for(int i = 0 ; i < testCnt; i++){
	            // �Է°��� ������ �ʱ�ȭ�Ѵ�.
	            init();
	            // ���� ����Ŭ�� �ִ� ���
	            if(bellmanFord())
	                sb.append("YES\n");
	            // ���� ����Ŭ�� ���� ���
	            else
	                sb.append("NO\n");
	        }

	        bw.write(sb.toString());

	        br.close();
	        bw.close();
	    }

	    private static void init() throws IOException {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        n = Integer.parseInt(st.nextToken());
	        m = Integer.parseInt(st.nextToken());
	        w = Integer.parseInt(st.nextToken());

	        dist = new int[n + 1];
	        roads = new Road[2 * m + w];

	        // roads[]�� �ε����� ��Ÿ����.
	        int index = 0;

	        for(int i = 0 ; i < m + w; i++){
	            st = new StringTokenizer(br.readLine());
	            int start = Integer.parseInt(st.nextToken());
	            int end = Integer.parseInt(st.nextToken());
	            int cost = Integer.parseInt(st.nextToken());

	            // �������̱� ������ �ݴ���⵵ �߰��Ѵ�.
	            if(i < m){
	                roads[index++] = new Road(start, end, cost);
	                roads[index++] = new Road(end, start, cost);
	            // ��Ȧ�� �������̱� ������ �ð��� * -1 ���־ �߰��Ѵ�.
	            }else{
	                roads[index++] = new Road(start, end, cost * -1);
	            }
	        }
	    }

	    private static boolean bellmanFord(){
	        // dist�迭�� INF�� �ʱ�ȭ
	        Arrays.fill(dist, INF);
	        // �������� 1�� ���� �����ϰ� dist[1]���� 0���� �ʱ�ȭ
	        dist[1] = 0;

	        // v - 1�� relax���ش�.
	        for (int i = 1; i < n; i++) {
	            // edge���� ��ŭ Ȯ���� �Ѵ�.
	            for (int j = 0; j < roads.length; j++) {
	                Road road = roads[j];

	                if (dist[road.start] != INF && dist[road.start] + road.cost < dist[road.end]){
	                    dist[road.end] = dist[road.start] + road.cost;
	                }
	            }
	        }

	        // ���� ����Ŭ ���� ����
	        for(int i = 0 ; i < roads.length; i++){
	            Road road = roads[i];
	            // ������ �� �� ���
	            if (dist[road.start] != INF && dist[road.start] + road.cost < dist[road.end])
	                return true;
	        }

	        // ������ ���� �ʰ� for���� �������� ���
	        return false;
	    }
	}