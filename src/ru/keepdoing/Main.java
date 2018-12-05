package ru.keepdoing;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Card cardInfo = new Card().
                add(Card.Field.name, "Yuri").
                add(Card.Field.desc, "Coder").
                add(Card.Field.phone, "+7(911)500-00-00").
                add(Card.Field.link, "vk.com/yuri");

        Menu item1 = new Menu("Item 1").setCard(cardInfo);
        Menu item2 = new Menu("Item 2").setCard(cardInfo);
        Menu item3 = new Menu("Item 2").setCard(cardInfo);

        Menu subSubMenu = new Menu("Level 2");
        subSubMenu.addItem(item1);

        Menu subMenu = new Menu("Level 1");
        subMenu.addItem(item1);
        subMenu.addItem(item2);
        subMenu.addItem(item3);
        subMenu.addSubMenu(subSubMenu);

        Menu rootMenu = new Menu("Level 0");
        rootMenu.addItem(item1);
        rootMenu.addItem(item2);
        rootMenu.addSubMenu(subMenu);

        Menu menuPointer = rootMenu;
        MenuWrapper mw = new MenuWrapper(menuPointer, 0);
        System.out.print(MenuWrapper.printMenu(menuPointer));

        while (true){
            Scanner s = new Scanner(System.in);
            String str = s.next();
            str = mw.dialog(str);
            System.out.printf(str);
        }
    }


}
