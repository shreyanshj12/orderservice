package com.sj.orderservice.domain;

import com.sj.orderservice.utils.ProductStatus;
import java.util.UUID;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "product")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class Product extends BaseEntity {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", columnDefinition = "char(36)")
  @Type(type = "org.hibernate.type.UUIDCharType")
  private UUID id;

  @Column(name = "product_description")
  private String productDescription;

  @Enumerated(EnumType.STRING)
  @Column(name = "product_status")
  private ProductStatus productStatus;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Product)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }

    Product product = (Product) o;

    if (getId() != null ? !getId().equals(product.getId()) : product.getId() != null) {
      return false;
    }
    if (getProductDescription() != null ?
        !getProductDescription().equals(product.getProductDescription()) :
        product.getProductDescription() != null) {
      return false;
    }
    return getProductStatus() == product.getProductStatus();
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (getId() != null ? getId().hashCode() : 0);
    result =
        31 * result + (getProductDescription() != null ? getProductDescription().hashCode() : 0);
    result = 31 * result + (getProductStatus() != null ? getProductStatus().hashCode() : 0);
    return result;
  }
}
