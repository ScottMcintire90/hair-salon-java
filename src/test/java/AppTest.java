import org.fluentlenium.adapter.FluentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import org.junit.*;
import java.util.List;
import org.sql2o.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  // @Test
  // public void doctorIsSavedTest(){
  //   Doctor myDoctor = new Doctor("John Smith", "Endocrinologist");
  //   myDoctor.save();
  //   System.out.println(myDoctor.getId());
  //   String doctorPath = String.format("http://localhost:4567/doctors/%d", myDoctor.getId());
  //   goTo(doctorPath);
  //   assertThat(pageSource()).contains("John Smith");
  // }
}
