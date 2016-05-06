import java.util.List;
import org.sql2o.*;
import java.util.Arrays;

public class Client {
  private String name;
  private int stylist_id;

  public Client(String name, int stylist_id) {
    this.name = name;
    this.stylist_id = stylist_id;
  }

}
