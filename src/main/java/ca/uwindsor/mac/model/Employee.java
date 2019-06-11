package ca.uwindsor.mac.model;



public class Employee {
	
	 private int id;
	    private String name;
	    private int age;
	    private String dept;
	    
	    public Employee()
	    {
	        super();
	    }

	    public Employee(int id, String name, int age, String dept)
	    {
	        super();
	        this.id = id;
	        this.name = name;
	        this.age = age;
	        this.dept = dept;
	    }
	    
	    public int getId()
	    {
	        return id;
	    }
	    public void setId(int id)
	    {
	        this.id = id;
	    }
	    
	    public String getName()
	    {
	        return name;
	    }
	    public void setName(String name)
	    {
	        this.name = name;
	    }
	    
	    public int getAge()
	    {
	        return age;
	    }
	    public void setAge(int age)
	    {
	        this.age = age;
	    }
	    
	    public String getDept()
	    {
	        return dept;
	    }
	    public void setDept(String dept)
	    {
	        this.dept = dept;
	    }
	    @Override
	    public String toString()
	    {
	        return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", dept=" + dept + "]";
	    }
	    
	    

}
