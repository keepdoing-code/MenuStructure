package ru.keepdoing;

/**
 * Created by yuri on 02.12.18.
 */
public class CardInfo {
    String name;
    String desc;
    String phone;
    String link;

    CardInfo(){}

    CardInfo addName(String name){
        this.name = name;
        return this;
    }

    CardInfo addDesc(String desc){
        this.desc = desc;
        return this;
    }

    CardInfo addPhone(String phone){
        this.phone = phone;
        return this;
    }

    CardInfo addLink(String link){
        this.link = link;
        return this;
    }

    CardInfo get(){
        return this;
    }

    public static void main(String[] args) {
        CardInfo cardInfo = new CardInfo().addName("Yuri").addDesc("Programmer").addPhone("+7(911)571-62-56").addLink("vk.com/stritron");
        printCardInfo(cardInfo, "");
    }

    static void printCardInfo(CardInfo card, String tab){
        System.out.println(tab + card.name);
        System.out.println(tab + card.desc);
        System.out.println(tab + card.phone);
        System.out.println(tab + card.link);
    }
}
