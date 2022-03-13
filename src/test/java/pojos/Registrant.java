package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Registrant {

    /*
        {
            "activated":true,
            "authorities": [
                "string"
             ],
            "createdBy":"string",
            "createdDate":"2022-01-83T19:25:02.075Z",
            "email":"string",
            "firstName" :"string",
            "id":0,
            "imageUrl":"string",
            "langKey":"string",
            "lastModifiedBy":"string",
            "lastModifiedDate":"2022-01-03T19:25:02.075Z",
            "lastName" :"string",
            "login":"string",
            "password":"string",
            "ssn":"string"
        }
     */

    private boolean activated;
    private String createdData;
    private String email;
    private String firstName;
    private int id;
    private String langKey;
    private String lastModifiedBy;
    private String getLastModifiedDate;
    private String lastName;
    private String login;
    private String password;
    private String ssn;

    public Registrant() {
    }

    public Registrant(boolean activated, String createdData, String email, String firstName, int id, String langKey, String lastModifiedBy, String getLastModifiedDate, String lastName, String login, String password, String ssn) {
        this.activated = activated;
        this.createdData = createdData;
        this.email = email;
        this.firstName = firstName;
        this.id = id;
        this.langKey = langKey;
        this.lastModifiedBy = lastModifiedBy;
        this.getLastModifiedDate = getLastModifiedDate;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.ssn = ssn;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getCreatedData() {
        return createdData;
    }

    public void setCreatedData(String createdData) {
        this.createdData = createdData;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLangKey() {
        return langKey;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getGetLastModifiedDate() {
        return getLastModifiedDate;
    }

    public void setGetLastModifiedDate(String getLastModifiedDate) {
        this.getLastModifiedDate = getLastModifiedDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "Registrant{" +
                "activated=" + activated +
                ", createdData='" + createdData + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id=" + id +
                ", langKey='" + langKey + '\'' +
                ", lastModifiedBy='" + lastModifiedBy + '\'' +
                ", getLastModifiedDate='" + getLastModifiedDate + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}
