package io.ince.vms.datamangodb.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {

    @Id
    private String id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private Integer age;

    @Indexed(unique = true)
    private String email;

}
