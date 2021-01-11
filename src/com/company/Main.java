package com.company;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static TodoList list = new TodoList();

    public static void main(String[] args) {
        navigation();
    }

    public static void navigation() {
        System.out.println("");
        System.out.println("Show (s), Add (a), Change (c) End (e)");
        String option = scanner.nextLine();
        switch (option) {
            case "s":
                list.showList();
                navigation();
                break;
            case "a":
                add();
                list.showList();
                navigation();
                break;
            case "c":
                change();
                break;
            case "e":
                System.out.println("Bye");
                break;
            default:
                navigation();
        }
    }

    public static void add(){
        System.out.println("Item Description: ");
        String description = scanner.nextLine();
        list.addItem(description);
    }

    static int index;
    public static void change() {
        getNumber(true);
        System.out.println("");
        System.out.println("Mark (m), Edit (e), Delete (d)");
        String option = scanner.nextLine();
        switch (option) {
            case "m":
                mark();
                break;
            case "e":
                edit();
                break;
            case "d":
                delete();
                break;
            default:
                navigation();
        }
    }

    public static void getNumber(boolean validated){
        System.out.println("");
        System.out.println("Which item to change? (Number)");
        boolean intValidation = scanner.hasNextInt();
        if(intValidation){
            index = scanner.nextInt() -1;
            scanner.nextLine();
        } else{
            scanner.nextLine();
            getNumber(true);
        }
    }

    public static void mark(){
        list.mark(index);
        list.showList();
        navigation();
    }

    public static void edit(){
        System.out.println("New item description:");
        String description = scanner.nextLine();
        list.change(index,description);
        list.showList();
        navigation();
    }

    public static void delete(){
        list.delete(index);
        list.showList();
        navigation();
    }

}
