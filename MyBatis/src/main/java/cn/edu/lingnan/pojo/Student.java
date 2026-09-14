package cn.edu.lingnan.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student implements Serializable {
    private String sid;
    private String sname;
    private String spassword;
    private int sright;
    private int sflag;
}


