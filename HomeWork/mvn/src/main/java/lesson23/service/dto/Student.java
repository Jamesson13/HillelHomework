package lesson23.service.dto;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * Class Student
 *
 * @author Oleksandr Storozhuk
 * @version 1.0.0
 * created on 15.06.2021
 *
 * DTO class to store information about Student.
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class Student {
    private int id;
    private String fullName;
    private int groupId;
    private int admYear;
    private boolean isDeleted;

    public Student(String fullName, int groupId, int admYear) {
        this.fullName = fullName;
        this.groupId = groupId;
        this.admYear = admYear;
    }
}
