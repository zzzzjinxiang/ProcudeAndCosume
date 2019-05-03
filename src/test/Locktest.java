package test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class depaModel {
        private int size;
        private Lock lock;
        private int capacity;
        private Condition emptyCondition;
        private Condition fullCondition;

        public depaModel(int capacity){
            this.capacity = capacity;
            this.size = 0;
            this.lock = new ReentrantLock();
            this.emptyCondition = lock.newCondition();
            this.fullCondition = lock.newCondition();
        }

        public void producer(int val){
            lock.lock();
            try{
                int left = val;
                int inc;
                while(left>0){
                    while(size>=capacity)
                        fullCondition.await();
                    if((size+left)>capacity){
                        inc = capacity - size;
                    }else inc = left;
                    left -= inc;
                    size += inc;
                    System.out.println(Thread.currentThread().getName()+ "produce"+ val + "-->left="+left + " inc=" + inc + " size" + size);
                    emptyCondition.signal();
                }
            } catch (InterruptedException e){
            } finally {
                lock.unlock();
            }
        }

        public void consumer(int val){
            lock.lock();
            try{
                int left = val;
                int dec;
                while(size <= 0 )
                    emptyCondition.await();
                if(size - left <0){
                    dec = size;
                }else dec = left;
                size -=dec;
                left -=dec;
                System.out.println(Thread.currentThread().getName()+ "consume"+ val + "-->left="+left + " dec=" + dec + " size" + size);
            } catch (InterruptedException e){
            } finally {
                lock.unlock();
            }
        }

        public String toString(){
            return "capacity:" + capacity + ", actual size:" + size;
        }
}

class producer{
    private depaModel depaModel;

    public producer(depaModel depaModel){
        this.depaModel = depaModel;
    }

    public void produce(final int val){
        new Thread(){
            @Override
            public void run(){
                depaModel.producer(val);
            }
        }.start();
    }
}

class consumer{
    depaModel depaModel;

    public consumer(depaModel depaModel){
        this.depaModel = depaModel;
    }

    public void consumer(final int val){
        new Thread(){
            @Override
            public void run() {
                depaModel.consumer(val);
            }
        }.start();
    }
}

public class Locktest{
    public static void main(String[] agrs){
        depaModel depa = new depaModel(80);
        producer pro = new producer(depa);
        consumer con = new consumer(depa);

        pro.produce(60);
        con.consumer(70);
        pro.produce(80);
        con.consumer(50);
    }
}
