package Database;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Rafal Byczek on 27.02.18.
 */

final public class Database {
    /**
     * Only one instance of database
     */
    public static final Database instance = new Database();
    private String SERVER;
    private String PORT;
    private String DB_NAME;
    private String USER_NAME;
    private String PASSWORD;
    /**
     * database to database
     */
    public final Connection connection;

    public void loadParams() {
        final Properties props = new Properties();
        InputStream is = null;

        try {
            final File f = new File("config.properties");
            is = new FileInputStream(f);
        } catch (final Exception ignored) {
            is = null;
        }

        try {
            if (is == null) {
                is = getClass().getResourceAsStream("config.properties");
            }

            props.load(is);
        } catch (final Exception e) {

        }

        SERVER = props.getProperty("SERVER");
        PORT = props.getProperty("PORT");
        DB_NAME = props.getProperty("DB_NAME");
        USER_NAME = props.getProperty("USER_NAME");
        PASSWORD = props.getProperty("PASSWORD");
    }

    /**
     * Constructor
     */
    private Database() {
        loadParams();

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection("jdbc:postgresql://" + SERVER + ':' + PORT + '/' + DB_NAME, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new DatabaseException(e);
        }
    }
}
