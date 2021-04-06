package com.storozhuk.lesson6;

/**
 * Class Phone
 *
 * Creates object Phone with specified data.
 * id of every Phone is generated by class constructor
 */
public class Phone {
    private static int idCounter = 0;
    private int id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String address;
    private String phoneNumber;
    private String cardNumber;
    private double debit = 0;
    private double credit = 0;
    private long cityCallsTime = 0;
    private long longDistanceCallsTime = 0;
    private long internetTraffic = 0;

    public Phone() {
        this.id = idCounter++;
    }

    public Phone(String firstName, String lastName, String patronymic,
                 String address, String phoneNumber, String cardNumber) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.cardNumber = cardNumber;
    }

    public Phone(String firstName, String lastName, String patronymic,
                 String address, String phoneNumber, String cardNumber,
                 double debit, double credit, long cityCallsTime,
                 long longDistanceCallsTime, long internetTraffic) {
        this(firstName, lastName, patronymic, address, phoneNumber, cardNumber);
        this.debit = debit;
        this.credit = credit;
        this.cityCallsTime = cityCallsTime;
        this.longDistanceCallsTime = longDistanceCallsTime;
        this.internetTraffic = internetTraffic;
    }

    /* Getters and Setters */
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public long getCityCallsTime() {
        return cityCallsTime;
    }

    public void setCityCallsTime(long cityCallsTime) {
        this.cityCallsTime = cityCallsTime;
    }

    public long getLongDistanceCallsTime() {
        return longDistanceCallsTime;
    }

    public void setLongDistanceCallsTime(long longDistanceCallsTime) {
        this.longDistanceCallsTime = longDistanceCallsTime;
    }

    public long getInternetTraffic() {
        return internetTraffic;
    }

    public void setInternetTraffic(long internetTraffic) {
        this.internetTraffic = internetTraffic;
    }

    public String getFullName() {
        return firstName.concat(lastName.concat(patronymic));
    }

    /* String representation of the Phone objects */
    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", debit=" + debit +
                ", credit=" + credit +
                ", cityCallsTime=" + cityCallsTime +
                ", longDistanceCallsTime=" + longDistanceCallsTime +
                ", internetTraffic=" + internetTraffic +
                '}';
    }
}
