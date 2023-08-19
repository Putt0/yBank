package github.com.putt0.storage;

public enum Database {

    MYSQL("localhost", "ybank", "root", "26110403", 3306);

    private final String address, database, username, password;
    private final int port;

    Database(String address, String database, String username, String password, int port) {
        this.address = address;
        this.database = database;
        this.username = username;
        this.password = password;
        this.port = port;
    }

    public String getAddress() {
        return address;
    }

    public String getDatabase() {
        return database;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPort() {
        return port;
    }
}