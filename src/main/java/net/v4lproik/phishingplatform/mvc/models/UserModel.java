package net.v4lproik.phishingplatform.mvc.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.persistence.*;

/**
 * Created by v4lproik on 19/12/14.
 */
@Entity
@Table(name = "user")
public class UserModel {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "cookie")
    private String cookie;

    @Column(name = "fromip")
    private String fromIp;

    @Column(name = "useragent")
    private String userAgent;


    public UserModel() {
        // Empty constructor for hibernate
    }

    public UserModel(String login, String password) {
        // Empty constructor for hibernate
    }

    public UserModel(String login) {
        this.login = login;
    }

    public Long getId() {
        return id;
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

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public String getFromIp() {
        return fromIp;
    }

    public void setFromIp(String fromIp) {
        this.fromIp = fromIp;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        return gson.toJson(this);
    }
}
