package com.perfectJava.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name="user-profile")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class UserProfile implements Serializable {
    @Id
    @SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "SEQ_PROFILE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE_GENERATOR")
    private Long id;

    private String name;

    private Long follower;


}
