package com.cambeeler;

import java.util.ArrayList;
import java.util.Vector;
import java.util.List;

public class GroceryList {
    private List<String> groceryList = new Vector<String>();

    public void addGroceryItem(String item){
//        if(item == null) {System.out.println("item == null - what a crock!"); System.exit(-1);}
//        System.out.println("Adding " + item + " to the grocery list");
        groceryList.add(item);
//        System.out.println("GroceryList::addGroceryList exit");

    }

    public List<String> getGroceryList() {
        return groceryList;
    }

    public void printGroceryList(){
        int listLength = groceryList.size();

        System.out.println("ArrayList is " + listLength + " elements");
        for (int i = 0; i< listLength; i++){
            System.out.println("List Item #" + (i+1) + " is " + groceryList.get(i));
        }
    }
    public void modifyGroceryItem(String newItem) {
        int position = findItem(newItem);
        if (position >= 0){
            modifyGroceryItem(position, newItem);
        }
    }
    public void modifyGroceryItem(int position, String newItem){
        groceryList.set(position, newItem);
        System.out.println("Grocery item " + (position+1) + " has been modified.");
    }

    public void removeGroceryItem(int position){
        if(position<groceryList.size() && position>0) {
            String theItem = groceryList.get(position);
            groceryList.remove(position);
        }
        else System.out.println("Please enter an item to delete between 1 and " + groceryList.size());
    }

    public int findItem(String searchItem){
       return groceryList.indexOf(searchItem);
    }
}
