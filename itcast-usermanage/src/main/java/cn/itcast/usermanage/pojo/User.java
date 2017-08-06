package cn.itcast.usermanage.pojo;

import java.util.Date;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User implements java.io.Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String userName;
    @JsonIgnore//序列化json数据时忽略该字段
    private String password;
    private String name;
    private Integer age;
    private Boolean sex;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;
    private Date created;
    private Date updated;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Boolean getSex() {
        return sex;
    }
    public void setSex(Boolean sex) {
        this.sex = sex;
    }
    public Date getBirthday() {
        return birthday;
    }
    public String getBirthdayStr() {
        if(getBirthday() == null){
            return null;
        }
        //格式化输出
        return new DateTime(getBirthday()).toString("yyyy-MM-dd");
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    public Date getUpdated() {
        return updated;
    }
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", name=" + name
                + ", age=" + age + ", sex=" + sex + ", birthday=" + birthday + ", created=" + created
                + ", updated=" + updated + "]";
    }

}
