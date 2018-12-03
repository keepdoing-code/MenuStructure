package ru.keepdoing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final String ASK_STRING = "> ";
    private static final String WRONG_INPUT = "Wrong input! Try again.";
    private static final String UNKNOWN_COMMAND = "Unknown command";
    private static final String WRONG_ITEM = "Wrong item";

    public static void main(String[] args) {

        Card cardInfo = new Card().
                add(Card.Field.name, "Yuri").
                add(Card.Field.desc, "Coder").
                add(Card.Field.phone, "+7(911)500-00-00").
                add(Card.Field.link, "vk.com/yuri");

        Menu item1 = new Menu("Item 1").setCard(cardInfo);
        Menu item2 = new Menu("Item 2").setCard(cardInfo);

        Menu subSubMenu = new Menu("Level 2");
        subSubMenu.addItem(item1);
        subSubMenu.addItem(item2);

        Menu subMenu = new Menu("Level 1");
        subMenu.addItem(item1);
        subMenu.addItem(item2);
        subMenu.addSubMenu(subSubMenu);

        Menu rootMenu = new Menu("Level 0");
        rootMenu.addItem(item1);
        rootMenu.addItem(item2);
        rootMenu.addSubMenu(subMenu);

        Menu menuPointer = rootMenu;

        dialog(menuPointer);
    }


    //need refactoring
    static void dialog(Menu menuPointer){
        String inStr = "";
        int num = 0;

        System.out.println();
        printMenu(menuPointer);

        while (true) {
            inStr = askInput(ASK_STRING);

            if(isNumber(inStr)){
            //menu item select
                num = Integer.parseInt(inStr);
                Menu m = menuPointer.getById(num);

                if(m == null) {
                    System.out.println(WRONG_ITEM);
                    continue;
                }
                if(m.isItem()) {
                    printCard(m.getCard(),"\t");
                    printMenu(menuPointer);
                }
                else {
                    menuPointer = m;
                    printMenu(m);
                }
            } else {
                //command select
                switch (inStr){
                    case "q":
                        System.exit(0);
                    case "b":
                        if(menuPointer.haveRoot()){
                            menuPointer = menuPointer.getRootMenu();
                        }
                        printMenu(menuPointer);
                        break;
                    default:
                        System.out.println(UNKNOWN_COMMAND);
                }
            }
        }
    }

    static String askInput(final String question) {
        try {
            Scanner s = new Scanner(System.in);
            System.out.printf(question);
            return s.next();
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println(WRONG_INPUT);
            return askInput(question);
        }
    }

    static void printMenu(Menu menu) {
        System.out.println(menu.getName());
        for (Menu m : menu) {
            System.out.printf("%d: %s\n", m.getId(), m.getName());
        }
        if(menu.haveRoot()) System.out.println("b: go back");
        System.out.println("q: exit app");
    }

    static void printCard(Card card, String tab) {
        for (String s : card) {
            System.out.println(tab + s);
        }
    }

    static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException | InputMismatchException e) {
            return false;
        }
    }

    static void printAllMenu(Menu menu, String tab) {
        for (Menu m : menu) {
            System.out.println(tab + m.getId() + ":\t" + m.getName());
            if (m.haveCard()) {
                //printCard(m.getCard(), tab + "\t");
            }
            if (!m.isItem()) {
                printAllMenu(m, tab + "\t");
            }
        }
    }
}
