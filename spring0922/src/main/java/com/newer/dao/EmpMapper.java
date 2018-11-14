package com.newer.dao;

import com.newer.pojo.Emp;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

//持久层注解
@Repository
public interface EmpMapper {
    @Select("select empno,ename,job,sex,hiredate,sal,comm,d.deptno,dname from emp e left join dept d on e.deptno=d.deptno")
    List<Emp> findAll();

    @Insert("insert into emp (ename,hiredate,sal,comm,deptno,job) values(#{ename},#{hiredate},#{sal},#{comm},#{deptno},#{job})")
    int addEmp(Emp emp);

    @Delete("delete from Emp where empno=#{empno}")
    int delEmp(Integer empno );

    @Select("select ename,job,sex,hiredate,sal,comm,deptno from emp where empno = #{empno}")
    Emp queryById(int id );

    @Update("update Emp set ename=#{ename},job=#{job},comm=#{comm},sal=#{sal} where empno=#{empno}")
    int updEmp(Emp emp);

    List<Emp> queryParam(@Param("beginDate")Date beginDate, @Param("endDate")Date endDate,@Param("ename")String ename);

    @Select("select deptno,dname from dept" )
    List<Emp> findDept();
}
