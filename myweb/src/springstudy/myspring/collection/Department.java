package springstudy.myspring.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by 16643 on 2018/7/21.
 */
public class Department {
    private String departName;
    private String [] employeeName;
    private List<Employee> empList;
    private Set<Employee> empSet;
    private Map<Integer,Employee> empMap;

    public Map<Integer, Employee> getEmpMap() {
        return empMap;
    }

    public void setEmpMap(Map<Integer, Employee> empMap) {
        this.empMap = empMap;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String[] getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String[] employeeName) {
        this.employeeName = employeeName;
    }

    public List<Employee> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Employee> empList) {
        this.empList = empList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departName='" + departName + '\'' +
                ", employeeName=" + Arrays.toString(employeeName) +
                ", empList=" + empList +
                ", empSet=" + empSet +
                ", empMap=" + empMap +
                '}';
    }

    public Set<Employee> getEmpSet() {
        return empSet;
    }

    public void setEmpSet(Set<Employee> empSet) {
        this.empSet = empSet;
    }

}
