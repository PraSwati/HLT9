import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HLTweek9 {
    public static void main(String[] args) {
        String DriveName="com.mysql.cj.jdbc.Driver";
        String url= "jdbc:mysql://localhost:3306/test1";
        String user= "root";
        String password= "Root1234";

        try{
            Class.forName(DriveName);
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from employee");
            while(rs.next()){
                System.out.println("EId = " +rs.getInt(1));
                System.out.println("Ename = "+rs.getString(2));
                System.out.println("Email = "+rs.getString(3));
                System.out.println("Mobile = "+rs.getString(4));
                System.out.println("Designation = "+rs.getString(5));
                System.out.println("Salary = "+rs.getInt(6));
                System.out.println("******************************************8");
            }
            //
            //Delete record
            //int del=stmt.executeUpdate("delete from employee where eid=101006");
            //System.out.println("Row deleted " +del);

            //update record
            int updt= stmt.executeUpdate("update employee set designation='Consultant DA' where eid=101002");
            System.out.println("Row updated " +updt);
        }
        catch (Exception ex){
            System.out.println("Error message : " +ex);
        }
    }
}
