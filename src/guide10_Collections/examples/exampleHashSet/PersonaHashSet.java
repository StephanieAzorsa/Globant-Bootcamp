package guide10_Collections.examples.exampleHashSet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaHashSet {
    private Integer dni;
    private String name;
    private String lastname;

    //BOTH METHODS WORK TOGETHER TO MAKE CORRECT VALIDATIONS AND AVOID DUPLICATIONS.
    //I MUST DECIDE UNDER WHICH CRITERIA I MAKE THE COMPARISON.
    @Override // I create it to define which parameter is used to avoid repeating data, in this case DNI.
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {//I create it to define which parameter is used to avoid repeating data, in this case DNI.
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final PersonaHashSet other = (PersonaHashSet) obj;
        return Objects.equals(this.dni, other.dni);
    }

}