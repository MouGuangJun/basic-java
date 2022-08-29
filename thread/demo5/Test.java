package demo5;
/*
 * 一个生产者和一个消费者没有问题
 * 多个消费者和一个生产的问题怎么解决？相当于生成了一个包子，被两个消费者在同时吃
 * 一个消费者多个生成的问题怎么解决？没有问题
 * 多个消费者和多个生产者的问题？没有问题
 * 
 * 
 * 
 * 等包子铺生产完五个包子后，再让多个消费者去消费
 */
public class Test {
	public static void main(String[] args) {
		BaoZi bz=new BaoZi();
		
		ChiHuo ch1=new ChiHuo("吃货1", bz);
		ChiHuo ch2=new ChiHuo("吃货2", bz);
		BaoZiPu bzp1=new BaoZiPu("包子铺1", bz);
		BaoZiPu bzp2=new BaoZiPu("包子铺2", bz);
		ch1.start();
		ch2.start();
		bzp1.start();
		bzp2.start();
	}
}
