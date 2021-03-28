package edu.umb.cs680.hw04;

enum StudentStatus{ INSTATE,OUTSTATE,INTL}

public class Student {
    String name;
    int i20Srno;
    float tuitionfee;
    String USAddr;
    int yrsInState;
    String HomeCountryAddr;
    private StudentStatus status;

    private Student(float tuitionfee, String name, int i20Srno, String USAddr, int yrsInState,
                    String HomeCountryAddr, StudentStatus status)
    {
        this.tuitionfee=tuitionfee;
        this.name=name;
        this.i20Srno=i20Srno;
        this.USAddr=USAddr;
        this.yrsInState=yrsInState;
        this.HomeCountryAddr=HomeCountryAddr;
        this.status=status;
    }
    public static Student createInStateStudent(String name, String USAddr)
    {
        return new Student(0,name,0,USAddr,0,null,StudentStatus.INSTATE);

    }
    public static Student createOutStateStudent(String name, String USAddr,int yrsInState)
    {
        return new Student(0,name,0,USAddr,yrsInState,null,StudentStatus.OUTSTATE);

    }
    public static Student createIntlStudent(String name, String USAddr,int i20Srno,String HomeCountryAddr)
    {
        return new Student(0,name,i20Srno,USAddr,0,HomeCountryAddr,StudentStatus.INTL);

    }
    public float getTuitionfee() {
        return this.tuitionfee;
    }
    public String getName() {
        return this.name;
    }
    public int i20Srno() {
        return this.i20Srno;
    }
    public String getUsAddr() {
        return this.USAddr;
    }
    public int getYrsInState() {
        return this.yrsInState;
    }
    public String HomeCountryAddr() {
        return this.HomeCountryAddr;
    }
    public StudentStatus getStatus() {
        return this.status;
    }
    public static void main (String[] args)
    {
        Student s = createInStateStudent("Akshay", "Harbour Point");
    }
}
