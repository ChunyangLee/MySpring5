package com.lcy.bean;

public class Emp {
    private String name;
    private String gender;

    private Dep dep;    //员工所属的部门

    public Dep getDep() {
        return dep;
    }

    public void setDep(Dep dep) {
        System.out.println("emp setDep");
        this.dep = dep;
    }

    public String getName() {
        return name;
    }

    public Emp() {
        System.out.println("emp 空参构造器！");
    }

    public void setName(String name) {
        System.out.println("emp setName");
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dep=" + dep +
                '}';
    }

    public void init(){
        System.out.println("emp init!");
    }
    public void destroy(){
        System.out.println("emp destroy");
    }
}
