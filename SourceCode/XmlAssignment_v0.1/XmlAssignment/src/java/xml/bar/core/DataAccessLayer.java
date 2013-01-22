/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.bar.core;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author Tu
 */
public class DataAccessLayer {

    public static Connection getConnection() {
        Connection con=null;
        try {
            InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("xml/bar/resource/DatabaseConfig.properties");
            Properties properties = new Properties();
            properties.load(stream);
            String name=properties.getProperty("name");
            String pass=properties.getProperty("pass");
            String driver=properties.getProperty("driver");
            String url=properties.getProperty("url");
            Class.forName(driver);
            con=DriverManager.getConnection(url,name,pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
