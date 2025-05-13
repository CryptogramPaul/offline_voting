/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votingsys;

public class studarray {
    int studid;
    String schoolid, fname,mname,lname,course,username,password, status;
    
    
    public studarray(int studid, String schoolid, String fname, String mname, String lname, String course,String username, String password, String status){
    this.studid = studid;
    this.schoolid = schoolid;
    this.fname = fname;
    this.mname = mname;
    this.lname = lname;
    this.course = course;
    this.username = username;
    this.password = password;
    this.status = status;
    }
    
    public int getstudid(){
    return studid;
    }
    
    public String getschoolid(){
    return schoolid;
    }
    public String getfname(){
    return fname;
    }
    public String getmname(){
    return mname;
    }
    public String getlname(){
    return lname;
    }
    public String getcourse(){
    return course;
    }
    public String getusername(){
    return username;
    }
    public String getpassword(){
    return password;
    }
    
    public String getstatus(){
    return status;
    }
}
