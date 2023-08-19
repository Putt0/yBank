package github.com.putt0;

import github.com.putt0.storage.mysql.MySQL;

public class Main {

    private static final MySQL mySQL = new MySQL();

    public static void main(String[] args) {
        mySQL.loadMySQL();
    }
}