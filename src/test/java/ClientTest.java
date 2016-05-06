import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.List;

public class ClientTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String deleteStylistQuery = "DELETE FROM stylists *;";
      String deleteClientQuery = "DELETE FROM clients *;";
      con.createQuery(deleteStylistQuery).executeUpdate();
      con.createQuery(deleteClientQuery).executeUpdate();
    }
  }

  @Test
  public void Client_instantiatesCorrectly_true() {
    Client testClient = new Client("John Smith", 1);
    assertEquals(true, testClient instanceof Client);
  }

  @Test
  public void getName_instantiatesWithName_name() {
    Client testClient = new Client("John Smith", 1);
    assertEquals("John Smith", testClient.getName());
  }

  @Test
  public void getId_clientsInstantiateWithAnId_1() {
    Client testClient = new Client("John Smith", 1);
    testClient.save();
    assertEquals(1, testClient.getStylistId());
  }

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Client.all().size(), 0);
  }

  @Test
  public void equals_returnsTrueIfNamesAreTheSame_true() {
    Client firstClient = new Client("John Smith", 1);
    Client secondClient = new Client("John Smith", 1);
    assertTrue(firstClient.equals(secondClient));
  }
}
