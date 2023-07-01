package guide08.examples.example02.entities;

import java.util.Date;

import lombok.Data;

@Data
public class Salesperson {
    private String name;
    private Integer dni;
    private Double baseSalary;
    private Double commission;
    private Double monthlySales;
    private Date startDate;
}
