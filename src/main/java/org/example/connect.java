package org.example;

import java.sql.*;
import java.util.ArrayList;

public class connect {

    static final String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=BikeStores;user=BloodDonationProject;password=123123;encrypt=false";
    public Object []  logicColum(String query){
        try(Connection conn = DriverManager.getConnection(connectionUrl);
            Statement stmt = conn.createStatement();){
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData metaData = rs.getMetaData();

            int numOfColum = metaData.getColumnCount();
            Object [] arr  = new Object[numOfColum];

            for (int i =1; i<=numOfColum;i++){
                arr[i-1]=(String) metaData.getColumnName(i);
            }

            return arr;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Object[][] logicData(String query){
        try(Connection conn = DriverManager.getConnection(connectionUrl);
            Statement stmt = conn.createStatement();){
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData metaData = rs.getMetaData();

            int numOfColum = metaData.getColumnCount();
            int count = 0;
            Object [][] data = new Object[10000][1000];
            while (rs.next()){
                for (int i = 1; i<=numOfColum;i++){
                    data[count][i-1]= rs.getObject(i);
                }
                count++;
            }
            return data;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void connectTry(String typeVal){
        try(Connection conn = DriverManager.getConnection(connectionUrl)){
            PreparedStatement stmt = conn.prepareStatement("select * from titles where price like  ?");
            stmt.setString(1, "'7%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                System.out.println(rs.toString());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        connect c = new connect();
//        c.logicColum("select * from authors");
        c.connectTry("7");
    }
}

