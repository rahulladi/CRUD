package com.example.crud.entity;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
     private String employeeId;

     @Size(min = 3, message = "Please enter full name")
     private String name;

     private @NonNull int pay;

     private @NonNull String location;

     @Size(min = 2, message = "Please enter a valid mail")
     @Pattern(regexp = "^[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", message = "Please Enter a valid mail")
     private String email;

     @Size(min = 3, message = "Please enter a valid position")
     private String position;

     private Admin admin;
}
