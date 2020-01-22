package ru.netology.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashbackHackServiceTest {

    @Test
        //  ничего не куплено. Ни одного рубля
    void NothingBought() {
        CashbackHackService service = new CashbackHackService();
        int amount = 0;
        int actual = service.remain(amount);
        int expected = 1_000;
        assertEquals(expected, actual);
    }

    @Test
        // один рубль
    void OneRuble() {
        CashbackHackService service = new CashbackHackService();
        int amount = 1;
        int actual = service.remain(amount);
        int expected = 999;
        assertEquals(expected, actual);
    }

    @Test
        //  не хватает одного рубля
    void OneRubleMore() {
        CashbackHackService service = new CashbackHackService();
        int amount = 999;
        int actual = service.remain(amount);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
        // ровно тысяча - падает
    void OneThousand() {
        CashbackHackService service = new CashbackHackService();
        int amount = 1_000;
        int actual = service.remain(amount);
        int expected = 0;
        assertEquals(expected, actual);
    }
}