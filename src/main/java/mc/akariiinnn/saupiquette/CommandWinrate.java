package mc.akariiinnn.saupiquette;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CommandWinrate implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args)
    {
        if(sender instanceof Player)
        {
            try{
                Player p = (Player) sender;
                String query = "SELECT username, deaths, kills FROM PlayerStats ORDER BY (kills + 1/(deaths+kills + 1)) DESC";
                SQLConnect sql = new SQLConnect();
                Connection conn = sql.getConnection();
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                int i = 0;
                double winrate = 0;
                int kills = 0;
                int deaths = 0;
                p.sendMessage("Classement :");
                while(resultSet.next())
                {
                    i++;
                    kills = resultSet.getInt("kills");
                    deaths = resultSet.getInt("deaths");
                    try{
                        winrate = (kills)/(deaths+kills) * 100;
                    } catch(ArithmeticException e)
                    {
                        winrate = 0;
                    }
                    p.sendMessage("n°" + i + ": " + resultSet.getString("username") + "(" + Double.toString(winrate) + "%)");
                }
                return true;
            } catch(SQLException e)
            {
                System.out.println("Failed to get data from db");
                return false;
            }
        }

        return false;
    }
}
