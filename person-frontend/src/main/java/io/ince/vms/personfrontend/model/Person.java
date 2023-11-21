package io.ince.vms.personfrontend.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Person {

    private String id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private Integer age;
    private String email;
}
