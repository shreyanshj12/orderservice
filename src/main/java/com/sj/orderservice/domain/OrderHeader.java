package com.sj.orderservice.domain;

import com.sj.orderservice.utils.OrderStatus;
import javax.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "order_header")
@AttributeOverrides({
        @AttributeOverride(
                name = "shippingAddress.address",
                column = @Column(name = "shipping_address")
        ),
        @AttributeOverride(
                name = "shippingAddress.city",
                column = @Column(name = "shipping_city")
        ),
        @AttributeOverride(
                name = "shippingAddress.state",
                column = @Column(name = "shipping_state")
        ),
        @AttributeOverride(
                name = "shippingAddress.zipCode",
                column = @Column(name = "shipping_zip_code")
        ),
        @AttributeOverride(
                name = "billingAddress.address",
                column = @Column(name = "bill_to_address")
        ),
        @AttributeOverride(
                name = "billingAddress.city",
                column = @Column(name = "bill_to_city")
        ),
        @AttributeOverride(
                name = "billingAddress.state",
                column = @Column(name = "bill_to_state")
        ),
        @AttributeOverride(
                name = "billingAddress.zipCode",
                column = @Column(name = "bill_to_zip_code")
        )
})
public class OrderHeader extends BaseEntity {

  private String customer;

  @Embedded
  private Address shippingAddress;

  @Embedded
  private Address billingAddress;

  @Enumerated(value = EnumType.STRING)
  private OrderStatus orderStatus;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof OrderHeader)) return false;
    if (!super.equals(o)) return false;

    OrderHeader that = (OrderHeader) o;

    if (getCustomer() != null ? !getCustomer().equals(that.getCustomer()) : that.getCustomer() != null) return false;
    if (getShippingAddress() != null ? !getShippingAddress().equals(that.getShippingAddress()) : that.getShippingAddress() != null)
      return false;
    if (getBillingAddress() != null ? !getBillingAddress().equals(that.getBillingAddress()) : that.getBillingAddress() != null)
      return false;
    return getOrderStatus() == that.getOrderStatus();
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (getCustomer() != null ? getCustomer().hashCode() : 0);
    result = 31 * result + (getShippingAddress() != null ? getShippingAddress().hashCode() : 0);
    result = 31 * result + (getBillingAddress() != null ? getBillingAddress().hashCode() : 0);
    result = 31 * result + (getOrderStatus() != null ? getOrderStatus().hashCode() : 0);
    return result;
  }
}
