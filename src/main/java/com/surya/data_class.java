package com.surya;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class data_class {
    @Id
    private int reg_no;
    private String name;
    private String email;
    private int dd;
    private int mm;
    private int yyyy;
    private String gender;
    private String community;
    private String address;
    private String mobile_number;
    private String aadhar;
    public int getReg_no() {
        return reg_no;
    }
    public void setReg_no(int reg_no) {
        this.reg_no = reg_no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "data_class [reg_no=" + reg_no + ", name=" + name + ", email=" + email + ", dd=" + dd + ", mm=" + mm
                + ", yyyy=" + yyyy + ", gender=" + gender + ", community=" + community + ", address=" + address
                + ", mobile_number=" + mobile_number + ", aadhar=" + aadhar + ", getReg_no()=" + getReg_no()
                + ", getName()=" + getName() + ", getEmail()=" + getEmail() + ", getDd()=" + getDd() + ", getMm()="
                + getMm() + ", getYyyy()=" + getYyyy() + ", getGender()=" + getGender() + ", getCommunity()="
                + getCommunity() + ", getAddress()=" + getAddress() + ", getMobile_number()=" + getMobile_number()
                + ", getAadhar()=" + getAadhar() + "]";
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getDd() {
        return dd;
    }
    public void setDd(int dd) {
        this.dd = dd;
    }
    public int getMm() {
        return mm;
    }
    public void setMm(int mm) {
        this.mm = mm;
    }
    public int getYyyy() {
        return yyyy;
    }
    public void setYyyy(int yyyy) {
        this.yyyy = yyyy;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getCommunity() {
        return community;
    }
    public void setCommunity(String community) {
        this.community = community;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getMobile_number() {
        return mobile_number;
    }
    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }
    public String getAadhar() {
        return aadhar;
    }
    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }
}
