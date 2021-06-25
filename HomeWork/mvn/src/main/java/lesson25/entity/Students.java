package lesson25.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * @author Oleksandr Storozhuk
 * @version 1.0.0
 * created on 25.06.2021
 */
@Entity
@Table(name = "Students")
@Setter
@Getter
@Accessors(chain = true)
@ToString
public class Students {
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private int id;

    @Column(name = "FullName")
    private String fullName;

    @ManyToOne
    @JoinColumn(name="GroupId")
    private StudyGroups group;

    @Column(name = "AdmYear")
    private int admYear;

    @Column(name = "IsDeleted")
    private boolean isDeleted;
}