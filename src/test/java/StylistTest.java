import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class StylistTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Stylist_instantiatesCorrectly_true() {
    Stylist testStylist = new Stylist("David Bowie");
    assertEquals(true, testStylist instanceof Stylist);
  }

  @Test
  public void getName_stylistInstantiatesWithName_name() {
    Stylist testStylist = new Stylist("David Bowie");
    assertEquals("David Bowie", testStylist.getName());
  }

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Stylist.all().size(), 0);
  }

  @Test
  public void equals_returnsTrueIfNamesAretheSame() {
    Stylist firstStylist = new Stylist("David Bowie");
    Stylist secondStylist = new Stylist("David Bowie");
    assertTrue(firstStylist.equals(secondStylist));
  }

  @Test
  public void save_returnsTrueIfSaved_true() {
    Stylist testStylist = new Stylist("David Bowie");
    testStylist.save();
    assertEquals(Stylist.all().get(0).getName(), testStylist.getName());
  }

  @Test
  public void save_assignsIdToObject() {
    Stylist testStylist = new Stylist("David Bowie");
    testStylist.save();
    Stylist savedStylist = Stylist.all().get(0);
    assertEquals(testStylist.getId(), savedStylist.getId());
  }

  @Test
  public void find_findStylistInDatabase_true() {
    Stylist testStylist = new Stylist("David Bowie");
    testStylist.save();
    Stylist savedStylist = Stylist.find(testStylist.getId());
    assertEquals(savedStylist.getName(), testStylist.getName());
  }

  @Test
  public void getClients_retrievesAllClientsFromDatabase_clientsList() {
    Stylist testStylist = new Stylist("David Bowie");
    testStylist.save();
    Client firstClient = new Client("John Smith", testStylist.getId());
    firstClient.save();
    Client secondClient = new Client("Jane Doe", testStylist.getId());
    secondClient.save();
    Client[] clients = new Client[] { firstClient, secondClient };
    assertEquals(testStylist.getClients().size(), 2);
  }

}
