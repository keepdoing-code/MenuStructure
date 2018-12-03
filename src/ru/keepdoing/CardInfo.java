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
}
