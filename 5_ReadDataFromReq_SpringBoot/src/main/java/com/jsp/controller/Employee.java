package com.jsp.controller;

public class Employee {
private int eid;
private String name;
private double salary;
private boolean ispresnt;
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public boolean isIspresnt() {
	return ispresnt;
}
public void setIspresnt(boolean ispresnt) {
	this.ispresnt = ispresnt;
}
@Override
public String toString() {
	return "Employee [eid=" + eid + ", name=" + name + ", salary=" + salary + ", ispresnt=" + ispresnt + "]";
}


}
