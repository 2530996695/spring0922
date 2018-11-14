package com.newer.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Emp implements Serializable {

    private Integer empno ;

    private String ename ;

    private String job ;

    private String sex ;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hiredate ;

    private double sal ;

    private double comm ;

    private Integer deptno ;

    private String dname ;

    private String loc ;

    public Integer getEmpno() {

        return empno;
    }

    public void setEmpno(Integer empno)
    {
        this.empno = empno;
    }

    public String getEname() {

        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {

        return job;
    }

    public void setJob(String job) {

        this.job = job;
    }

    public String getSex() {

        return sex;
    }

    public void setSex(String sex) {

        this.sex = sex;
    }

    public Date getHiredate() {

        return hiredate;
    }

    public void setHiredate(Date hiredate) {

        this.hiredate = hiredate;
    }

    public double getSal() {

        return sal;
    }

    public void setSal(double sal) {

        this.sal = sal;
    }

    public double getComm() {

        return comm;
    }

    public void setComm(double comm) {

        this.comm = comm;
    }

    public Integer getDeptno() {

        return deptno;
    }

    public void setDeptno(Integer deptno) {

        this.deptno = deptno;
    }

    public String getDname() {

        return dname;
    }

    public void setDname(String dname) {

        this.dname = dname;
    }

    public String getLoc() {

        return loc;
    }

    public void setLoc(String loc) {

        this.loc = loc;
    }
}
