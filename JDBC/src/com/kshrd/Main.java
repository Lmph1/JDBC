package com.kshrd;


import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws SQLException {

        Connection con =null;
        try {
            con = DriverManager
//                    .getConnection("jdbc:postgresql://localhost:5432/postgres","leho", "123");
                    .getConnection("jdbc:postgresql://localhost:5432/postgres?user=leho&password=123");

//            Properties properties = new Properties();
//            properties.setProperty("username", "leho");
//            properties.setProperty("password", "123");
//            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", properties);

//             Select all from table student
//            String selectSt = "select * from student where id=1";
//            Statement statement = con.createStatement();

//            boolean isSuccess = statement.execute(selectSt);
//            System.out.println("IsSucces: " + isSuccess);
//            ResultSet resultSet = statement.executeQuery(selectSt);
//            while(resultSet.next()) {
//                System.out.print(resultSet.getInt(1));
//                System.out.print(resultSet.getString(2));
//                System.out.print(resultSet.getInt(3));
//                System.out.print(resultSet.getDouble(4));
//            }

            //Insert into table student (Static)
//            String insertSt = "insert into student values(9, 'Dara', 24, 90)";
//            Statement st = con.createStatement();
//            int rowEffected = st.executeUpdate(insertSt);
//            System.out.println("Row Effected: " + rowEffected);

            //Insert into table student (Dynamic)
//            String insertDst = "insert into student values(?,?,?,?)";
//            PreparedStatement st = con.prepareStatement(insertDst);
//            st.setInt(1, 15);
//            st.setString(2, "Sophy");
//            st.setInt(3, 22);
//            st.setDouble(4, 85);
//
//            int a=10;
//            a=20;
//            st.execute();
//            st.setInt(1, 16);
//            st.setString(2, "Vanrith");
//            st.setInt(3, 22);
//            st.setDouble(4, 85);
//             st.executeUpdate();
//            System.out.println("Row Effected: ");







            con.setAutoCommit(false);

            String insertSt = "insert into student values(20, 'Srey Neat', 24, 90)";
            Statement st1 = con.createStatement();
            int rowEffected = st1.executeUpdate(insertSt);
            System.out.println("Row Effected: " + rowEffected);


            String insertDst = "insert into student values(?,?,?,?)";
            PreparedStatement st = con.prepareStatement(insertDst);
            st.setInt(1, 21);
            st.setString(2, "Teklim");
            st.setInt(3, 22);
            st.setDouble(4, 85);
            st.executeUpdate();
            con.commit();



        }catch(Exception e){
            con.rollback();
            e.printStackTrace();
        }
        finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }
}
