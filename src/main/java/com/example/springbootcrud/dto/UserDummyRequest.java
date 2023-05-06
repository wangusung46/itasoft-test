package com.example.springbootcrud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDummyRequest {

    private int id;
    private String name;
    private String hp;
    private String email;
    private String alamat;
}
