package lesson20.service.dto;

import lesson20.service.dto.types.AtmTrType;

/**
 * Class Atm
 *
 * Representation of ATM functionality.
 */
public class Atm {
    private final static int ATM_LIMIT = 1_000_000;
    private volatile static int money = 0;

    public synchronized static boolean transaction (Client client, AtmTrType transaction, int amount) {
        // Show transaction
        System.out.print(client.getName() + " - " + transaction + " - " + amount);

        switch (transaction) {
            case WITHDRAWAL -> {
                if (amount > money) {
                    System.out.println(" Fail!");
                    return false;
                }
                money -= amount;
            }
            case REPLENISHMENT -> {
                if(amount > ATM_LIMIT-money) {
                    System.out.println(" Fail!");
                    return false;
                }
                money += amount;
            }
        }
        System.out.println(" Success! [Money remained=" + money + "]");
        return true;
    }

    public synchronized static void setMoney(int amount) {
        money = amount;
    }
}
