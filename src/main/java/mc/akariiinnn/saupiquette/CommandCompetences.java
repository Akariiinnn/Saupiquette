package mc.akariiinnn.saupiquette;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandCompetences implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player)
        {
            Player p = (Player) commandSender;
            String competence = Competences.getCompetences(p.getName());
            Bukkit.broadcastMessage(competence);
        }

        return true;
    }
}
