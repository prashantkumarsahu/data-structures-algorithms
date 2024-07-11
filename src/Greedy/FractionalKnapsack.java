package Greedy;

import java.util.Arrays;
import java.util.Comparator;

class Item implements Comparable<Item>{
    int weight;
    int value;

    public Item(int w, int v) {
        this.weight = w;
        this.value = v;
    }

    @Override
    public int compareTo(Item o) {
        return 0;
    }
}

class ItemComparator implements Comparator<Item>{

    @Override
    public int compare(Item o1, Item o2) {
        double valPerUnitWeightO1 = o1.value/o1.weight;
        double valPerUnitWeightO2 = o2.value/o2.weight;

        // sort in decreasing order of valPerUnitWeight
        if(valPerUnitWeightO2 >= valPerUnitWeightO1){
            return 1;
        }
//        else if(valPerUnitWeightO2 < valPerUnitWeightO1){
//            return -1;
//        }
        else {
            return -1;
        }

    }
}
// whole or some portion of the item can be taken into knapsack
public class FractionalKnapsack {
    public static void main(String[] args) {

        Item[] items = {new Item(10,60), new Item(40,40),new Item(20,100), new Item(30,120)};
        ItemComparator itemComparator = new ItemComparator();
        Arrays.sort(items,itemComparator);
        int knapsackCapacity = 50;
        int maxValue = 0;
        int len = items.length;

        for(int i=0;i<len;i++){
            System.out.println(items[i].weight + " " + items[i].value);

            if(items[i].weight <= knapsackCapacity){
                knapsackCapacity -= items[i].weight;
                maxValue += items[i].value;// add first item of max value, as array is sorted in decreasing order of val per unit weight
            }else{
                maxValue += ((double)items[i].value/items[i].weight)*knapsackCapacity; // add fraction of the item into the remaining knapsack
                break;
            }
        }
        System.out.println(maxValue);
    }
}
