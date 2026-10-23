package cn.edu.lingnan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseExtend extends  Course {
    private Teacher teacher;
    private TimeTable timeTable;

    @Override
    public String toString() {
        return "CourseExtend{" + super.toString() +
                "teacher=" + teacher +
                ", timeTable=" + timeTable +
                '}';
    }
}
