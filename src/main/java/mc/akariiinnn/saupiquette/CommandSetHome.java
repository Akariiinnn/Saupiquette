package mc.akariiinnn.saupiquette;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CommandSetHome implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        try {
            if(commandSender instanceof Player) {
                Player player = (Player) commandSender;
                World.Environment penv = player.getWorld().getEnvironment();
                if(penv != World.Environment.NORMAL)
                {
                    player.sendMessage("You can only set home in the overworld");
                    return false;
                }else {
                    SQLConnect sql = new SQLConnect();
                    Connection connection = sql.getConnection();
                    Statement statement = connection.createStatement();
                    String query = "UPDATE PlayerStats SET home_x = " + player.getLocation().getX() + ", home_y = " + player.getLocation().getY() + ", home_z = " + player.getLocation().getZ() + "WHERE username = \"" + player.getName() + "\"";
                    statement.execute(query);
                    statement.close();
                    connection.close();
                    player.sendMessage("Home set at coordinates : \n -X:" + player.getLocation().getX() + "\n -Y:" + player.getLocation().getY() + "\n -Z:" + player.getLocation().getZ());
                    return true;
                }
            }
            return false;
        } catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
}

