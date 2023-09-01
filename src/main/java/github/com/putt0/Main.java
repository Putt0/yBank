package github.com.putt0;

import github.com.putt0.storage.mysql.MySQL;
import github.com.putt0.view.Auth;

public class Main {

    public static void main(String[] args) {
        new MySQL().loadMySQL();
        new Auth().show();
    }
}