package demo.dl;


import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "dl_application")
public class DLModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long application_id;

    
    private String name;
    private String mobile;
    private String address;
    private String test_slot;
    private Date test_date;


    
    public DLModel( String name, String mobile, String address, Date test_date,String test_slot) {
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.test_slot = test_slot;
        this.test_date = test_date;
    }

    public Long getApplication_id() {
        return application_id;
    }

    public void setApplication_id(Long application_id) {
        this.application_id = application_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTest_slot() {
        return test_slot;
    }

    public void setTest_slot(String test_slot) {
        this.test_slot = test_slot;
    }

    public Date getTest_date() {
        return test_date;
    }

    public void setTest_date(Date test_date) {
        this.test_date = test_date;
    }

    public DLModel() {
    }

    

    

}
