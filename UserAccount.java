public class UserAccount {
    private String name;
    private int age;
    private String email;
    private boolean isActive;



    public  UserAccount(String name,int age,String email,boolean isActive){
        this.name=name;
        this.email=email;
        this.age=age;
        this.isActive=isActive;

    }
    public void displayInfo() {
        System.out.println("User name:"+name);
        System.out.println("Email:"+email);
        System.out.println("User Age:"+age);
        System.out.println("Is user active:"+isActive);
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public int getAge(){
        return age;
    }
    public boolean getisActive(){
        return isActive;
    }
    public void setName(){
        String name=getName();
    }
    public void setEmail(){
        String email=getEmail();
    }
    public void setAge(){
        int age=getAge();
    }
    public void setIsActive(){
        boolean isActive=getisActive();
    }
}
