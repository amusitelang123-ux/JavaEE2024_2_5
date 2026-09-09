package cn.edu.lingnan.pojo;

public class Student {
    private String sid;
    private String sname;
    private String spassword;
    private int sright;
    private int sflag;

    public Student() {
    }

    public Student(String sid, String sname, String spassword, int sright, int sflag) {
        this.sid = sid;
        this.sname = sname;
        this.spassword = spassword;
        this.sright = sright;
        this.sflag = sflag;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public int getSflag() {
        return sflag;
    }

    public void setSflag(int sflag) {
        this.sflag = sflag;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    public int getSright() {
        return sright;
    }

    public void setSright(int sright) {
        this.sright = sright;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", spassword='" + spassword + '\'' +
                ", sright=" + sright +
                ", sflag=" + sflag +
                '}';
    }
}


