package lesson23;

import lesson23.service.DBService;

import java.sql.*;

/**
 * Class DBConnector
 *
 * @author Oleksandr Storozhuk
 * @version 1.0.0
 * created on 15.06.2021
 *
 * Main class for database connector.
 * DBConnector allows to work with Student database from lesson22.
 *
 * Program should run with arguments: URL USER PASS.
 */
public class DBConnector {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        if(args.length != 3) {
            System.out.println("Bad program arguments.");
            return;
        }
        new DBService().run(args[0], args[1], args[2]);
    }
}
