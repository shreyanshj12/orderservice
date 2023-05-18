package com.sj.orderservice.domain;

import java.util.UUID;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "order_header")
public class OrderHeader {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(length = 36, nullable = false)
  private UUID id;

  private String customer;
}
