package packagesix;

import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer( TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        for (int i = 1; i <=9 ; i++) {
queue.offer(new ShareItem("ShareItem-"+i,i));
            System.out.format(" Элемент 'ShareItem-%d' добавлен."+"\n",i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
               // e.printStackTrace();
            }
       if(queue.hasWaitingConsumer()==true){
           System.out.format("Consumer в ожидании!"+"\n");
       }

        }

    }
}
