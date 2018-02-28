package Model;

import Database.Word;
import java.util.LinkedList;
import java.util.Random;

public class TalkToHuman {

    private static String positiveReaction() {
        LinkedList<String> list = new LinkedList<>();
        list.add("Fantastic!");
        list.add("Brilliant!");
        list.add("Good!");
        list.add("GJ!");
        list.add("Legendary!");
        list.add("Godlike!");
        list.add("Nice!");
        list.add("Yeah!!!");
        list.add("Impressive!");
        list.add("Unbelievable!");
        list.add(":D");
        return list.get(new Random().nextInt(list.size()));
     }

    private static String negativeReaction() {
        LinkedList<String> list = new LinkedList<>();
        list.add("Sbagliato..."); //italian
        list.add("Incorrecto..."); //spanish
        list.add("Wrong..."); //english
        list.add("Fel..."); //swedish
        list.add("Malĝusta..."); //esperanto
        list.add("Schlecht..."); //german
        list.add("Faux..."); //french
        list.add("Źle.."); //polish
        list.add("Malum..."); //latin
        list.add("Errado..."); //portuguese
        list.add("Si sawa..."); //swahilli
        list.add("Rossz..."); //hungarian
        list.add("Salah..."); //sudanese
        list.add("погрешно..."); //serbian
        list.add("неправильно..."); //russian
        list.add("خطأ..."); //arabic
        list.add("Nepareizi..."); //latvian
        list.add("არასწორია..."); //georgian
        list.add("սխալ է..."); //armenian
        list.add("Verkeerde..."); //afrikaans
        list.add("špatně..."); //czech
        return list.get(new Random().nextInt(list.size()));
    }

    public static void fatalError() {
        System.out.println("Program has crashed, contact Rafal or Jedrzej.");
        System.out.println("Don't try to fix it yourself!!");
    }

    public static Boolean askQuestion(String language, Integer side, Word word){
        // 0, na polskiej stonie i pytanie o obcy
        // 1, na obcej stronie i pytanie o polski
        String right;

        if(side == 0) {
            System.out.println("What is < " + word.getPolish() + " > in " + language + "?");
            right = word.getForeign();
        } else if (side == 1) {
            System.out.println("What is < " + word.getForeign() + " > in polish?");
            right = word.getPolish();
        } else {
            fatalError();
            return false;
        }
        String answer = GetFromHuman.getString();
        if(answer.equals(right)) {
            System.out.println(positiveReaction());
            return true;
        } else {
            System.out.println("What do you recon? Are you right?");
            System.out.println("1 = YES, 0 = NO");
            Boolean if_right = GetFromHuman.getBoolean();
            if(if_right) {
                System.out.println(positiveReaction());
                return true;
            } else {
                System.out.println(negativeReaction());
                return false;
            }
        }
    }

    public static Boolean askIfWord(Word word) {
        System.out.println("Do you want to add:");
        word.display();
        System.out.println("?");
        return GetFromHuman.getBoolean();
    }

}
