package lesson25;

import lesson25.service.HibernateService;

/**
 * @author Oleksandr Storozhuk
 * @version 1.0.0
 * created on 25.06.2021
 *
 * HibConnector allows to work with Student database from lesson22.
 */
public class HibConnector {
    public static void main(String[] args) {
        new HibernateService().run();
    }
}
