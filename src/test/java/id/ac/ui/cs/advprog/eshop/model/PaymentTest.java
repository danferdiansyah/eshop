package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
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
        Payment payment = new Payment(
                "a7c86c9d-f08b-4f57-ac05-9e95a9b36e3d",
                PaymentMethod.VOUCHER.getValue(),
                PaymentStatus.SUCCESS.getValue(),
                voucherData
        );
        assertEquals("a7c86c9d-f08b-4f57-ac05-9e95a9b36e3d", payment.getId());
        assertEquals(PaymentMethod.VOUCHER.getValue(), payment.getMethod());
        assertEquals(voucherData, payment.getPaymentData());
    }

    @Test
    void testCreatePaymentSuccess() {
        Map<String, String> newData = new HashMap<>();
        newData.put("voucherCode", "ESHOP");
        Payment payment = new Payment(
                "b2ec45d8-91c8-4b49-9de9-187f23abc123",
                PaymentMethod.VOUCHER.getValue(),
                PaymentStatus.SUCCESS.getValue(),
                newData
        );
        payment.setStatus(PaymentStatus.SUCCESS.getValue());
        assertEquals("b2ec45d8-91c8-4b49-9de9-187f23abc123", payment.getId());
        assertEquals("ESHOP", voucherData.get("voucherCode"));
        assertEquals(PaymentMethod.VOUCHER.getValue(), payment.getMethod());
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
    }

    @Test
    void testCreatePaymentFail() {
        Map<String, String> newData = new HashMap<>();
        newData.put("voucherCode", "ADVPRO");
        Payment payment = new Payment(
                "d5f79e3a-cc6b-4216-b54d-3ff082e2b139",
                PaymentMethod.VOUCHER.getValue(),
                PaymentStatus.REJECTED.getValue(),
                newData
        );
        payment.setStatus(PaymentStatus.REJECTED.getValue());
        assertEquals("d5f79e3a-cc6b-4216-b54d-3ff082e2b139", payment.getId());
        assertNotEquals("ESHOP", newData.get("voucherCode"));
        assertEquals(PaymentMethod.VOUCHER.getValue(), payment.getMethod());
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }
}