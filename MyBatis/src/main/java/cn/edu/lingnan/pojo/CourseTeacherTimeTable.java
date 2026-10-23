package cn.edu.lingnan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseTeacherTimeTable implements Serializable {
    private String cid;
    private String cname;
    private int cflag;
    int tid;
    String tname;
    String tpassword;
    int tright;
    int tflag;
    private String classroom;
    private String classtime;
    private int ttflag;
}
