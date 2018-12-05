package ru.keepdoing;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Card cardInfo = new Card().
                add(Card.Field.name, "Yuri").
                add(Card.Field.desc, "Coder").
                add(Card.Field.phone, "+7(911)500-00-00").
                add(Card.Field.link, "https://vk.com/yuri");

        Menu item1 = new Menu("Item 1").setCard(cardInfo);
        Menu item2 = new Menu("Item 2").setCard(cardInfo);
        Menu item3 = new Menu("Item 3").setCard(cardInfo);
        Menu item4 = new Menu("Item 4").setCard(cardInfo);

        Menu level2 = new Menu("Level 2");
        level2.addItem(item1);

        Menu level1 = new Menu("Level 1");
        level1.addItem(item2);
        level1.addItem(item3);
        level1.addSubMenu(level2);

        Menu rootMenu = new Menu("Level 0");
        rootMenu.addItem(item4);
        rootMenu.addSubMenu(level1);

        System.out.print(MenuWrapper.printMenu(rootMenu));

        MenuWrapper mw = new MenuWrapper(rootMenu, 0);

        while (true){
            Scanner s = new Scanner(System.in);
            String str = s.next();
            str = mw.dialog(str);
            System.out.printf(str);
        }
    }


}
