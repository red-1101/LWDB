package re.red.connectors;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHandler {

    private String connectionUrl;

    private Connection connection;

    /***
     *
     * @param type The type of the database your are using. MYSQL / SQLITE
     * @param host The host of your database. Assuming it is localhost & using MySQL, you could pass in: "localhost".
     * @param port This is only used for MySQL or other databases that require a port to connect to.
     * @param databaseName This is only used for MySQL or other databases that require a database name to connect to.
     * @param user The user you will want to connect with to the database.
     * @param password The password of the specific user.
     */

    public ConnectionHandler(@NotNull Databases type, @NotNull String host, @Nullable String port, @Nullable String databaseName, @Nullable String user, @Nullable String password) throws SQLException {

        if(isConnected()) throw new SQLException("Already connected to the database!");

        switch (type) {

            case MYSQL:
                connectionUrl = "jdbc:mysql://" + host + ":" + port + "/" + databaseName;
                break;


        }

        connection = DriverManager.getConnection(connectionUrl, user, password);

    }

    /**
     *
     * @param type The type of the database your are using. MYSQL / SQLITE
     * @param databasePath The path to the database file, assuming you are using SQLite.
     */

    public ConnectionHandler(Databases type, String databasePath) throws SQLException {

        if(isConnected()) throw new SQLException("Already connected to the database!");

        switch (type){

            case SQLITE:
                connectionUrl = "jdbc:sqlite:" + databasePath;
                break;

        }

        connection = DriverManager.getConnection(connectionUrl);

    }


    /***
     *
     * @return Returns the current state of the connection. Will be null if not connected.
     */
    public Connection getConnection(){

        return connection;

    }

    /***
     *
     * @return Returns whether the handler is connected to the database. Cannot throw NullPointerException
     */

    public boolean isConnected() throws SQLException {

        if(connection == null) return false;

        return !connection.isClosed();

    }

}
