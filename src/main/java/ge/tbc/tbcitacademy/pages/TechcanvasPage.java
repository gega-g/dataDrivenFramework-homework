package ge.tbc.tbcitacademy.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import ge.tbc.tbcitacademy.data.Constants;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TechcanvasPage {
    public SelenideElement firstnameField = $("input[value='First Name']");
    public SelenideElement lastnameField = $("input[value='Last Name']");
    public SelenideElement genderButton = $("input[name='gender']").parent();
    public SelenideElement deviceDropdown = $("select[name='model']");
    public SelenideElement address1Field = $("input[value='Address1']");
    public SelenideElement address2Field = $("input[value='Address2']");
    public SelenideElement cityField = $("input[value='City']");
    public SelenideElement contact1 = $("input[value='Contact1']");
    public SelenideElement contact2 = $("input[value='Contact2']");

    public TechcanvasPage navigateToTechCanvas(){
        open(Constants.TECHURL);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        return this;
    }

}
