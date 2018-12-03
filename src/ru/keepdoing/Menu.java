package ru.keepdoing;

import java.util.*;

/**
 * Created by yuri on 02.12.18.
 */
public class Menu implements Iterable<Menu> {
    private final String name;
    private Menu rootMenu = null;
    private Card cardInfo = null;
    private int itemsCounter = 1;
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

    int addSubMenu(Menu subMenu) {
        subMenu.setRootMenu(this);
        return addItem(subMenu);
    }

    boolean isItem() {
        return itemsCounter == 0;
    }

    boolean haveCard() {
        return cardInfo != null;
    }

    Menu setCard(Card card) {
        this.cardInfo = card;
        return this;
    }

    Card getCard() {
        return this.cardInfo;
    }

    String getName(){ return name; }

    int getId(){ return id;}

    Menu getById(int menuId){
        return items.get(menuId);
    }

    Menu getRootMenu(){
        return rootMenu;
    }

    private void setId(int id){
        this.id = id;
    }

    private void setRootMenu(Menu rootMenu) {
        this.rootMenu = rootMenu;
    }
}
