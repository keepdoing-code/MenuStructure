package ru.keepdoing;

public class Main {

    public static void main(String[] args) {

        Card cardInfo = new Card().
                add(Card.Field.name, "Yuri").
                add(Card.Field.desc, "Coder").
                add(Card.Field.phone, "+7(911)500-00-00").
                add(Card.Field.link, "vk.com/yuri");

        Menu item1 = new Menu("Item 1").addCard(cardInfo);
        Menu item2 = new Menu("Item 2").addCard(cardInfo);

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

        printAllMenu(rootMenu, "");

    }

    static void printAllMenu(Menu menu, String tab){
        //System.out.printf("< %s >\n", menu.name);
        for(Menu m: menu){
            System.out.println(tab + m.name);
            if(m.haveCard()){
                printCardInfo(m.getCard(), tab + "\t");
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
