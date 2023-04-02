package akariiinnn.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class CommandRoll implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player)
        {
            Player player = (Player) commandSender;
            Random rand = new Random();
            int number = 100;
            String str = String.join("", strings);
            if (!str.isEmpty())
            {
                number = Integer.parseInt(str);
            }
            Bukkit.broadcastMessage(player.getName() + " à fait un roll sur " + Integer.toString(number) + ": " + Integer.toString(rand.nextInt(number) + 1));
        }

        return true;
    }
}
