package in.nilayshah.reflection;


public class Employee
{
    private int employeeId;
    private String firstName;
    private String lastName;
    private Department dept;
    
    public int getEmployeeId()
    {
        return employeeId;
    }
    public void setEmployeeId(int employeeId)
    {
        this.employeeId = employeeId;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public Department getDept()
    {
        return dept;
    }
    public void setDept(Department dept)
    {
        this.dept = dept;
    }

    
}
