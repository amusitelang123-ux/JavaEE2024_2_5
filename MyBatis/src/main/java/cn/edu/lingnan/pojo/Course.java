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
public class Course implements Serializable {
    private String cid;
    private String cname;
    private int cflag;
}
