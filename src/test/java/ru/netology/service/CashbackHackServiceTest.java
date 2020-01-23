package ru.netology.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CashbackHackServiceTest {

    @Test
        //  ничего не куплено. Ни одного рубля
    void NothingBought() {
        CashbackHackService service = new CashbackHackService();
        int amount = 0;

        assertThrows(IllegalArgumentException.class, () -> {
            service.remain(amount);
        });
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Parameters.csv", numLinesToSkip = 1)
        // перебор суммы
    void ParameterizedSum(int amount, int expected) {
        CashbackHackService service = new CashbackHackService();
        int actual = service.remain(amount);
        assertEquals(expected, actual);
    }
}