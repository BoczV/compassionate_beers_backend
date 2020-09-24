package com.codecool.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Beer {

    @Id
    @GeneratedValue
    private Long id;

    private String img;

    @Column(nullable = false)
    private String name;

    private String brewed_Date;

    private Float alcohol_ratio;

    @ManyToOne
    //@JoinColumn(name = "userName")
    @Column(nullable = false)
    private User user;
}
