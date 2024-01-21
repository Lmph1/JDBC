import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void input()
    {
        Scanner inputs = new Scanner(System.in);
        System.out.println("Enter Name : ");
        String name = inputs.nextLine();
        System.out.println("Enter Sex  : ");
        String sex = inputs.nextLine();
    }
    public static void main(String[] args) {
        Connection connection = null;
        java.sql.Statement sm = null;
        ResultSet rs = null;
        String host="localhost";
        String port="5432";
        String db_name="postgres";
        String username="postgres";
        String password="123";
        try
        {
            connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name+"", ""+username+"", ""+password+"");

            // Select all from table

            String st = "select * from student";
            Statement statement =connection.createStatement();
            boolean isSuccess = statement.execute(st);
            System.out.println("IsSuccess : "+isSuccess);
            ResultSet resultSet = statement.executeQuery(st);
            while (resultSet.next())
            {
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getInt(3));
                System.out.println(resultSet.getDouble(4));
            }

            // Insert into table student ( Static )

//            String insert = "insert into student values(5,'Vanda',24,88)";
//            Statement statement1 = connection.createStatement();
//            int rowEffected = statement1.executeUpdate(insert);
//            System.out.println("RowEffected : "+rowEffected);
            String insert = "insert into student values(input())";
            Statement statement1 = connection.createStatement();
            int rowEffected = statement1.executeUpdate(insert);
            System.out.println("RowEffected : "+rowEffected);


            // Insert into table student (Dynamic)

//            String insertDst = "insert into student values(?,?,?,?)";
//            PreparedStatement st1 = connection.prepareStatement(insertDst);
//            st1.setInt(1, 6);
//            st1.setString(2, "Neymar");
//            st1.setInt(3, 30);
//            st1.setDouble(4, 85);
//            int message = st1.executeUpdate();
//            System.out.println("RowEffected : "+message);

            // Update table student

            String update = "UPDATE student SET stu_name = 'Messi' WHERE id = 6;";
            PreparedStatement pre1 = connection.prepareStatement(update);
            int messageper = pre1.executeUpdate();
            System.out.println("Update Successfull : "+messageper);

            // Delete table student

            String delete = "DELETE FROM student WHERE id = 2;";
            PreparedStatement preparedStatementdelete = connection.prepareStatement(delete);
            int deletemessage = preparedStatementdelete.executeUpdate();
            System.out.println("Delete Successfull : "+deletemessage);

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
