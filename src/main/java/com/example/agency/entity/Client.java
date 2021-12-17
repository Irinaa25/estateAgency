package com.example.agency.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "fullName")
    private String fullName;

    @NonNull
    private Long phone;

    public Client(String fullName, Long phone) {
        this.fullName = fullName;
        this.phone = phone;
    }
}
