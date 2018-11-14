import com.newer.pojo.Emp;
import com.newer.service.EmpService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpTest {

    private EmpService empService ;

    @Before
    public void init(){
        ApplicationContext acx = new ClassPathXmlApplicationContext("applicationContext.xml");
        empService = acx.getBean("empService",EmpService.class);
    }

    @Test
    public void query(){
        for (Emp emp :empService.find()){
            System.out.println(emp.getEname());
        }
    }

   @Test
    public void addEmp(){
        Emp emp = new Emp();
        emp.setEname("五渐渐");
        emp.setDeptno(13);
        emp.setSal(10000);
        emp.setComm(1000);

        int skt = empService.addEmp(emp);
        System.out.println("受影响的行数："+skt);
    }

    @Test
    public void DelEmp(){
        int sk = empService.dleEmp(102);
        if (sk>0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

    @Test
    public void updEmp(){
        Emp emp = new Emp();
        emp.setEmpno(101);
        emp.setEname("安静");
        emp.setJob("工程师");
        emp.setComm(1000);

        int sk = empService.updEmp(emp);
        if (sk>0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }

    public void EmpById(){

    }


}
