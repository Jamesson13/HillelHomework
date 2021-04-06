package com.storozhuk.lesson6;

/**
 * Class PhoneBase
 *
 * Implements Selector interface.
 * Creates array of Phone objects.
 */
public class PhonesBase implements Selector {
    private Integer phonesCount = 0;
    Phone[] phonesList = new Phone[phonesCount];

    public PhonesBase() {}

    /* Add new Phone to array */
    public void addPhone(Phone p) {
        // create new temporary array and copy all students data
        Phone[] tmp = new Phone[++phonesCount];
        for(int i = 0; i < this.phonesList.length; i++) {
            tmp[i] = this.phonesList[i];
        }

        // add new student
        tmp[phonesCount-1] = p;
        this.phonesList = tmp;
    }

    /* Show all subscribers  */
    public void showAll() {
        System.out.println("\nSubscribers:");
        for(Phone ph : this.phonesList) {
            System.out.println(ph.toString());
        }
    }

    /* Show subscribers with city-calls time greater than tm */
    @Override
    public void showCityCallsTimeGt(long tm) {
        System.out.println("\nSubscribers with city-calls time greater than " + tm + " seconds:");
        for(Phone ph : this.phonesList) {
            if(ph.getCityCallsTime() > tm) {
                System.out.println(ph.toString());
            }
        }
    }

    /* Show subscribers who used long distance calls */
    @Override
    public void showLongDistCalls() {
        System.out.println("\nSubscribers who used long distance calls:");
        for(Phone ph : this.phonesList) {
            if(ph.getLongDistanceCallsTime() > 0) {
                System.out.println(ph.toString());
            }
        }
    }

    /* Show all subscribers in alphabetical order */
    @Override
    public void showWithAlphabetSort() {
        Phone[] tmpPhonesList = new Phone[this.phonesList.length];
        Phone tmpCopy;

        /* Copy and sort */
        for(int i = 0; i < this.phonesList.length; i++) {
            tmpPhonesList[i] = this.phonesList[i];
        }
        for(int i = 0; i < this.phonesList.length; i++) {
            for(int j = i+1; j < this.phonesList.length; j++) {
                if(tmpPhonesList[i].getFullName().compareTo(tmpPhonesList[j].getFullName()) > 0) {
                    tmpCopy = tmpPhonesList[i];
                    tmpPhonesList[i] = tmpPhonesList[j];
                    tmpPhonesList[j] = tmpCopy;
                }
            }
        }

        /* Show sorted data */
        System.out.println("\nAll subscribers in alphabetical order:");
        for(Phone ph : tmpPhonesList) {
            System.out.println(ph.toString());
        }
    }

    /* Show first 10 subscribers which used internet the most */
    @Override
    public void showTop10Internet() {
        Phone[] tmpPhonesList = new Phone[this.phonesList.length];
        Phone tmpCopy;

        /* Copy and sort */
        for (int i = 0; i < this.phonesList.length; i++) {
            tmpPhonesList[i] = this.phonesList[i];
        }
        for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < this.phonesList.length; j++) {
                if (tmpPhonesList[j].getInternetTraffic() > tmpPhonesList[i].getInternetTraffic()) {
                    tmpCopy = tmpPhonesList[i];
                    tmpPhonesList[i] = tmpPhonesList[j];
                    tmpPhonesList[j] = tmpCopy;
                }
            }
        }

        System.out.println("\nFirst 10 subscribers which used internet the most:");
        for (int i = 0; i < 10; i++) {
            System.out.println(tmpPhonesList[i].toString());
        }
    }
}
