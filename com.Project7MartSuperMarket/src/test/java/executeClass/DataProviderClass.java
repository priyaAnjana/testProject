package executeClass;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
  

  @DataProvider(name = "DataProvider")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "admin123", "admin" },
      new Object[] { "admin", "ad12" },
      new Object[] {"adm155","afrt"}
    };
  }
  
  @DataProvider(name = "DataProvider1")
  public Object[][] dp1() {
    return new Object[][] {
      new Object[] { "admin", "admin" }
      
    };
  }
}
