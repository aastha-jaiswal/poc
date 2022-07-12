import java.sql.Connection;
import java.sql.*;
import java.sql.Statement;
import java.util.*;

public class Main {
public static void main(String args[] ){
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false", "root", "root");

        Statement stmt = conn.createStatement();
        Scanner sc=new Scanner(System.in);
       System.out.println("Welcome to my database......");
       System.out.println("Select operation to be performed.");
       System.out.println("Press 1 for displaying the table details");
       System.out.println("Press 2 for inserting a value in a table");
       System.out.println("Press 3 for deleting a value from a table");
       System.out.println("Press 4 for updating a value from a table");


        int choice=sc.nextInt();


       switch(choice){
           case 1:{
               BookDAO dao=new BookDAO();
               ArrayList<Book> bo=dao.listBooks();
               System.out.println("List of Books");
               System.out.format("%-5s %-20s %-20s %-10s %s\n","Id","Title","Category","Author","Price");
               for(Book book : bo){
                   book.printt();}
               break;
//               Book book= new Book();
//               bo.forEach(Book.book::printt();

//               }

           }
           case 2:{
               BookDAO dao=new BookDAO();
               System.out.println("Enter Id:");
               int id = sc.nextInt();
               System.out.println("Enter Title: ");
               sc.nextLine();
               String title = sc.nextLine();
               System.out.println("Enter Category: ");
               String category = sc.nextLine();
               System.out.println("Enter Author: ");
               String author = sc.nextLine();
               System.out.println("Enter Price: ");
               double price = sc.nextDouble();
               dao.insertBook(id, title, category, author, price);
               System.out.println("Done");
               break;
           }
           case 3:{
               BookDAO dao=new BookDAO();
               System.out.println("Enter the id to be deleted");
               int id=sc.nextInt();
               dao.deleteBook(id);
               System.out.println("item is deleted");
               break;
           }
           case 4:{
               BookDAO dao=new BookDAO();
               System.out.println("Enter the id to be updated");
               int id=sc.nextInt();
               System.out.println("Enter the updated price");
               double price =sc.nextDouble();
               dao.updateBook(id,price);
               System.out.println("price is updated");


           }
       }
    } catch (Exception e) {
        e.printStackTrace();}
}


}
