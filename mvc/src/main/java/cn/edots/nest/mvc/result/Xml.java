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

    public Xml() {
    }

    public Xml(int code) {
        this.code = code;
        this.success = code == 200;
    }

    public Xml(int code, T data, String message) {
        this.code = code;
        this.success = code == 200;
        this.data = data;
        this.message = message;
    }

    @XmlElement
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @XmlElement
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @XmlElement
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @XmlElement
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
