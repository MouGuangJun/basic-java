package demo5;

public class BaoZiPu extends Thread {
	private BaoZi bz;
	

	public BaoZiPu(String name,BaoZi bz){
		super(name);
		this.bz=bz;
	}
	
	@Override
	public void run() {
		int count=0;
		//�����
		while(true){
			synchronized (bz) {
				if(bz.flag==true){//���Ӵ��� 
					try {
						bz.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				//û�а���  �����
				System.out.println(Thread.currentThread().getName()+"��ʼ������ ");
				if(count%2==0){
					bz.pier="��Ƥ";
					bz.xianer="����";
				}else{
					bz.pier="��Ƥ";
					bz.xianer="ţ�����";
				}
				count++;
				bz.flag=true;
				System.out.println("���������:"+bz.pier+bz.xianer);
				System.out.println("�Ի����԰�");
				//���ѳԻ��߳�
				bz.notify();
			}
			
		}
	}
}
