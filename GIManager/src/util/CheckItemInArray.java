package util;

import java.util.Arrays;

public class CheckItemInArray {

    /**
     * Verifies if an item is in array.
     * @param array the array to inspect.
     * @param itemToSearch the item to search in.
     * @return returns if the item is in the array (true) or not (false).
     */
    public boolean inArray(String[] array, String itemToSearch){
        
        boolean inArray = Arrays.stream(array).anyMatch(item -> item == itemToSearch);

        return inArray;
    }
}
