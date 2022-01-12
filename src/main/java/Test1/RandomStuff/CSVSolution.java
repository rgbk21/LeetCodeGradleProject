package Test1.RandomStuff;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVSolution {

    public static void main(String[] args) {

        //ID,NAME,CITY,COUNTRY,CPERSON,EMPLCNT,CONTRCNT,CONTRCOST
        //00000001,Breadpot,Sydney,Australia,Sam.Keng@info.com,250,48,1024.00

        List<List<String>> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("/root/customers/data.csv"))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Total customers:" + records.size());

        // Customers by City:
        Map<String, Integer> cities = new TreeMap<>();
        Map<String, Integer> countries = new TreeMap<>();
        Map<String, Integer> customerContracts = new HashMap<>();
        int index = 0;

        for (int i = 0; i < records.size(); i++) {

            if (!cities.containsKey(records.get(i).get(2)) ) {
                cities.put(records.get(i).get(2), 1);
            } else {
                int prevCustomerCount = cities.get(records.get(i).get(2));
                prevCustomerCount = prevCustomerCount + 1;
                cities.put(records.get(i).get(2), prevCustomerCount);
            }


            if (!countries.containsKey(records.get(i).get(3)) ) {
                countries.put(records.get(i).get(3), 1);
            } else {
                int prevCustomerCount = countries.get(records.get(i).get(3));
                prevCustomerCount = prevCustomerCount + 1;
                countries.put(records.get(i).get(3), prevCustomerCount);
            }

            if (!customerContracts.containsKey(records.get(i).get(3))) {
                customerContracts.put(records.get(i).get(3), 1);
            } else {
                int prevCustomerCount = countries.get(records.get(i).get(3));
                prevCustomerCount = prevCustomerCount + 1;
                countries.put(records.get(i).get(3), prevCustomerCount);
            }

        }

        // Customers by city:
        System.out.println("Customers by city:");
        for (Map.Entry<String, Integer>  entry : cities.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Customers by country:");
        for (Map.Entry<String, Integer>  entry : countries.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Country with the largest number of customers' contracts:");
        int maxValue = 0;
        String maxCity = "";
        for (Map.Entry<String, Integer>  entry : customerContracts.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxCity = entry.getKey();
            }
        }
        System.out.println(maxCity + ": " + maxValue);

        System.out.println("Unique cities with at least one customer:" + cities.size());








    }

}
