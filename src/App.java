/**
 * @author Hassan Mugabo
 * 
 */

public class App {
    public static void main(String[] args) throws Exception {
        
        Users userstable =  new Users();

        System.out.println("\nCodeparl Users Table\n");
        userstable.displayHeader();
        userstable.diplayUsers();
        userstable.closeResources();


    }
}
