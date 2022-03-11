package ru.vlapin.demo.demorabbit.model;

import static lombok.AccessLevel.PRIVATE;

import java.util.Objects;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@Getter
@Entity
@ToString
@Setter(PRIVATE)
@NoArgsConstructor
@RequiredArgsConstructor
public class ToDo {

  @Id
  @Include
  @GeneratedValue
  @Column(updatable = false, nullable = false)
  UUID id;

  @Version
  int version;

  @NonNull String name;

  //region equals and hashcode
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    ToDo toDo = (ToDo) o;
    return Objects.equals(id, toDo.id);
  }

  @Override
  public int hashCode() {
    return 0;
  }
  //endregion
}
