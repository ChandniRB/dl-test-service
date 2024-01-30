package demo.dl;


import java.sql.Date;
import java.util.UUID;

public class DLResultModel {
    private UUID applicationid;
    private String name;
    private String mobile;
    private String address;
    private String test_slot;
    private Date test_date;
    private String test_status;
    

    
    

    public DLResultModel( String name, String mobile, String address, Date test_date,String test_slot) {
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.test_slot = test_slot;
        this.test_date = test_date;
    }

    public UUID getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(UUID applicationid) {
        this.applicationid = applicationid;
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

    public String getTest_status() {
        return test_status;
    }

    public void setTest_status(String test_status) {
        this.test_status = test_status;
    }
    public DLResultModel() {
    }

    

    

}
