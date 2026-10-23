package cn.edu.lingnan.demo01;

import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class Education {
    @Resource
    private Student student;
    @Autowired
    private  Teacher teacher;

    public void show(){
        teacher.doSomething();
        student.doSomething();
    }
}
