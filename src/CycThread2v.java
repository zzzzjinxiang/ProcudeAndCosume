public class CycThread2v implements Runnable{

    private Integer id;

    public CycThread2v(Integer id){
        this.id=id;
    }

    int sum = 0;

    @Override
    public void run() {
                synchronized (CycThread2v.class) {
                    if (sum % 3 == id) {
                        System.out.println(Thread.currentThread().getName() + ":" + sum);
                        sum++;
                    }
                }

    }

}
