package ro.jtonic.handson.java.designpatterns;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Antonel Ernest Pazargic on 30/06/2018.
 *
 * @author Antonel Ernest Pazargic
 */

public final class MySingleton {

  private Map<String, String> configuration = new HashMap<>();

  private static volatile MySingleton SINGLETON; //volatile doesn't work on java 1.4 or older

  private MySingleton(String configFile) {
    try {
      final URL resource = MySingleton.class.getResource(configFile);
      final File file = new File(resource.toURI());

      try(Reader fr = new FileReader(file);
          BufferedReader br = new BufferedReader(fr)) {
        String line;
        while ((line = br.readLine()) != null) {
          final int occ = line.indexOf(',');
          if(occ != -1) {
            final String key = line.substring(0, occ);
            final String value = line.substring(occ + 1);
            configuration.put(key, value);
          }
        }
      }
    } catch (URISyntaxException | IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static MySingleton getSingleton(String configFile) {
      if (SINGLETON == null) {
        synchronized (MySingleton.class) {
          if (SINGLETON == null) {
            SINGLETON = new MySingleton(configFile);
          }
        }
      }
      return SINGLETON;
  }

  public String getValue(String value) {
    return configuration.get(value);
  }

  public Map<String, String> getConfiguration() {
    return Collections.unmodifiableMap(configuration);
  }
}
