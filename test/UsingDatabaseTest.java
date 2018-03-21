import Database.SetOfDatabaseFunction;
import Model.UserInterface;

public class UsingDatabaseTest {
    public static void main(String[] args) {
        SetOfDatabaseFunction setOfDatabaseFunction = new SetOfDatabaseFunction();
        String userName = "JJ";
        setOfDatabaseFunction.createTableForNewUser(userName);

        setOfDatabaseFunction.createTableForNewUser("Admin");

        setOfDatabaseFunction.addWord(userName, "eng", "inconspicuous", "niepozorny", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "an extent", "rozmiar", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "a bloke", "facet BE", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "an intrusion", "wtrącenie się", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "to waft", "rozchodzić się (o zapachu)", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "to reap", "zbierać (owoce pracy)", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "to vest one’s hopes in", "pokładać nadzieję w kimś", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "rad", "wspaniały", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "a concoction", "mieszanina", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "a dismay", "konsternacja", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "disconcerting", "niepokojący", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "emblazoned", "ozdobiony", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "a thicket", "zarośla", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "to proffer", "składać (kondolencje)", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "overwhelmed", "przytłoczony", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "a leer", "spojrzenie (z ukosa)", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "ungainly", "niezdarny", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "withered", "zwiędły", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "faint", "słaby; nikły", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "to hit it off with", "dobrze się rozumieć z", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "rife", "rozpowszechniony", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "a blunder", "gafa", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "finely", "drobno", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "in the wake of sth", "w ślad za czymś", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "forthright", "prostolinijny", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "malicious", "złośliwy", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "to resolve", "postanowić", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "a sprawl", "skupisko (zabudowań)", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "to deride", "kpić; drwić", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "a trove", "znalezisko", 1);
        setOfDatabaseFunction.addWord(userName, "eng", "feeble", "marny; słaby", 2);
        setOfDatabaseFunction.addWord(userName, "eng", "venerable", "szacowny", 2);
        setOfDatabaseFunction.addWord(userName, "eng", "a hunch", "garb", 2);
        setOfDatabaseFunction.addWord(userName, "eng", "a fray", "walka", 2);
        setOfDatabaseFunction.addWord(userName, "eng", "niestosowny", "inept", 2);
        setOfDatabaseFunction.addWord(userName, "eng", "impudent", "zuchwały", 2);
        setOfDatabaseFunction.addWord(userName, "eng", "to thwart", "udaremnić", 2);
        setOfDatabaseFunction.addWord(userName, "eng", "inimical", "nieprzyjazny", 2);
        setOfDatabaseFunction.addWord(userName, "eng", "a satelity", "przesyt", 2);
        setOfDatabaseFunction.addWord(userName, "eng", "to dredge", "pogłębiać rzekę", 2);
        setOfDatabaseFunction.addWord(userName, "eng", "errant", "wiarołomny", 2);
        setOfDatabaseFunction.addWord(userName, "eng", "an attire", "ubiór", 3);
        setOfDatabaseFunction.addWord(userName, "eng", "to gnaw", "nękać; dręczyć", 3);
        setOfDatabaseFunction.addWord(userName, "eng", "a faucet", "kran; kurek", 3);
        setOfDatabaseFunction.addWord(userName, "eng", "to quiver", "trząść się", 3);
        setOfDatabaseFunction.addWord(userName, "eng", "to blemish", "zniekształcać", 3);
        setOfDatabaseFunction.addWord(userName, "eng", "thorny", "drażliwy", 4);
        setOfDatabaseFunction.addWord(userName, "eng", "demure", "wstydliwy", 4);
        setOfDatabaseFunction.addWord(userName, "eng", "a pitfall", "pułapka", 4);
        setOfDatabaseFunction.addWord(userName, "eng", "a vagabond", "przybłęda", 4);
        setOfDatabaseFunction.addWord(userName, "eng", "imminent", "nieuchronny", 4);
        setOfDatabaseFunction.addWord(userName, "eng", "a cord", "sznurek", 5);
        setOfDatabaseFunction.addWord(userName, "eng", "a plume", "smuga dymu; pióropusz", 5);
        setOfDatabaseFunction.addWord(userName, "eng", "a decay", "rozpad; rozkład", 5);
        setOfDatabaseFunction.addWord(userName, "eng", "spark sth off", "wywołać coś", 5);
        setOfDatabaseFunction.addWord(userName, "eng", "a decency", "przyzwoitość", 5);
        setOfDatabaseFunction.addWord(userName, "eng", "to brag", "przechwalać się", 6);
        setOfDatabaseFunction.addWord(userName, "eng", "to dissolve", "rozpuszczać się", 6);
        setOfDatabaseFunction.addWord(userName, "eng", "a hatred", "nienawiść", 6);
        setOfDatabaseFunction.addWord(userName, "eng", "innate", "wrodzony", 7);
        setOfDatabaseFunction.addWord(userName, "eng", "arcane", "tajemniczy", 7);
        setOfDatabaseFunction.addWord(userName, "eng", "to dally with", "flirtować", 7);
        setOfDatabaseFunction.addWord(userName, "eng", "a moor", "wrzosowisko", 7);
        setOfDatabaseFunction.addWord(userName, "eng", "a pier", "molo; filar", 7);
        setOfDatabaseFunction.addWord(userName, "eng", "to hoist", "dźwigać", 7);
        setOfDatabaseFunction.addWord(userName, "eng", "genuine", "autentyczny", 8);
        setOfDatabaseFunction.addWord(userName, "eng", "a grub", "żarcie", 8);
        setOfDatabaseFunction.addWord(userName, "eng", "to cope", "radzić sobie", 8);
        setOfDatabaseFunction.addWord(userName, "eng", "to act up", "źle się zachowywać", 9);
        setOfDatabaseFunction.addWord(userName, "eng", "conceivably", "możliwie", 9);
        setOfDatabaseFunction.addWord(userName, "eng", "a leverage", "wpływ", 9);
        setOfDatabaseFunction.addWord(userName, "eng", "short-lived", "przelotny", 9);
        setOfDatabaseFunction.addWord(userName, "eng", "to wind down", "odprężyć się", 9);
        setOfDatabaseFunction.addWord(userName, "eng", "a snitch", "donosiciel", 9);
        setOfDatabaseFunction.addWord(userName, "eng", "a meerkat", "surykatka", 10);
        setOfDatabaseFunction.addWord(userName, "eng", "to overindulge", "nadmiernie sobie dogadzać", 10);
        setOfDatabaseFunction.addWord(userName, "eng", "a plethora", "nadmiar", 10);
        setOfDatabaseFunction.addWord(userName, "eng", "yonder", "tam; po tamtej stronie", 10);
        setOfDatabaseFunction.addWord(userName, "eng", "a quill", "lotka; piórko; kolec", 11);
        setOfDatabaseFunction.addWord(userName, "eng", "a leap", "skok", 11);
        setOfDatabaseFunction.addWord(userName, "eng", "dazzling", "oszałamiający", 11);
        setOfDatabaseFunction.addWord(userName, "eng", "an umbrage", "obraza", 11);
        setOfDatabaseFunction.addWord(userName, "eng", "morus", "ponury; przybity", 11);
        setOfDatabaseFunction.addWord(userName, "eng", "obtuse", "tępy", 12);
        setOfDatabaseFunction.addWord(userName, "eng", "to loosen up", "rozluźniać się", 12);
        setOfDatabaseFunction.addWord(userName, "eng", "a cottage", "domek wiejski", 12);
        setOfDatabaseFunction.addWord(userName, "eng", "a vibe", "pozytywna aura", 12);
        setOfDatabaseFunction.addWord(userName, "eng", "salient", "najistotniejszy", 12);
        setOfDatabaseFunction.addWord(userName, "eng", "to bustle", "tętnić życiem", 0);
        setOfDatabaseFunction.addWord(userName, "eng", "groovy", "bombowy", 0);
        setOfDatabaseFunction.addWord(userName, "eng", "to come into play", "wchodzić w rachubę", 0);
        setOfDatabaseFunction.addWord(userName, "eng", "to pinch", "uwierać", 0);
        setOfDatabaseFunction.addWord(userName, "eng", "to abet", "podżegać (do zrobienia czegoś nielegalnego)", 13);
        setOfDatabaseFunction.addWord(userName, "eng", "a nutrition", "odżywianie", 13);
        setOfDatabaseFunction.addWord(userName, "eng", "a fuse", "lont; zapalnik; bezpiecznik", 13);
        setOfDatabaseFunction.addWord(userName, "eng", "an accolade", "dowód uznania", 13);
        setOfDatabaseFunction.addWord(userName, "eng", "fiercely", "dziko; gwałtownie", 13);
        setOfDatabaseFunction.addWord(userName, "eng", "a shingle", "gont (z dachu)", 13);
        setOfDatabaseFunction.addWord(userName, "eng", "a clemency", "łaska", 13);
        setOfDatabaseFunction.addWord(userName, "eng", "to indenture", "związać umową", 13);
        setOfDatabaseFunction.addWord(userName, "eng", "a tussle", "szamotanina", 13);
        setOfDatabaseFunction.addWord(userName, "eng", "vernal", "wiosenny", 13);
        setOfDatabaseFunction.addWord(userName, "eng", "to loathe", "czuć wstręt", 13);
        setOfDatabaseFunction.addWord(userName, "eng", "meagre", "chudy; ubogi; niewielki", 13);
        setOfDatabaseFunction.addWord(userName, "eng", "a dew", "rosa", 13);
        setOfDatabaseFunction.addWord(userName, "eng", "to cram", "wciskać się (gdzieś)", 13);
        setOfDatabaseFunction.addWord(userName, "eng", "to bestow", "obdarować", 13);
        setOfDatabaseFunction.addWord(userName, "eng", "to mingle", "wmieszać się w tłum", 13);
        setOfDatabaseFunction.addWord(userName, "eng", "a billow", "kłąb (dymu)", 13);
        setOfDatabaseFunction.addWord(userName, "eng", "to skimp", "skąpić", 13);

        UserInterface userInterface = new UserInterface(userName);
        while(userInterface.use());


        setOfDatabaseFunction.deleteTableAndUser(userName);
        setOfDatabaseFunction.deleteTableAndUser("Admin");
    }
}
