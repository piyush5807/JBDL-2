public class MultithreadingUsingRunnable implements Runnable {

    @Override
    public void run() {
        try{
            System.out.println("Current thread's id is  " + Thread.currentThread().getName());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[]args){

        for(int i = 0; i < 10; i++){
            Thread obj = new Thread(new MultithreadingUsingRunnable());
            obj.start();
        }

    }
}
