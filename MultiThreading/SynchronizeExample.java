
public class SynchronizeExample extends Thread{
    
    @Override
    public void run() {

        synchronized (this) {
            try {
                this.sleep(1000);
                System.out.println(currentThread().getName());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[]args){
        SynchronizeExample o1 = new SynchronizeExample();
        SynchronizeExample o2 = new SynchronizeExample();

        for(int i=0;i<10;i++){
            SynchronizeExample object = new SynchronizeExample();
            object.start();
        }
    }
}

