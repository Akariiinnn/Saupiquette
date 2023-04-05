package mc.akariiinnn.saupiquette;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CommandMoney implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String str, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args == null) {
                try {
                    SQLConnect sqlConnect = new SQLConnect();
                    String sql = "SELECT money WHERE username = \"" + p.getName() + "\"";
                    Connection connection = sqlConnect.getConnection();
                    Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery(sql);
                    while (rs.next()) {
                        p.sendMessage("Balance : " + rs.getInt("money"));
                    }
                    return true;
                } catch (SQLException e) {
                    System.out.println("Unable to get player money");
                    return false;
                }
            }
            return false;
        }else if(args[0].equals("pay"))
        {
            try{
                SQLConnect sqlConnect = new SQLConnect();
                String sql = "UPDATE PlayerStats SET money = \"" + args[2] + "\" WHERE username = \"" + args[1] + "\"";
                Connection connection = sqlConnect.getConnection();
                Statement statement = connection.createStatement();
            } catch(SQLException e)
            {
                System.out.println("Unable to update player money");
            }
        }
        return false;
    }
}

