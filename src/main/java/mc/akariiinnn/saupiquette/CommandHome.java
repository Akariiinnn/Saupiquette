package mc.akariiinnn.saupiquette;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CommandHome implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        try {
            if(commandSender instanceof Player) {
                Player player = (Player) commandSender;
                World.Environment penv = player.getWorld().getEnvironment();
                if(penv != World.Environment.NORMAL)
                {
                    player.sendMessage("You can only teleport home in the overworld");
                    return false;
                }else {
                    int x = 0;
                    int y = 0;
                    int z = 0;
                    SQLConnect sql = new SQLConnect();
                    Connection connection = sql.getConnection();
                    Statement statement = connection.createStatement();
                    String query = "SELECT home_x, home_y, home_z FROM PlayerStats WHERE username = \"" + player.getName() + "\"";
                    ResultSet rs = statement.executeQuery(query);
                    while(rs.next())
                    {
                        x = rs.getInt("home_x");
                        y = rs.getInt("home_y");
                        z = rs.getInt("home_z");
                    }
                    System.out.println(Integer.toString(x) + Integer.toString(y) + Integer.toString(z));
                    player.teleport(new Location(player.getWorld(), (double) x, y, z));
                    statement.close();
                    connection.close();
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

