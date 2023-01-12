import db.DB;
import db.DbIntegrityException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class App {

  public static void main(String[] args) {
    System.out.println("=====================================================");

    Connection conn = null;
    PreparedStatement st = null;
    try {
      conn = DB.getConnection();

      st = conn.prepareStatement("DELETE FROM seller " + "WHERE " + "Id = ?");

      st.setInt(1, 9);

      int rowsAffected = st.executeUpdate();

      System.out.println("Done! Rows affected: " + rowsAffected);
    } catch (SQLException e) {
      throw new DbIntegrityException(e.getMessage());
    } finally {
      DB.closeStatement(st);
      DB.closeConnection();
    }

    System.out.println("=====================================================");
  }
}
