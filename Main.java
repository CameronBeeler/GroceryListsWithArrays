package com.cambeeler;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
private static Scanner scan = new Scanner(System.in);
private static GroceryList groceries = new GroceryList();


    public static void main(String[] args) {
     boolean quit = false;
     int choice = 0;
     String input;

        printInstructions();
         while(!quit){
        System.out.println("Enter your Choice:");
             input = scan.nextLine();
             try {
                 choice = Integer.parseInt(input);
             } catch (NumberFormatException e) {
                 System.out.println("Please enter a number this time");
                 continue;
             }

        switch (choice){
            case 0:
                printInstructions();
                break;

            case 1:
                groceries.printGroceryList();
                break;

            case 2:
                addItem();
                break;
            case 3:
                modifyItem();
                break;
            case 4:
                removeItem();
                break;
            case 5:
                searchForItem();
                break;
            case 6:
                processArrayList();
            default:
                System.out.println("Thanks for Playing");
                quit=true;
                break;
        }

         }
    }
    public static void printInstructions(){
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options");
        System.out.println("\t 1 - To print the list of grocery items");
        System.out.println("\t 2 - To add an item(s) to the list");
        System.out.println("\t 3 - To modify an item in the list");
        System.out.println("\t 4 - To remove an item from the list");
        System.out.println("\t 5 - To search for an item in the list");
        System.out.println("\t any other value to exit the list");

    }

    public static void addItem(){
        boolean keepItGoing = true;
        System.out.print("Please enter item to add to grocery list: ");
        String loopie = "";

        do {
            System.out.println("Please enter 'q' when you are ready to quit");
            System.out.print("New grocery item:  ");
            loopie = scan.nextLine();
            if(loopie.contentEquals("q") ){
                keepItGoing = false;
                continue;
            }

            groceries.addGroceryItem(loopie);
            groceries.printGroceryList();

        } while(keepItGoing );
        groceries.printGroceryList();
        printInstructions();

    }

    public static void modifyItem(){

        System.out.print("Enter item number: ");
        int itemNo = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter replacement item: ");
        String newItem = scan.nextLine();
        groceries.modifyGroceryItem(itemNo-1, newItem);

    }
    public static void removeItem(){
        System.out.print("Enter item number: ");
        int itemNo = scan.nextInt();
        scan.nextLine();
        groceries.removeGroceryItem(itemNo-1);
    }

    public static void searchForItem(){
        System.out.print("Item to search for: ");
        String searchItem = scan.nextLine();
        if(groceries.findItem(searchItem) > 0) {
            System.out.println("Found " + searchItem + " in  our grocery list");
        } else {
            System.out.println(searchItem + " is not in the shopping list");
        }
    }


// HERE WE SHOW SEVERAL WAYS TO CREATE AND COPY ARRAY LISTS
    public static void processArrayList(){
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(groceries.getGroceryList());

// same outcome, different approach...
        ArrayList<String> nextArray = new ArrayList<>(groceries.getGroceryList());
        String[] myArray = new String[groceries.getGroceryList().size()];
        myArray = groceries.getGroceryList().toArray(myArray);

    }
}

