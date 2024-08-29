package src.CollectionsFramework.Queue.QueueInterface.PriorityQueueClass;

import java.util.PriorityQueue;

class Pair{
    String word;
    int freq;
    Pair(String w, int f){
        this.word = w;
        this.freq = f;
    }
}
public class PriorityQueueClassMethods {

    // sort in decreasing order of freq;
    // in case of equal freq, sort in increasing lexico order of strings
    PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> {
        return b.freq != a.freq ? b.freq-a.freq : a.word.compareTo(b.word);
    });
}
