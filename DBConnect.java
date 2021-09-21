import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect {
    public static void main(String[] args) {

        String driveName = "com.mysql.cj.jdbc.Driver";// mysql database
        String url= "jdbc:mysql://localhost:3306/test1";//database location
        String user= "root";//database user name
        String password= "Root1234";//database password

        //exception handling -> try-catch
        try
        {
            //Load Driver
            Class.forName(driveName);
            //get db connection from diver manager
            Connection con = DriverManager.getConnection(url, user, password);//return Connection
            //create statement
            Statement stmt = con.createStatement(); // return statement
            //execute sql query
            //1.select 2.insert 3.delete 4.update
            //1.select -> display all data
            ResultSet rs = stmt.executeQuery("select * from student");// return all records
            while(rs.next())
            {
                //read all record by column name
                System.out.println("SID : " +rs.getInt(1)); //sid 1
                System.out.println("First Name : " +rs.getString(2)); //firstname 2
                System.out.println("Last Name : " +rs.getString(3)); //lastname 3
                System.out.println("Score : " +rs.getInt(4)); //score 4
                System.out.println("==========================================");

            }// while ends
            //2.Insert record
            //int row_count = stmt.executeUpdate("insert into student(sid,firstname,lastname,score) values(1001, 'Shikha', 'P', 92)");
            //System.out.println("Row insert : "+row_count);

            //3.Delete record
            //String sql="delete from student where sid=1001";
            //stmt.executeUpdate(sql);
            //System.out.println("Row deleted successfully");

            //4.Update record
            String sql1="update student set score=57 where sid=101";
            stmt.executeUpdate(sql1);
            System.out.println("Record updated");
        }
        catch (Exception ex)
        {
            //handling exceptions and error
            System.out.println("DB error :" +ex);
        }
    }
}
