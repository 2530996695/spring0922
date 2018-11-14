package com.newer.service;

import com.newer.dao.EmpMapper;
import com.newer.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

//业务逻辑层注解
@Service
public class EmpService {

    //自动织入
    @Autowired
    private EmpMapper empMapper ;

    //查询方法
    public List<Emp> find(){

        return empMapper.findAll();
    }

    //添加方法
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    public int addEmp(Emp emp){
        return empMapper.addEmp(emp);
    }

    //删除方法
    public int dleEmp(Integer empno){

        return empMapper.delEmp(empno);
    }

    //修改方法

    @Transactional(propagation = Propagation.REQUIRED)
    public int updEmp(Emp emp){

        return empMapper.updEmp(emp);
    }

    //根据ID查询方法
    public Emp queryById(int id){

        return empMapper.queryById(id);
    }

    public List<Emp> queryParam(Date beginDate,Date endDate,String ename){

        return empMapper.queryParam(beginDate,endDate,ename);
    }

    public List<Emp> findDept(){
        return empMapper.findDept();
    }
}
