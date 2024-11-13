
import java.util.concurrent.Semaphore;
import java.util.Scanner;
//import java.lang.*;

public class Rw {

	
		
		
		static Semaphore mutex = new Semaphore(1);
		static Semaphore wrt = new Semaphore(1);
		static int readCount = 0;
		static String message = "hello i am A";
		static Scanner SC = new Scanner(System.in);
		static class Reader implements Runnable{
			public void run()
			{
				try
				{
					mutex.acquire();
					readCount++;
					if(readCount == 1)
					{
						wrt.acquire();
					}
					mutex.release();
					System.out.println("thread "+Thread.currentThread().getName()+" is REading:"+message);
					Thread.sleep(1500);
					System.out.println("thread "+Thread.currentThread().getName()+" has Finished REading:");
					mutex.acquire();
					readCount--;
					if (readCount == 0)
					{
						wrt.release();
					}
					mutex.release();
				}
				
				catch(InterruptedException e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
		static class writer implements Runnable
		{
			public void run()
			{
				try
				{
					wrt.acquire();
					message = "Good MOrning";
					System.out.println("thread "+Thread.currentThread().getName()+" is Writing:"+message);
					Thread.sleep(1500);
					System.out.println("thread "+Thread.currentThread().getName()+" is finished writing:");
					wrt.release();
				}
				catch(InterruptedException e)
				{
					System.out.println("e.getMessage()");
				}
			}
		}
	
		
public static void main(String[] args) throws Exception
		{
			Reader read = new Reader();
			writer write = new writer();
			Thread r1 = new Thread(read);
			r1.setName("Reader 1");
			Thread r2 = new Thread(read);
			r2.setName("Reader 2");
			Thread r3 = new Thread(read);
			r3.setName("Reader 3");
			Thread w1 = new Thread(write);
			w1.setName("Writer 1");
			Thread w2 = new Thread(write);
			w2.setName("Writer 2");
			Thread w3 = new Thread(write);
			w3.setName("Writer 3");
			w1.start();
			r1.start();
			w2.start();
			r2.start();
			w3.start();
			r3.start();
		}
}
		
		

	 
			
				

