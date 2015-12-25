import util.SmartConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jakub on 12/25/15.
 */
public class InfoRegexer {
    // Player say regexes: e.g. "<player>"
    public static List<String> sayRegexes = new ArrayList<String>();
    // All death messages
    public static List<String> deathRegexes = new ArrayList<String>();

    static {
        sayRegexes.add("<>");

        deathRegexes.add("was shot by arrow");
        deathRegexes.add("was shot by");
        deathRegexes.add("was pricked to death");
        deathRegexes.add("walked into a cactus while trying to escape");
        deathRegexes.add("was stabbed to death");
        deathRegexes.add("drowned");
        deathRegexes.add("drowned whilst trying to escape");
        deathRegexes.add("experienced kinetic energy");
        deathRegexes.add("blew up");
        deathRegexes.add("was blown up by");
        deathRegexes.add("hit the ground too hard");
        deathRegexes.add("fell from a high place");
        deathRegexes.add("fell off a ladder");
        deathRegexes.add("fell off some vines");
        deathRegexes.add("fell out of the water");
        deathRegexes.add("fell into a patch of fire");
        deathRegexes.add("fell into a patch of cacti");
        deathRegexes.add("was doomed to fall by");
        deathRegexes.add("was shot off some vines by");
        deathRegexes.add("was blown from a high place by");
        deathRegexes.add("was squashed by a falling anvil");
        deathRegexes.add("was squashed by a falling block");
        deathRegexes.add("went up in flames");
        deathRegexes.add("burned to death");
        deathRegexes.add("was burnt to a crisp whilst fighting");
        deathRegexes.add("walked into a fire whilst fighting");
        deathRegexes.add("tried to swim in lava");
        deathRegexes.add("tried to swim in lava while trying to escape");
        deathRegexes.add("was struck by lightning");
        deathRegexes.add("was slain by");
        deathRegexes.add("got finished off by");
        deathRegexes.add("got finished off by");
        deathRegexes.add("was fireballed by");
        deathRegexes.add("was killed by magic");
        deathRegexes.add("was killed by");
        deathRegexes.add("starved to death");
        deathRegexes.add("suffocated in a wall");
        deathRegexes.add("was killed while trying to hurt");
        deathRegexes.add("fell out of the world");
        deathRegexes.add("fell from a high place and fell out of the world");
        deathRegexes.add("withered away");
        deathRegexes.add("was pummeled by");
    }

    public static boolean isDeath(String line){
        for(int i = 0;i < InfoRegexer.deathRegexes.size(); i++){
            if(line.contains(InfoRegexer.deathRegexes.get(i)))
                return true;
        }

        return false;
    }

    public static boolean isSay(String line){
        Pattern pattern = Pattern.compile("(.*)(<{1}.+>{1})(.*)", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(line);

        boolean matchFound = matcher.matches();

        return matchFound;
    }
}
