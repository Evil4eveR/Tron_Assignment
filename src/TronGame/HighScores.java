package TronGame;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author cemal
 */
/*
public class HighScores {

    int maxScores;
    PreparedStatement insertStatement;
    PreparedStatement deleteStatement;
    //PreparedStatement deleteallstatement;
    PreparedStatement updateStatement;
    Connection connection;

    public HighScores(int maxScores) throws SQLException {
        this.maxScores = maxScores;
        String dbURL = "jdbc:derby://localhost:1527/highscores;";
        connection = DriverManager.getConnection(dbURL);
        String insertQuery = "INSERT INTO HIGHSCORES ( NAME, SCORE) VALUES (?, ?)";
        insertStatement = connection.prepareStatement(insertQuery);
        String deleteQuery = "DELETE FROM HIGHSCORES WHERE SCORE=?";
        deleteStatement = connection.prepareStatement(deleteQuery);
        String updatequery = "UPDATE HIGHSCORES SET SCORE=(?) WHERE NAME=(?)";
        updateStatement = connection.prepareStatement(updatequery);
        //deleteallstatement = connection.prepareStatement("DELETE FROM HIGHSCORES WHERE SCORE>0");
        //deleteallstatement.executeUpdate();

    }

    public ArrayList<HighScore> getHighScores() throws SQLException {
        String query = "SELECT * FROM HIGHSCORES";
        ArrayList<HighScore> highScores = new ArrayList<>();
        Statement stmt = connection.createStatement();
        ResultSet results = stmt.executeQuery(query);
        while (results.next()) {
            String name = results.getString("NAME");
            int score = results.getInt("SCORE");
            highScores.add(new HighScore(name, score));
        }
        sortHighScores(highScores);
        return highScores;
    }



    public void increaseScore(String check_name) throws SQLException {
        String query = "SELECT * FROM HIGHSCORES";

        Statement stmt = connection.createStatement();
        ResultSet results = stmt.executeQuery(query);
        while (results.next()) {
            String name = results.getString("NAME");
            int score = results.getInt("SCORE");
            if(check_name.equals(name)){
                updateScores(name,score);
            }
        }
    }

    public void putHighScore(String name, int score) throws SQLException {
        ArrayList<HighScore> highScores = getHighScores();
        if (highScores.size() < maxScores) {
            insertScore(name, score);
        } else {
            int leastScore = highScores.get(highScores.size() - 1).getScore();
            if (leastScore < score) {
                deleteScores(leastScore);
                insertScore(name, score);
            }
        }
    }

    /**
     * Sort the high scores in descending order.
     * @param highScores
     */
  /*  private void sortHighScores(ArrayList<HighScore> highScores) {
        Collections.sort(highScores, new Comparator<HighScore>() {
            @Override
            public int compare(HighScore t, HighScore t1) {
                return t1.getScore() - t.getScore();
            }
        });
    }

    private void insertScore(String name, int score) throws SQLException {
        insertStatement.setString(1, name);
        insertStatement.setInt(2, score);
        insertStatement.executeUpdate();
    }
*/
    /**
     * Deletes all the highscores with score.
     *
     * @param score
     */
/*    private void deleteScores(int score) throws SQLException {
        deleteStatement.setInt(1, score);
        deleteStatement.executeUpdate();
    }

    private void updateScores(String name,int score) throws SQLException {
        updateStatement.setInt(1, score+1);
        updateStatement.setString(2, name);
        updateStatement.executeUpdate();
    }
}
*/