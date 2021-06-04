package lesson20.service.dto;

import lesson20.service.dto.types.AtmTrType;

/**
 * Class Client
 *
 * Representation ATM client.
 * Each client can withdraw or pay money to the ATM.
 * The transactions period, size and type can be configured.
 * For example, with transactionTypeProb=1, each operation will be a replenishment
 * and with transactionTypeProb=0 each operation will be a cash withdraw.
 *
 * If transaction fails, then client no longer interacts with ATM.
 */
public class Client extends Thread {
    private final int transactionsPeriodMin;
    private final int transactionsPeriodDev;
    private final int transactionSizeMin;
    private final int transactionSizeDev;
    private final double transactionTypeProb;

    public Client(String name, int transactionsPeriodMin, int transactionsPeriodDev,
                  int transactionSizeMin, int transactionSizeDev, double transactionTypeProb) {
        super(name);
        this.transactionsPeriodMin = transactionsPeriodMin;
        this.transactionsPeriodDev = transactionsPeriodDev;
        this.transactionSizeMin = transactionSizeMin;
        this.transactionSizeDev = transactionSizeDev;
        this.transactionTypeProb = transactionTypeProb;
    }

    @Override
    public void run() {
        boolean atmAvailable;

        do {
            try {
                Thread.sleep(random(this.transactionsPeriodMin, this.transactionsPeriodDev));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            atmAvailable = Atm.transaction(this,
                    generateTransactionType(),
                    random(this.transactionSizeMin, this.transactionSizeDev));
        } while(atmAvailable);

        System.out.println(this.getName() + " no longer interacts with ATM.");
    }

    /* Generate transaction type depending on transactionTypeProb value */
    private AtmTrType generateTransactionType() {
        return Math.random() < this.transactionTypeProb? AtmTrType.REPLENISHMENT: AtmTrType.WITHDRAWAL;
    }

    /* Generate random value from min to min+deviation */
    private int random (int min, int deviation) {
        return min + (int)(Math.random() * deviation);
    }
}
