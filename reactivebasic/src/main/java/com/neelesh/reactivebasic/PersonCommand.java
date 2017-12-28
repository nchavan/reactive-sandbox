package com.neelesh.reactivebasic;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonCommand {

    public PersonCommand(Person person) {
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
    }

    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;

    public String sayMyName(){
        return "My Name is " + firstName + " " + lastName + ".";
    }
}
