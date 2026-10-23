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
public class Score implements Serializable {
    private String sid;
    private String cid;
    private int score;
    private int scflag;
}
