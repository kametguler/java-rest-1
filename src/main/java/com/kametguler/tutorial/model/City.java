package com.kametguler.tutorial.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id
    private String id;

    // private Date created_at = new Date(0);

    private String name;

}
