
package interview.model;

public class PhoneData {
    private String phoneNumber;

    private Validity validity;
    
    public PhoneData(String phoneNumber, Validity validity) {
        this.phoneNumber = phoneNumber;
        this.validity = validity;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

   

    public Validity getValidity() {
        return validity;
    }

   
}
