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
public class TimeTable implements Serializable {
    private int tid;
    private String cid;
    private String classroom;
    private String classtime;
    private int ttflag;
}
