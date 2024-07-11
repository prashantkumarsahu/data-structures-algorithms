package AdvancedDataStructures;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CustomBlockingQueueExampleUsingLock_LinkedList<T> {

    private ReentrantLock lock = new ReentrantLock();
    private Condition putCondition = lock.newCondition();
    private Condition takeCondition = lock.newCondition();

    private Queue<T> queue;
    private int queueSize;

    private int putIndex;
    private int takeIndex;
    private int count;

    public CustomBlockingQueueExampleUsingLock_LinkedList(int queueSize) {
        this.queueSize = queueSize;
        this.queue = new LinkedList<T>();
    }

    private T take(){
        lock.lock();
        try{
            // if there is no item in Queue, then take() should wait until producer adds 1 item;
            while(queue.isEmpty()){
                try {
                    takeCondition.await();
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }
            T data = queue.poll();
            System.out.println("Taking out from queue: " + data);
            // If queue was full, signal to put that queue is no longer full, and new items can be added, after the poll operation.
            putCondition.signalAll();
            return data;
        }finally {
            lock.unlock();
        }
    }

    private void put(T data){
        lock.lock();
        try{
            // queue is full, so new items cannot be added
            while(queue.size() == queueSize){
                try{
                    putCondition.await();
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }
            // when there is space, new items can be added.
            System.out.println("Putting value in queue = " + data);
            queue.offer(data);
            // signal to take that queue is no longer empty, after adding the item.
            takeCondition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        // BlockingQueue is a queue data structure that blocks all the threads trying to read(Consumer) the data from the queue
        // if the queue is empty, and similarly it blocks all the threads trying to add(Producer) the data to the queue if the queue is full.
        // due to this blocking feature, the queue is known as BlockingQueue.

        CustomBlockingQueueExampleUsingLock_LinkedList<Integer> customBlockingQueueExampleUsingLock = new CustomBlockingQueueExampleUsingLock_LinkedList<>(5);

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
