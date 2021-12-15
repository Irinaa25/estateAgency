package com.example.agency.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String realtor;

    @NonNull
    @JoinColumn(name = "client_id")
    @ManyToOne
    private Client client;


    public Deal(String realtor, Client client) {
        this.realtor = realtor;
        this.client = client;
    }
}
