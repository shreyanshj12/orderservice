package com.sj.orderservice.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class OrderHeaderTest {

  @Test
  void testEquals_success() {
    final UUID id = UUID.randomUUID();
    final OrderHeader oh1 = new OrderHeader();
    oh1.setId(id);

    final OrderHeader oh2 = new OrderHeader();
    oh2.setId(id);

    assertEquals(oh2,oh1);
  }

  @Test
  void testEquals_fails() {
    final OrderHeader oh1 = new OrderHeader();
    oh1.setId(UUID.randomUUID());

    final OrderHeader oh2 = new OrderHeader();
    oh2.setId(UUID.randomUUID());

    assertNotEquals(oh2,oh1);
  }
}