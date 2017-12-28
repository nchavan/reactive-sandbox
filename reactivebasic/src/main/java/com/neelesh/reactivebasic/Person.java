package com.neelesh.reactivebasic;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;

    public String sayMyName(){
        return "My Name is " + firstName + " " + lastName + ".";
    }
}
