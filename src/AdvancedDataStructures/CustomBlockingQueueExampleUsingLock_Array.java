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
            Object data = queue[takeIndex];
            count--;
            System.out.println("Taking out from queue: " + data);

            if(takeIndex >= queueSize){
                takeIndex = 0;
            }
            putCondition.signalAll();
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
                    putCondition.await();
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }
            System.out.println("Putting value in queue = " + data);
            queue[putIndex] = data;
            count++;

            if(++putIndex >= queueSize){
                putIndex = 0;
            }
            takeCondition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        // BlockingQueue is a queue data structure that blocks all the threads trying to read(Consumer) the data from the queue
        // if the queue is empty, and similarly it blocks all the threads trying to add(Producer) the data to the queue if the queue is full.
        // due to this blocking feature, the queue is known as BlockingQueue.

        CustomBlockingQueueExampleUsingLock_Array customBlockingQueueExampleUsingLock = new CustomBlockingQueueExampleUsingLock_Array(5);

        Thread consumerThread = new Thread(() -> {
            int i=0;
            while(i<10){
                System.out.println("reading data: " + customBlockingQueueExampleUsingLock.take());
                i++;
            }
        });
        consumerThread.start();

        Thread producerThread = new Thread(() -> {
            int i=0;
            while(i<10){
                customBlockingQueueExampleUsingLock.put(i);
                System.out.println("writing data: " + i);
                i++;
            }
        });
        producerThread.start();
    }
}
