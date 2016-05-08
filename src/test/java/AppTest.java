import org.junit.*;
import static org.junit.Assert.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("PDX");
  }

  @Test
  public void stylistIsCreatedTest(){
    goTo("http://localhost:4567/");
    click("a", withText("Add a Stylist"));
    fill("#stylist").with("David Bowie");
    submit(".btn");
    assertThat(pageSource()).contains("David Bowie");
  }

  @Test
  public void clientsDisplayOnStylistPage() {
    Stylist testStylist = new Stylist("David Bowie");
    testStylist.save();
    Client firstClient = new Client("John Smith", testStylist.getId());
    firstClient.save();
    Client secondClient = new Client("Jane Doe", testStylist.getId());
    secondClient.save();
    String stylistPath = String.format("http://localhost:4567/stylists/%d", testStylist.getId());
    goTo(stylistPath);
    assertThat(pageSource()).contains("John Smith");
    assertThat(pageSource()).contains("Jane Doe");
  }

  // @Test
  // public void clientUpdate() {
  //   Stylist testStylist = new Stylist("David Bowie");
  //   testStylist.save();
  //   Client myClient = new Client("John Smith", testStylist.getId());
  //   myClient.save();
  //   String clientPath = String.format("http://localhost:4567/stylists/%d", testStylist.getId());
  //   goTo(clientPath);
  //   click("a", withText("John Smith"));
  //   fill("#client-new").with("Meyers Leonard");
  //   submit("#update-client");
  //   assertThat(pageSource()).contains("Meyers Leonard");
  // }

}
