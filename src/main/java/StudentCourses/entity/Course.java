package StudentCourses.entity;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name="courses")
@NoArgsConstructor
public class Course implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private int modules;
    
    private double credits;
    
    private double fee;
    
    
    @ManyToMany(mappedBy="courses", fetch=FetchType.LAZY)
    private Set<Student> students = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    public Course(String name, int modules, double credits, double fee, Teacher teacher) {
        this.name = name;
        this.modules = modules;
        this.credits = credits;
        this.fee = fee;
        this.teacher = teacher;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Course other = (Course) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Course{" + "name=" + name + ", fee=" + fee + '}';
    }

    
}
