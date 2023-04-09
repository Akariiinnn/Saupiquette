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
            String str2 = String.join("", args);
            if (str2.isEmpty()) {
                try {
                    SQLConnect sqlConnect = new SQLConnect();
                    String sql = "SELECT money FROM PlayerStats WHERE username = \"" + p.getName() + "\"";
                    Connection connection = sqlConnect.getConnection();
                    Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery(sql);
                    while (rs.next()) {
                        p.sendMessage("Balance : " + rs.getInt("money"));
                    }
                    return true;
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Unable to get player money");
                    return false;
                }
            } else try {
                if (args[0].equals("pay")) {
                    System.out.println("rabiot");
                    SQLConnect sqlConnect = new SQLConnect();
                    String sql = "UPDATE PlayerStats SET money = money + " + args[2] + " WHERE username = \"" + args[1] + "\"";
                    String sql2 = "UPDATE PlayerStats SET money = money - " + args[2] + " WHERE username = \"" + p.getName() + "\"";
                    Connection connection = sqlConnect.getConnection();
                    Statement statement = connection.createStatement();
                    statement.execute(sql);
                    statement.execute(sql2);
                    return true;
                    }
                    } catch (SQLException e) {
                        System.out.println("Unable to update player money");
                        return false;
                    } catch(ArrayIndexOutOfBoundsException e) {
                        p.sendMessage("Not enough parameters");
                        return false;
                    }
                }
            return false;
        }
    }


