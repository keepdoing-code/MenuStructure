package ru.keepdoing;

import java.util.*;

/**
 * Created by yuri on 02.12.18.
 */
public class Menu implements Iterable<Menu> {
    private final String name;
    private Menu rootMenu = null;
    private Card cardInfo = null;
    private int itemsCounter = 0;
    private int id;
    private Map<Integer, Menu> items = new HashMap<>();

    @Override
    public Iterator<Menu> iterator() {
        return items.values().iterator();
    }

    Menu(String name) {
        this.name = name;
    }

    int addItem(Menu item) {
        items.put(itemsCounter, item);
        item.setId(itemsCounter);
        return itemsCounter++;
    }

    void addSubMenu(Menu subMenu) {
        subMenu.setRootMenu(this);
        addItem(subMenu);
    }

    Menu setCard(Card card) {
        this.cardInfo = card;
        return this;
    }

    Menu getById(int menuId){
        return items.get(menuId);
    }

    boolean haveRoot(){return rootMenu != null;}

    boolean isItem() { return itemsCounter == 0; }

    boolean haveCard() { return cardInfo != null; }

    Card getCard() { return this.cardInfo; }

    String getName(){ return name; }

    Menu getRootMenu(){ return rootMenu; }

    int getId(){ return id;}

    private void setId(int id) { this.id = id; }

    private void setRootMenu(Menu rootMenu) { this.rootMenu = rootMenu; }

    class NotExist extends Exception{}
}
