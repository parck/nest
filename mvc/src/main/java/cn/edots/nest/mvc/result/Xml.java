package cn.edots.nest.mvc.result;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Xml<T> implements Serializable {

    protected int code = 400;
    protected boolean success;
    protected T data;
    protected String message;
    protected String token;
    protected String command;

    public Xml() {
    }

    public Xml(int code, String message) {
        this.code = code;
        this.success = code == 200;
        this.message = message;
        this.data = null;
    }

    public Xml(int code, T data, String message) {
        this.code = code;
        this.success = code == 200;
        this.data = data;
        this.message = message;
    }

    public static Xml SUCCESS() {
        return new Xml(200, "OK");
    }

    public static Xml FAIL(String message) {
        return new Xml(400, message);
    }

    public static Xml EXPIRES() {
        return new Xml(401, "登录过期");
    }

    public static Xml FORBID(String message) {
        return new Xml(403, message);
    }

    @XmlElement
    public String getMessage() {
        return message;
    }

    public Xml setMessage(String message) {
        this.message = message;
        return this;
    }

    @XmlElement
    public int getCode() {
        return code;
    }

    public Xml setCode(int code) {
        this.code = code;
        return this;
    }

    @XmlElement
    public boolean isSuccess() {
        return success;
    }

    public Xml setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    @XmlElement
    public T getData() {
        return data;
    }

    public Xml setData(T data) {
        this.data = data;
        return this;
    }

    @XmlElement
    public String getToken() {
        return token;
    }

    public Xml setToken(String token) {
        this.token = token;
        return this;
    }

    @XmlElement
    public String getCommand() {
        return command;
    }

    public Xml setCommand(String command) {
        this.command = command;
        return this;
    }
}
