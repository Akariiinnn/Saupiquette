package mc.akariiinnn.saupiquette;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandCraft implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String str, String[] args)
    {
        if(sender instanceof Player)
        {
            Player p = (Player) sender;
            p.openWorkbench(p.getLocation(), true);
        }
        return false;
    }
}
