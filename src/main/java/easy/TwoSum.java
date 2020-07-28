package easy;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

class TwoSum {

    public static void main(String[] args) {

        //https://www.baeldung.com/java-map-duplicate-keys
        //https://github.com/google/guava/wiki/NewCollectionTypesExplained

        //Adding duplicate keys overwrites the value with the latest added values
        //Remember that if the key already exists, then adding another value for the same key will also return the
        //previous values

        System.out.println("\nThis example shows that multiple values cannot be associated with the same key in a hash table or a hash map");
        Hashtable<String, String> ht = new Hashtable<>();
        ht.put("key1", "value1");
        ht.put("key1", "value2");
        for(Map.Entry<String, String> entry : ht.entrySet()){
            System.out.println("<" + entry.getKey() + ">" + "<" + entry.getValue() + ">");
        }

        //Mapping multiple values to the same key in Maps using the Apache Commons Library
        MultiValuedMap<String, String> multiValuedArrayListMap = new ArrayListValuedHashMap<>();
        multiValuedArrayListMap.put("key1", "value1");
        multiValuedArrayListMap.put("key1", "value2");
        multiValuedArrayListMap.put("key1", "value2");

        System.out.println("\nThis example shows that multiple values can be associated with the same key in MultiValuedMap");
        System.out.println("Also because we are storing the values in an ArrayListValuedHashMap, we can store the SAME value multiple times. \nAllows duplicates.");
        for (Map.Entry<String, String> entry : multiValuedArrayListMap.entries()){
            System.out.println("<" + entry.getKey() + ">" + "<" + entry.getValue() + ">");
        }

        System.out.println("\nHashSetValuedHashMap is storing multiple values for the same key, but using HashSetValuedHashMap");
        System.out.println("This will not allow duplicate values to be stored in the map");
        System.out.println("Also the order of insertion will not be maintained");
        MultiValuedMap<String, String> multiValuedHashSetMap = new HashSetValuedHashMap<>();
        multiValuedHashSetMap.put("key1", "value3");
        multiValuedHashSetMap.put("key1", "value1");
        multiValuedHashSetMap.put("key1", "value2");
        multiValuedHashSetMap.put("key1", "value2");

        for (Map.Entry<String, String> entry : multiValuedHashSetMap.entries()){
            System.out.println("<" + entry.getKey() + ">" + "<" + entry.getValue() + ">");
        }

        //Multiple values for the same key using the Google Guava library

        //ArrayListMultimap, which uses a HashMap backed by an ArrayList for every value:
        System.out.println("\nArrayListMultimap example shows that multiple values can be associated with the same key - using Guava");
        System.out.println("This should enable us to store duplicate values in ArrayList associated with the key");
        Multimap<String, String> multiArrayListMap = ArrayListMultimap.create();
        multiArrayListMap.put("key1", "value1");
        multiArrayListMap.put("key1", "value2");
        multiArrayListMap.put("key1", "value2");

        for(Map.Entry<String, String> entry : multiArrayListMap.entries()){
            System.out.println("<" + entry.getKey() + ">, " + "<" + entry.getValue() + ">");
        }

        System.out.println("\nLinkedHashMultimap does not let us store duplicate values for the same key");
        System.out.println("However it does store the natural order in which the elements were inserted into the hashMap");
        Multimap<String, String> multiLinkedHashMap = LinkedHashMultimap.create();
        multiLinkedHashMap.put("key1", "value3");
        multiLinkedHashMap.put("key1", "value1");
        multiLinkedHashMap.put("key1", "value2");
        multiLinkedHashMap.put("key1", "value2");

        for(Map.Entry<String, String> entry : multiLinkedHashMap.entries()){
            System.out.println("<" + entry.getKey() + ">, " + "<" + entry.getValue() + ">");
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int[] myArray = new int[2];
        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                int sum = nums[i] + nums[j];
                if(sum == target){
                    return new int[] {i,j};
                }
            }
        }
        return myArray;
    }

    public int[] twoSum_hashMap(int[] nums, int target) {

        int[] myArray = new int[2];
        Map<Integer, Integer> hashCopy = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            hashCopy.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++){
            if(hashCopy.containsKey(target - nums[i]) && hashCopy.get(target - nums[i]) != i){
                return new int[] {i, hashCopy.get(target - nums[i])};
            }
        }

        return myArray;
    }

    public int[] twoSum_hashTable(int[] nums, int target) {

        int[] myArray = new int[2];
        Hashtable<Integer, Integer> hashCopy = new Hashtable<>();

        for(int i = 0; i < nums.length; i++){
            hashCopy.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++){
            if(hashCopy.containsKey(target - nums[i]) && hashCopy.get(target - nums[i]) != i){
                return new int[] {i, hashCopy.get(target - nums[i])};
            }
        }

        return myArray;
    }

    public int[] twoSum_practice1(int[] nums, int target){

        if (nums == null || nums.length == 0) {
            return new int [] {-1, -1};
        }

        Map<Integer, Integer> num_index = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            num_index.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {

            int currNum = nums[i];
            int complement = target - currNum;

            Integer idx = num_index.get(complement);

            if (idx != null && idx != i) {
                return new int [] {i, idx};
            }

        }

        return new int [] {-1, -1};
    }

}