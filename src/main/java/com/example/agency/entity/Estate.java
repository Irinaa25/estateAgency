package com.example.agency.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Estate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String estate_type;

    @NonNull
    private int price;

    @NonNull
    private int year_construction;

    @NonNull
    private int area;

    @NonNull
    @JoinColumn(name = "client_id")
    @ManyToOne
    private Client client;

    public Estate(String name, String estate_type, int price, int year_construction, int area, Client client) {
        this.name = name;
        this.estate_type = estate_type;
        this.price = price;
        this.year_construction = year_construction;
        this.area = area;
        this.client = client;
    }
}
