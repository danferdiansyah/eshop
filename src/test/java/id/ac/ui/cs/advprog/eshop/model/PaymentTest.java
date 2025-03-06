package id.ac.ui.cs.advprog.eshop.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PaymentTest{

    private Map<String, String> voucherData;
    @BeforeEach
    void setUp() {
        voucherData = new HashMap<>();
        voucherData.put("voucherCode", "ESHOP");

    }

    @Test
    void testCreatePaymentVoucher() {
        Payment payment = new Payment("a7c86c9d-f08b-4f57-ac05-9e95a9b36e3d", "VOUCHER", "SUCCESS", voucherData);
        assertEquals("a7c86c9d-f08b-4f57-ac05-9e95a9b36e3d", payment.getId());
        assertEquals("VOUCHER", payment.getMethod());
        assertEquals(voucherData, payment.getPaymentData());
    }

    @Test
    void testCreatePaymentSuccess() {
        Map<String, String> newData = new HashMap<>();
        newData.put("voucherCode", "ESHOP");
        Payment payment = new Payment("b2ec45d8-91c8-4b49-9de9-187f23abc123", "VOUCHER", "SUCCESS", newData);
        payment.setStatus("SUCCESS");
        assertEquals("b2ec45d8-91c8-4b49-9de9-187f23abc123", payment.getId());
        assertEquals("ESHOP", voucherData.get("voucherCode"));
        assertEquals("VOUCHER", payment.getMethod());
        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testCreatePaymentFail() {
        Map<String, String> newData = new HashMap<>();
        newData.put("voucherCode", "MEOW");
        Payment payment = new Payment("d5f79e3a-cc6b-4216-b54d-3ff082e2b139", "VOUCHER", "REJECTED", newData);
        payment.setStatus("REJECTED");
        assertEquals("d5f79e3a-cc6b-4216-b54d-3ff082e2b139", payment.getId());
        assertNotEquals("ESHOP", newData.get("voucherCode"));
        assertEquals("VOUCHER", payment.getMethod());
        assertEquals("REJECTED", payment.getStatus());
    }
}