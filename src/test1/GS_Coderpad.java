package src.test1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GS_Coderpad {

    public static void main(String[] args) throws FileNotFoundException {

        IPAddressFile();
    }

    public static void IPAddressFile() throws FileNotFoundException {
        String filePath = "/Users/prashantsahu/Downloads/Github Repos/data-structures-algorithms/src/test1/ipAdd.txt";

        FileReader fileReader = new FileReader(filePath);

        try(BufferedReader br = new BufferedReader(fileReader)){
            List<List<String>> data = new ArrayList<>();
            String line = "";
            Map<String, Integer> freqMap = new HashMap<>();

            while((line = br.readLine()) != null){

                String[] values = line.split(","); // first split by ,
                Arrays.stream(values).forEach((item) -> {
                    String[] temp = item.split(" "); // split each entry by space
                    String ip = temp[0];
                    freqMap.put(ip, freqMap.getOrDefault(ip,0)+1); //
                });
                // List<String> rowValues = new ArrayList<>();
                // Arrays.stream(values).forEach((item) -> rowValues.add(item.trim()));
                // data.add(rowValues);
            }

            Optional<Map.Entry<String, Integer>> mostFreqIP =  freqMap.entrySet().stream()
                    .max(Map.Entry.comparingByValue());

            List<String> mostFreqIps = new ArrayList<>();
            int maxFreq = mostFreqIP.get().getValue();

            // if there are more than 1 IP with the same max value
            freqMap.entrySet().stream().filter((e) -> e.getValue() == maxFreq).forEach((e) -> mostFreqIps.add(e.getKey()));

            mostFreqIps.stream().forEach(System.out::println);
            // mostFreqIP.ifPresent((e) -> System.out.println("Most freq IP = " + e.getKey() + " with value = " + e.getValue()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // find the ip add with max value

    }
}
