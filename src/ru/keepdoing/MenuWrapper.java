package ru.keepdoing;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by yuri on 05.12.18.
 */
public class MenuWrapper {
    private static final String ASK_STRING = ">";
    private static final String UNKNOWN_COMMAND = "Unknown command\n";
    private static final String WRONG_ITEM = "Wrong item\n";
    private static final String GO_BACK = "b: go back";
    private static final String OTHER_CMDS = "q: exit app";
    private final long chatId;
    private Menu pointer;

    public MenuWrapper(final Menu startMenu, final long chatId){
        this.pointer = startMenu;
        this.chatId = chatId;
    }

    public long getChatId(){
        return chatId;
    }

    public String dialog(final String inString){
        return process(pointer, inString);
    }

    static String process(Menu menuPointer, final String inString) {

        if (isNumber(inString)) {                       //menu item select
            StringBuilder sb = new StringBuilder();
            int num = Integer.parseInt(inString);
            Menu m = menuPointer.getById(num);

            if (m == null) return WRONG_ITEM;

            if (m.isItem()) {
                sb.append(printCard(m.getCard(), "\t"))
                        .append(printMenu(menuPointer));
                return sb.toString();
            } else {
                menuPointer = m;
                return printMenu(m);
            }
        } else {
            switch (inString) {                         //command select
                case "q":
                    System.exit(0);
                case "b":
                    if (menuPointer.haveRoot()) {
                        menuPointer = menuPointer.getRootMenu();
                    }
                    return printMenu(menuPointer);
                default:
                    return UNKNOWN_COMMAND;
            }
        }
    }

    static String printMenu(Menu menu) {
        StringBuilder sb = new StringBuilder();
        sb.append(menu.getName()).append('\n');

        for (Menu m : menu) {
            sb.append(String.format("%d: %s\n", m.getId(), m.getName()));
        }
        if (menu.haveRoot()) {
            sb.append(GO_BACK).append('\n');
        }
        sb.append(OTHER_CMDS).append('\n').append(ASK_STRING);
        return sb.toString();
    }

    static String printCard(Card card, String tab) {
        StringBuilder sb = new StringBuilder();
        for (String s : card) {
            sb.append(tab).append(s).append('\n');
        }
        return sb.toString();
    }

    static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException | InputMismatchException e) {
            return false;
        }
    }

    static String printAllMenu(Menu menu, String tab) {
        StringBuilder sb = new StringBuilder();

        for (Menu m : menu) {
            sb.append(tab).append(m.getId()).append(":\t").append(m.getName()).append('\n');
            if (m.haveCard()) {
                sb.append(printCard(m.getCard(),tab + '\t'));
            }
            if (!m.isItem()) {
                sb.append(printAllMenu(m, tab + '\t'));
            }
        }
        return sb.toString();
    }
}
