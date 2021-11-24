package com.github.pushkar97.pointOfSale;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProductPortDummyTest {

    IProductPort productPort;

    @BeforeAll
    public void setup() {
        productPort = new ProductPortDummy();
    }

    @Test
    void shouldReturn7_25__whenProductIdIs12345() {
        assertThat(productPort.getPriceFor("12345")).isPresent().get().isEqualTo(7.25d);
    }

    @Test
    void shouldReturnEmpty__whenProductIdIs99999() {
        assertThat(productPort.getPriceFor("99999")).isNotPresent();
    }

    @Test
    void shouldThrowIlligalArgumentError__whenProductIdIsEmpty() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> productPort.getPriceFor(""));
    }
}