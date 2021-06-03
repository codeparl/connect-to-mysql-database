import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;



public class Users {


    private Connection conn;//used to establish a database connection
    private ResultSet resultSet;
    private ResultSetMetaData metaData;
    private Statement sql; //used to run a query
    private int columnCount;
    private final  String  DB_URL  = "jdbc:mysql://localhost/javaTest";
    
    
    public Users() throws SQLException{

        var userName  ="root";// Replace with yours
        var password="";//Empty password, replace with yours

        //create a connection by using a factory method
        // (getConnection) of Drivermanager interface
        conn =  DriverManager.getConnection(DB_URL,userName,password);

        //prepare sql statement to execute
         sql  =  conn.createStatement();

        String sqlStr = "SELECT * FROM users";

        //obtain the resultset of the query
        resultSet =  sql.executeQuery(sqlStr);
        //get the metadata to access information such
        //as column count...
        metaData =  resultSet.getMetaData();
        columnCount = metaData.getColumnCount();


    }

    public void displayHeader() throws SQLException {
        for (int i = 1; i <= this.columnCount; i++) 
        System.out.printf("%-18s\t", metaData.getColumnName(i));

        System.out.println();
        for (int i = 1; i <= 35; i++) 
            System.out.print("--");
        
        System.out.println();
    }

    public void  diplayUsers() throws SQLException{

        //as long as there are more rows in the resultset,
        //print each cell's data of a row and print a new line after 
        //each row.
        while (resultSet.next()) {
            for (int i = 1; i <= this.columnCount; i++) 
            System.out.printf("%-18s\t", resultSet.getObject(i)); 
            System.out.println();//necessary to indicate a  row
        }
        System.out.println();

    }

    /**
     * This method closes all used resources 
     * in Users class.  SQLException is handled.
     */
    public void closeResources(){
        try {
            conn.close();
            sql.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
