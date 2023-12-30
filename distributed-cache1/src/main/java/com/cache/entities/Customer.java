package com.cache.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "customer_id", unique = true,nullable = false)
   private int id;

   @Column(name = "first_name",nullable = false, length = 25)
   private String firstName;

   @Column(name = "last_name", nullable = false,length = 25)
   private String lastName;

   @Column(name = "age",nullable = true,length = 9)
   private int age;

   @Column(name = "ssn",nullable = false,length = 25)
   private String ssn;

   @Column(name = "last_updated_by",nullable = true)
   private String lastUpdatedBy;

   @CreationTimestamp
   private Date created;

   @UpdateTimestamp
   private Date updated;
}
