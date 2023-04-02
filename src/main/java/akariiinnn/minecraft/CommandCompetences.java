package akariiinnn.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandCompetences implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        String[][] competences = new String[][]{
                {"Akariiinnn", "- HAUTE TENSION : Tous les bonus de Quentin deviennent un malus pour l'adversaire.\n" +
                        "- RAILGUN : Si son roll est supérieur au précédent, il gagne un bonus de +6. Chaque utilisation fait baisser ce bonus de 2 (définitif). Si il est inférieur, le Railgun se charge, et sa prochaine utilisation gagnera +2 (définitif) qui se cumule si les rolls suivants sont inférieurs. Si la puissance du railgun excède 6, alors l'énergie accumulée disparaitra a son utilisation et sa puissance retombera a 6.\n" +
                        "- ORAGE : Fait un roll sur 100 avant le combat. Si Quentin fait 100,  Quentin cible l'orage sur l'ennemi et l'abat instantanément mettant fin au combat."},
                {"Mireaculous_", "- Mauvais perdant : Si l'ennemi fait une réussite critique, Miguel gagne un point.\n" +
                        "- Minutieux : Immunisé contre les échecs critiques\n" +
                        "- Traître : (compétence d'arme) Si Miguel à le même nombre de point de manche que l'adversaire, l'adversaire prend -10."},
                {"TheBenhra", "- Si le score final de Benhra est inférieur au roll de l'adversaire divisé par 2, Benhra refait un roll sur 50 dont le score de ce roll s'ajoutera au score de Benhra.\n" +
                        "- Si Benhra joue en dernière position, sa première compétence s'active sur le score final de l'adversaire."},
        };
        int i = 0;
        if(strings[0].isEmpty())
        {
            commandSender.sendMessage("Aucune compétences pour ce perso !");
        }else {
            for( String[] innerArray: competences)
            {
                if(strings[0].equals(competences[i][0]))
                {
                    System.out.println(competences[i][0]);
                    for( String data: innerArray) {
                        Bukkit.broadcastMessage(data);
                    }
                }
                i++;
            }
        }

        return true;
    }
}
