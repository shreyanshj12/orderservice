package com.sj.orderservice.domain;

import java.sql.Timestamp;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(length = 36, nullable = false)
  private UUID id;

  @CreationTimestamp
  @Column(name = "created_date", updatable = false)
  private Timestamp createdDate;

  @UpdateTimestamp
  @Column(name = "last_modified_date")
  private Timestamp lastModifiedDate;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof BaseEntity)) return false;

    BaseEntity that = (BaseEntity) o;

    if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
    if (getCreatedDate() != null ? !getCreatedDate().equals(that.getCreatedDate()) : that.getCreatedDate() != null)
      return false;
    return getLastModifiedDate() != null ? getLastModifiedDate().equals(that.getLastModifiedDate()) : that.getLastModifiedDate() == null;
  }

  @Override
  public int hashCode() {
    int result = getId() != null ? getId().hashCode() : 0;
    result = 31 * result + (getCreatedDate() != null ? getCreatedDate().hashCode() : 0);
    result = 31 * result + (getLastModifiedDate() != null ? getLastModifiedDate().hashCode() : 0);
    return result;
  }
}
