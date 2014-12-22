package net.v4lproik.phishingplatform.mvc.models;

/**
 * Created by v4lproik on 21/12/14.
 */

public class Status {

    private int code;
    private String message;

    public Status() {
    }

    public Status(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

