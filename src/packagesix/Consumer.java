package packagesix;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {
    private  TransferQueue<ShareItem> queue;

    public Consumer( TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(450);
        } catch (InterruptedException e) {
           // e.printStackTrace();
        }
    while (true){
        try {
            System.out.format("Processing  %s",queue.take().toString()+"\n");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }

    }
}
