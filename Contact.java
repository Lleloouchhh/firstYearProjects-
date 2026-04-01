public class Contact {
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String sex;
    private int age;

    public Contact(){

    }

    public Contact(String firstName, String lastName, String address, String phoneNumber, String sex, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws IllegalArgumentException{
        if(firstName.isEmpty()||firstName==null){
            throw new IllegalArgumentException("First name cannot be empty.");
        }
        if(!firstName.matches("[a-zA-Z ]+")){
            throw new IllegalArgumentException("First name: must not contain numbers.");
        }

        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws IllegalArgumentException {
        if(lastName.isEmpty()||lastName==null){
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        if(!lastName.matches("[a-zA-Z ]+")){
            throw new IllegalArgumentException("Last name must not contain numbers.");
        }
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws IllegalArgumentException{
        if(address.isEmpty()||address==null){
            throw new IllegalArgumentException("Address cannot be Empty.");
        }

        if (!address.matches("[a-zA-Z0-9 ,.#/-]+")) {
            throw new IllegalArgumentException("Invalid address format.");

        }
        this.address = address;
    }

    public String getPhoneNumber() {


        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws IllegalArgumentException {
        if (phoneNumber.isEmpty()||phoneNumber==null){
            throw new IllegalArgumentException("Phone number cannot be empty.");
        }
        if(!phoneNumber.matches("\\d+")){
            throw new IllegalArgumentException("Phone number must contain digits only.");
        }
        if(!phoneNumber.matches("\\d{11}")){
            throw new IllegalArgumentException("Phone number must be 11 digits.");
        }
        if(!phoneNumber.matches("^09\\d{9}$")){
            throw new IllegalArgumentException("Invalid Phone Number! Format: 09XXXXXXXXX");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) throws IllegalArgumentException{
        if(sex==null){
            throw new IllegalArgumentException("Please select your sex.");

        }
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IllegalArgumentException{
        if(age<1||age>120) {
            throw new IllegalArgumentException("Invalid age range!");
        }
        this.age = age;
    }


}
