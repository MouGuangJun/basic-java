package demo5;
/*
 * һ�������ߺ�һ��������û������
 * ��������ߺ�һ��������������ô������൱��������һ�����ӣ���������������ͬʱ��
 * һ�������߶�����ɵ�������ô�����û������
 * ��������ߺͶ�������ߵ����⣿û������
 * 
 * 
 * 
 * �Ȱ�����������������Ӻ����ö��������ȥ����
 */
public class Test {
	public static void main(String[] args) {
		BaoZi bz=new BaoZi();
		
		ChiHuo ch1=new ChiHuo("�Ի�1", bz);
		ChiHuo ch2=new ChiHuo("�Ի�2", bz);
		BaoZiPu bzp1=new BaoZiPu("������1", bz);
		BaoZiPu bzp2=new BaoZiPu("������2", bz);
		ch1.start();
		ch2.start();
		bzp1.start();
		bzp2.start();
	}
}
