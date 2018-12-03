package ru.keepdoing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final String ASK_STRING = "Enter item number: ";
    private static final String WRONG_INPUT = "Wrong input! Try again.";

    public static void main(String[] args) {

        Card cardInfo = new Card().
                add(Card.Field.name, "Yuri").
                add(Card.Field.desc, "Coder").
                add(Card.Field.phone, "+7(911)500-00-00").
                add(Card.Field.link, "vk.com/yuri");

        Menu item1 = new Menu("Item 1").setCard(cardInfo);
        Menu item2 = new Menu("Item 2").setCard(cardInfo);

        Menu subSubMenu = new Menu("SubSubmenu");
        subSubMenu.addItem(item1);
        subSubMenu.addItem(item2);

        Menu subMenu = new Menu("Submenu");
        subMenu.addItem(item1);
        subMenu.addItem(item2);
        subMenu.addSubMenu(subSubMenu);

        Menu rootMenu = new Menu("Root menu");
        rootMenu.addItem(item1);
        rootMenu.addItem(item2);
        rootMenu.addSubMenu(subMenu);
        rootMenu.addSubMenu(subSubMenu);
//--------------------------------------------------------
        Menu menuPointer = rootMenu;
        printAllMenu(rootMenu,"");
        menuPointer = askItem(ASK_STRING, rootMenu);

    }

    static Menu askItem(final String question, final Menu current){
        try{
            Scanner s = new Scanner(System.in);
            System.out.printf(question);
            int id = s.nextInt();
            return current.getById(id);
        }catch (NumberFormatException | InputMismatchException | NullPointerException e){
            System.out.println(WRONG_INPUT);
            return askItem(question, current);
        }
    }

    static void printMenu(Menu menu){
        System.out.println(menu.getName());
        for(Menu m: menu){
            System.out.printf("%d: %s\n", m.getId(), m.getName());
        }
    }

    static void printAllMenu(Menu menu, String tab){
        for(Menu m: menu){
            System.out.println(tab + m.getId() + " " + m.getName());
            if(m.haveCard()){
                //printCardInfo(m.getCard(), tab + "\t");
            }
            if(!m.isItem()){
                printAllMenu(m, tab + "\t");
            }
        }
    }

    static void printCardInfo(Card card, String tab){
        for (String s: card){
            System.out.println(tab + s);
        }
    }
}
