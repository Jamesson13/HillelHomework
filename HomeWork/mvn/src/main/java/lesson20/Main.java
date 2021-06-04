package lesson20;

import lesson20.service.AtmService;

/**
 * Написать мини приложение банкомат, которое работает в нескольких потоках,
 * каждый поток может класть и снимать определенную сумму сумму из банкомата
 */
public class Main {
    public static void main(String[] args) {
        AtmService.begin();
    }
}
