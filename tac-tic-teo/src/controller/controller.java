/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DBConnerction.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tac.tic.teo.player;

/**
 *
 * @author HP
 */
public class controller {
    
    public static void addNameDataBase(String name) throws ClassNotFoundException, SQLException{
    
        String quary = "insert into player values('"+name+"')";
        Connection connection = DBConnection.getDBConnection().getConnection();

        Statement stm = connection.createStatement();
        int result = stm.executeUpdate(quary);
       if(result ==1)
        System.out.println("bd okkkey");
        
        
    }
    public static List<String> getAllPlayers() throws ClassNotFoundException, SQLException{
        List <String> playerList = new ArrayList<>();
        String quary = "select * from player";
        Connection connection = DBConnection.getDBConnection().getConnection();

        Statement stm = connection.createStatement();
        
        ResultSet resultSet = stm.executeQuery(quary);
        
        while(resultSet.next()){
        
            String name = resultSet.getString("name");
            playerList.add(name);
            
        }
        return playerList;
    }
    
    public static int getScore(String name) throws ClassNotFoundException, SQLException{
    
        int score = 0;
        String quary = "select score from highscore where name = '"+name+"' ";
        Connection connection = DBConnection.getDBConnection().getConnection();

        Statement stm = connection.createStatement();
        
        ResultSet resultSet = stm.executeQuery(quary);
        
        if(resultSet.next()){
            score = Integer.parseInt(resultSet.getString("score"));
            System.out.println(score);
        }
        return score;
    }
    
    public  static  void updateScore(String name, int score) throws ClassNotFoundException, SQLException{
    
        String quary = "update highscore set score = '"+score+"' where name = '"+name+"'";
        Connection connection = DBConnection.getDBConnection().getConnection();

        Statement stm = connection.createStatement();
        int executeUpdate = stm.executeUpdate(quary);
        
        if(executeUpdate == 1)
            System.out.println("high score okey");      
        
    }
    public static void setScoreFirstTime(String name) throws ClassNotFoundException, SQLException{
    
        String quary = "insert into highscore values('"+name+"','"+0+"')";
        Connection connection = DBConnection.getDBConnection().getConnection();

        Statement stm = connection.createStatement();
        int executeUpdate = stm.executeUpdate(quary);
        
        if(executeUpdate == 1)
            System.out.println("high score okey");     
        
        
    }
    
    public static List<player> getHighScore() throws ClassNotFoundException, SQLException{
        int score = 0;
        String name = null;
        List<player> scoreList = new ArrayList<>();
       // System.out.println("before query");
        String quary = "select * from highscore order by score desc";
        
        Connection connection = DBConnection.getDBConnection().getConnection();

        Statement stm = connection.createStatement();
        
        ResultSet resultSet = stm.executeQuery(quary);
       // System.out.println("after query");
        
        while(resultSet.next()){
            name = resultSet.getString("name");
            score = Integer.parseInt(resultSet.getString("score"));
            //System.out.println(score);
           
            player p1 = new player(name, score);
            scoreList.add(p1);
            
        }
//        for (int i = 0; i < scoreList.size(); i++) {
//            System.out.println(scoreList.get(i).getName()+"  "+scoreList.get(i).getScore());
//        }
        
    
        return scoreList;
    }
    
    
}
