public class CycThread implements Runnable{
    int x=0;
    @Override
    public void run(){
        while(true){
            synchronized(this){
                notify();
                try{

                    Thread.currentThread().sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                if(x<101) {
                    System.out.println(Thread.currentThread().getName()+":"+x);
                    x=(x+1)%101;
                    try{
                        wait();
                    } catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
