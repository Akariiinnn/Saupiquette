package akariiinnn.minecraft;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PlayerStats {

    public static SQLConnect sql = new SQLConnect();

    public static void createStats(Player player)
    {
        try {
            Connection connection = sql.getConnection();
            Statement statement = connection.createStatement();
            String sql = "INSERT IGNORE INTO PlayerStats VALUES (\"" + player.getName() + "\", null, null, null, 0, 0, 0);";
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateDeaths(Player player) {
        try {
            Connection connection = sql.getConnection();
            Statement statement = connection.createStatement();
            String sql = "UPDATE PlayerStats SET deaths = deaths + 1 WHERE username = \"" + player.getName() + "\";";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateKills(Player killer) {
        try {
            Connection connection = sql.getConnection();
            Statement statement = connection.createStatement();
            String sql = "";
            sql = "UPDATE PlayerStats SET deaths = deaths + 1 WHERE username = \"" + killer.getName() + "\";";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
