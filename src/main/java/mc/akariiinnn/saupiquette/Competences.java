package mc.akariiinnn.saupiquette;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Competences {

    public static String getCompetences(String playerName)
    {
        try{
            SQLConnect sql = new SQLConnect();
            Connection connection = sql.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT username, competence FROM PlayerStats WHERE username = \"" + playerName + "\"";
            ResultSet rs = statement.executeQuery(query);
            rs.next();

            return rs.getString("competence");
        } catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Unable to get player competences");
            return "Erreur";
        }
    }
}
