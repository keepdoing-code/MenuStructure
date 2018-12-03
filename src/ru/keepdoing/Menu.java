package ru.keepdoing;

import java.util.*;

/**
 * Created by yuri on 02.12.18.
 */
public class Menu implements Iterable<Menu> {
    final String name;
    Menu rootMenu = null;
    Card cardInfo = null;
    int itemsCounter = 0;
    int id = 0;
    Map<Integer, Menu> items = new HashMap<>();

    Menu(String name) {
        this.name = name;
    }

    int addItem(Menu item) {
        items.put(itemsCounter, item);
        return itemsCounter++;
    }

    int addSubMenu(Menu subMenu) {
        addItem(subMenu);
        subMenu.setRootMenu(this);
        return itemsCounter++;
    }

    void setRootMenu(Menu rootMenu) {
        this.rootMenu = rootMenu;
    }

    boolean isItem() {
        return itemsCounter == 0;
    }

    boolean haveCard() {
        return cardInfo != null;
    }

    Menu addCard(Card card) {
        this.cardInfo = card;
        return this;
    }

    Card getCard() {
        return this.cardInfo;
    }


    @Override
    public Iterator<Menu> iterator() {
        return items.values().iterator();
    }
}
