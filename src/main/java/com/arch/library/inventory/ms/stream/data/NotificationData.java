package com.arch.library.inventory.ms.stream.data;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "notifications")
public class NotificationData {

  @Id
  private Long id;
  private String name;
  private String state;
  private String country;
}