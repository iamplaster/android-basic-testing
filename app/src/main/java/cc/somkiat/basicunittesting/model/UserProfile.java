package cc.somkiat.basicunittesting.model;


import cc.somkiat.basicunittesting.EmailValidation;
import cc.somkiat.basicunittesting.NameValidation;

public class UserProfile {
    private String name;
    private String email;
    private String report = "";
    private NameValidation nameValidation;
    private EmailValidation emailValidation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(nameValidation.includeAllCheck(name)) {
            this.name = name;
            report += "Name: " + name + ", ";
        }else{
            report += "Name not valid, ";
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(emailValidation.includeCheck(email)){
            this.email = email;
            report += "Email: " + email + " [COMPLETE]";
        }else{
            report += "Email not valid";
        }
    }
    public String getReport(){
        return report;
    }
    public void clearReport(){
        report = "";
    }
    public void setChecker(NameValidation nameValidation, EmailValidation emailValidation){
        this.nameValidation = nameValidation;
        this.emailValidation = emailValidation;
    }
}
