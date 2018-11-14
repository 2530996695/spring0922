package com.newer.controller;

import com.newer.pojo.Emp;
import com.newer.service.EmpService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class EmpController {

    //自动注入
    @Autowired
    private EmpService empService ;
    /**
     * 视图解析器
     * @return
     */

    @RequestMapping("openPage")
    public ModelAndView openPage(){
        //System.out.println("我进来了");
        //调用servcie层的方法
        ModelAndView mv = new ModelAndView();
        List<Emp> empList = empService.findDept();
        mv.setViewName("empedit");
        mv.addObject("empList",empList);

/*        if(empno!=null){

            Emp emp = empService.queryById(empno);
            mv.setViewName("empedit");
            mv.addObject("emp",emp);

        }else {
            mv.setViewName("empedit");
        }*/
        return mv;
    }
    @RequestMapping("updEmp")
    public ModelAndView updEmp(@RequestParam(name = "empno")Integer empno){
       ModelAndView mv = new ModelAndView();
       Emp emp = empService.queryById(empno);
        List<Emp> empList = empService.findDept();
        mv.addObject("emp",emp);
        mv.addObject("empList",empList);
        mv.setViewName("empedit");
        return mv;
    }


/*    @RequestMapping("empList")
    public ModelAndView query(){
        List<Emp> empList =  empService.find();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("list");
        mv.addObject("empList",empList);//返回模型数据
        return mv ;
    }*/

    @RequestMapping("empList")
    public ModelAndView query(
                              @RequestParam(name = "beginDate",required = false)@DateTimeFormat(pattern = "yyyy-MM-dd") Date beginDate,
                              @RequestParam(name = "endDate",required = false)@DateTimeFormat(pattern = "yyyy-MM-dd")Date endDate,
                              @RequestParam(name = "ename",required = false)String ename){
      List<Emp> empList =  empService.queryParam(beginDate,endDate,ename);
      ModelAndView mv = new ModelAndView();
      mv.setViewName("list");
      mv.addObject("empList",empList);//返回模型数据
        return mv ;
    }

    //删除
//    @RequestMapping("deleteByID")
    @RequestMapping(value ="deleteByID",method = RequestMethod.GET)
    public String delEmp(Integer empno){
        empService.dleEmp(empno);
        String str = "redirect:empList";//重定向到empList
        return str ;
    }

    //新增或修改
    @RequestMapping(value = "addOrUpdEmp",method = RequestMethod.POST)
    public String addOrUpdEmp(Emp emp){
        if(emp.getEmpno()!=null){
            empService.updEmp(emp);
        }else{
            emp.setHiredate(new Date());
            empService.addEmp(emp);
        }
        return "redirect:empList";  //重定向到empList请求中
    }

    @ResponseBody
    @RequestMapping("findDept")
    public List<Emp> findById() {
        List<Emp> empList = empService.findDept();
        return empList;
    }

    }
