package cn.edu.lingnan.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Teacher {
    int tid;
    String tname;
    String tpassword;
    int tright;
    int tflag;
}
