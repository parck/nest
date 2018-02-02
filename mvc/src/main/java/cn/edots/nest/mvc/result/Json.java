package cn.edots.nest.mvc.result;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.plaf.PanelUI;
import java.io.IOException;
import java.io.Serializable;

public class Json<T> implements Serializable {

    protected int code = 400;
    protected boolean success;
    protected T data;
    protected String message;

    public static Json SUCCESS;
    public static Json FAIL;
    public static Json FORBID;

    static {
        SUCCESS = new Json(200);
        FAIL = new Json(400);
        FORBID = new Json(405);
    }

    public Json() {
    }

    public Json(int code) {
        this.code = code;
        this.success = code == 200;
    }

    public Json(int code, T data, String message) {
        this.code = code;
        this.success = code == 200;
        this.data = data;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        String JSON = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            JSON = mapper.writeValueAsString(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JSON;
    }
}
