package com.company;

import java.util.ArrayList;

public class TodoList {
    ArrayList<Item> todoList = new ArrayList<Item>();

    public void addItem(String description) {
        Item newItem = new Item(description);
        todoList.add(newItem);
    }

    public void showList() {
        int counter = 0;
        for (int i = 0; i < todoList.size(); i++) {
            Item item = todoList.get(i);
            char completed = item.isCompleted() ? '\u2611' : '\u2610';
            int listNumber = i + 1;
            System.out.println(listNumber + ". " + completed + " " + item.getDescription());
        }
    }

    public void mark(int itemNumber) {
        boolean exists = todoList.size() >= itemNumber + 1;
        if (exists) {
            boolean completed = todoList.get(itemNumber).isCompleted();
            todoList.get(itemNumber).setCompleted(!completed);
        }
    }

    public void change(int itemNumber, String description) {
        boolean exists = todoList.size() >= itemNumber + 1;
        if (exists) {
            todoList.get(itemNumber).setDescription(description);
        }
    }

    public void delete(int itemNumber) {
        boolean exists = todoList.size() >= itemNumber + 1;
        if (exists) {
            todoList.remove(itemNumber);
        }
    }
}

