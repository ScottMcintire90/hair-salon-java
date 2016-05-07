import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.List;

public class ClientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

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

  @Test
  public void find_findsClientsInDatabase_true() {
    Client testClient = new Client("John Smith", 1);
    testClient.save();
    Client savedClient = Client.find(testClient.getId());
    assertTrue(testClient.getName().equals(savedClient.getName()));
  }

  @Test
  public void save_assignsIdToObject() {
    Client testClient = new Client("John Smith", 1);
    testClient.save();
    Client savedClient = Client.all().get(0);
    assertEquals(testClient.getId(), savedClient.getId());
  }

  @Test
  public void save_returnsTrueIfClientsAretheSame() {
    Client testClient = new Client("John Smith", 1);
    testClient.save();
    assertTrue(Client.all().get(0).getName().equals(testClient.getName()));
  }

  @Test
  public void save_savesStylistIdIntoDB_true() {
    Stylist testStylist = new Stylist("David Bowie");
    testStylist.save();
    Client testClient = new Client("John Smith", testStylist.getId());
    testClient.save();
    Client savedClient = Client.find(testClient.getId());
    assertEquals(savedClient.getStylistId(), testStylist.getId());
  }

  @Test
  public void find_returnsNullWhenNoClientFound_null() {
    assertTrue(Client.find(999) == null);
  }
}
