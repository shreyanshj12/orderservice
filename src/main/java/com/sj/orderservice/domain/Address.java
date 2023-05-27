package com.sj.orderservice.domain;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
  private String address;
  private String city;
  private String state;
  private String zipCode;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Address)) return false;

    Address address = (Address) o;

    if (!address.equals(address.address)) return false;
    if (!city.equals(address.city)) return false;
    if (!state.equals(address.state)) return false;
    return zipCode.equals(address.zipCode);
  }

  @Override
  public int hashCode() {
    int result = address.hashCode();
    result = 31 * result + city.hashCode();
    result = 31 * result + state.hashCode();
    result = 31 * result + zipCode.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "Address{" +
            "addressLine1='" + address + '\'' +
            ", city='" + city + '\'' +
            ", state='" + state + '\'' +
            ", zipCode='" + zipCode + '\'' +
            '}';
  }
}
