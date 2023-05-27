package com.sj.orderservice.repositories;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.sj.orderservice.domain.OrderHeader;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderHeaderRepositoryTest {

  @Autowired
  private OrderHeaderRepository orderHeaderRepository;

  @Test
  public void test_saveOrderHeader() {
    final OrderHeader orderHeader = OrderHeader.builder()
        .customer("first buyer")
        .build();

    final OrderHeader savedOrder = orderHeaderRepository.save(orderHeader);
    final Optional<OrderHeader> fetchedOrder = orderHeaderRepository.findById(savedOrder.getId());

    assertNotNull(fetchedOrder);
    assertNotNull(fetchedOrder.get().getId());
    assertNotNull(fetchedOrder.get().getCreatedDate());
    assertNotNull(fetchedOrder.get().getLastModifiedDate());
  }
}