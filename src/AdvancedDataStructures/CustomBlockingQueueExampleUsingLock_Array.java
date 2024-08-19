package AdvancedDataStructures;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CustomBlockingQueueExampleUsingLock_Array {

    private ReentrantLock lock = new ReentrantLock();
    private Condition putCondition = lock.newCondition();
    private Condition takeCondition = lock.newCondition();

    private Object[] queue;
    private int queueSize;

    private int putIndex;
    private int takeIndex;
    private int count;

    public CustomBlockingQueueExampleUsingLock_Array(int queueSize) {
        this.queueSize = queueSize;
        this.queue = new Object[queueSize];
    }

    private Object take(){
        lock.lock();
        try{
            // if there is no item in Queue, then take() should wait until producer adds 1 item;
            while(count == 0){
                try {
                    takeCondition.await();
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }
            Object data = queue[takeIndex++];  // if  we don't increment this index, consumer will pick the same old value
            // even after producer has pushed new ones.
            count--; // after taking data from queue, reduce count i.e. decrease size of queue;
            System.out.println("Taking out from queue: " + data + " from index = " + putIndex);

            // since we are incrementing the takeIndex, this check is necessary, other IndexOutOfBoundExcep
            if(takeIndex >= queueSize){
                takeIndex = 0;
            }
            putCondition.signalAll(); // signal to producer to add more elements;
            return data;
        }finally {
            lock.unlock();
        }
    }

    private void put(Object data){
        lock.lock();
        try{
            while(count >= queueSize){
                try{
                    putCondition.await(); // if queue is already full, producer should wait;
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }
            System.out.println("Putting value in queue = " + data + " at index = " + putIndex);
            queue[putIndex++] = data; // without this producer will keep writing to the same array index.
            count++; // after adding element into queue, increment count i.e. increase size of queue.

            // since we are incrementing the putIndex, this check is necessary, other IndexOutOfBoundExcep
            if(putIndex >= queueSize){
                putIndex = 0;
            }
            takeCondition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        // BlockingQueue is a queue data structure that blocks all the (Consumer) threads trying to
        // read the data from the queue if the queue is empty,
        // and similarly it blocks all the (Producer) threads trying to add the data to the queue if the queue is full.
        // due to this blocking feature, the queue is known as BlockingQueue.

        CustomBlockingQueueExampleUsingLock_Array customBlockingQueueExampleUsingLock
                = new CustomBlockingQueueExampleUsingLock_Array(5);

        Thread consumerThread = new Thread(() -> {
            int i=1;
            while(i<=10){
                System.out.println("reading data: " + customBlockingQueueExampleUsingLock.take());
                i++;
            }
        });
        consumerThread.start();

        Thread producerThread = new Thread(() -> {
            int i=1;
            while(i<=10){
                customBlockingQueueExampleUsingLock.put(i);
                System.out.println("writing data: " + i);
                i++;
            }
        });
        producerThread.start();
    }
}
