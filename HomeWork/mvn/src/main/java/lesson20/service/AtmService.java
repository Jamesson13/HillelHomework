package lesson20.service;

import lesson20.service.dto.Client;
import lesson20.service.dto.Atm;

/**
 * Class AtmService
 *
 * Representation of customer interaction with an ATM.
 */
public class AtmService {
    public static void begin () {
        Atm.setMoney(500_000);

        Thread client1 = new Client("Client_1", 500, 1000,
                50_000, 10_000, 0.25);
        Thread client2 = new Client("Client_2", 400, 1000,
                0, 50_000, 0.3);
        Thread client3 = new Client("Client_3", 300, 500,
                0, 50_000, 0.35);
        Thread client4 = new Client("Client_4", 300, 500,
                0, 50_000, 0.2);

        System.out.println("[-Client---Transaction--Amount--Result-------Remained-----]");
        client1.start();
        client2.start();
        client3.start();
        client4.start();
    }
}
