import java.sql.*;
import java.util.ArrayList;

public class BookDAO {
    public ArrayList<Book> listBooks() throws ClassNotFoundException, SQLException {
        ArrayList<Book> bookList = new ArrayList<Book>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false", "root", "root");
        Statement stmt = conn.createStatement();
        String q="select * from book";
        PreparedStatement pst=conn.prepareStatement(q);
        // Statement smt=Con.CreateStatement();
        ResultSet set=pst.executeQuery(q);
        while(set.next()){
            Book b=new Book();
            b.setId(set.getInt("Id"));
            b.setTitle(set.getString("Title"));
            b.setCategory(set.getString("Category"));
            b.setAuthor(set.getString("Author"));
            b.setPrice(set.getDouble("Price"));
            bookList.add(b);
        }

        return bookList;


    }
    public void insertBook(int id,String title,String category,String author,double price) throws Exception {
        //fill your code here
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false", "root", "root");
        String q = "insert into Book"+
                 " (id, title, category,author,price)" + " values (?,?,?,?,?)";
        PreparedStatement myStmt = conn.prepareStatement(q);

        Book b=new Book(id,title,category,author,price);

        myStmt.setInt(1, b.getId());
        myStmt.setString(2, b.getTitle());
        myStmt.setString(3, b.getCategory());
        myStmt.setString(4, b.getAuthor());
        myStmt.setDouble(5, b.getPrice());


        myStmt.executeUpdate();


    }
    public void deleteBook(int id) throws Exception{
        //fill your code here
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false", "root", "root");
        String q="delete from book where id=?";
        PreparedStatement pst=conn.prepareStatement(q);
        pst.setInt(1,id);
        pst.executeUpdate();

    }

    public void updateBook(int id,double price) throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false", "root", "root");
        Statement stmt = conn.createStatement();
        String sql = "UPDATE Book " +
                "SET price = "+price+" WHERE id = "+id;
        stmt.executeUpdate(sql);
//        ResultSet rs = stmt.executeQuery(QUERY);
//        while(rs.next()){
//            //Display values
//            System.out.print("ID: " + rs.getInt("id"));
//            System.out.print(", Age: " + rs.getInt("age"));
//            System.out.print(", First: " + rs.getString("first"));
//            System.out.println(", Last: " + rs.getString("last"));
//        }
//        rs.close();
    }

}


