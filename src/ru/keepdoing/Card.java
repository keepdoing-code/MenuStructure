package ru.keepdoing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by yuri on 03.12.18.
 */
public class Card implements Iterable<String>{

    private Map<Field, String> card = new HashMap<>(4);

    Card(){}

    Card add(Field field, String param){
        card.put(field, param);
        return this;
    }

    String get(Field field){
        return card.get(field);
    }

    @Override
    public Iterator<String> iterator() {
        return card.values().iterator();
    }

    public enum Field {
        name, desc, phone, link
    }

//    public static void main(String[] args) {
//        Card card = new Card().
//                add(Field.name, "Yuri").
//                add(Field.desc, "Coder").
//                add(Field.phone, "+7(911)500-00-00").
//                add(Field.link, "vk.com/yuri");
//
//        for (String s: card){
//            System.out.println(s);
//        }
//
//        System.out.println("\n" + card.get(Field.name));
//
//    }
}
