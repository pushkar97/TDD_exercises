package com.github.pushkar97.pointOfSale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CheckoutTest {

    @Mock
    IProductPort productPort;

    Checkout checkout;

    @BeforeEach
    public void setup() {
        checkout = new Checkout(productPort);
    }

    @Test
    public void testSetup() {
        assertThat(checkout).isNotNull();
    }

    @Test
    public void shouldDisplay$7_25__whenInputCodeIs12345() {
        Mockito.when(productPort.getPriceFor("12345")).thenReturn(Optional.of(7.25D));

        assertThat(checkout.getPrice("12345")).isEqualTo("$7.25");
    }

    @Test
    public void shouldDisplay$12_50__whenInputCodeIs23456() {
        Mockito.when(productPort.getPriceFor("23456")).thenReturn(Optional.of(12.50D));

        assertThat(checkout.getPrice("23456")).isEqualTo("$12.50");
    }

    @Test
    public void shouldDisplayBarcodeNotFoundError__whenInputCodeIs99999() {
        assertThat(checkout.getPrice("99999")).isEqualTo("Error: barcode not found");
    }

    @Test
    public void shouldDisplayEmptyBarcodeError__whenBarcodeIsEmpty() {
        assertThat(checkout.getPrice("")).isEqualTo("Error: empty barcode");
    }

    @Test
    public void shouldDisplayTotalPrice__whenTotalIsCalled() {
        Mockito.when(productPort.getPriceFor("12345")).thenReturn(Optional.of(7.25D));
        Mockito.when(productPort.getPriceFor("23456")).thenReturn(Optional.of(12.50D));

        assertThat(checkout.calculateTotal(List.of("12345", "23456"))).isEqualTo("$19.75");
    }
}
