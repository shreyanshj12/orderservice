package com.sj.orderservice.repositories;

import com.sj.orderservice.domain.OrderHeader;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHeaderRepository extends JpaRepository<OrderHeader, UUID> {
}
