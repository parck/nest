package cn.edots.nest.mvc.result;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ParckLee.
 * @Company wemoons.com
 * @Date 2017/6/16.
 */
public class ResultModel implements Serializable {

    private static final long serialVersionUID = 2643091927525897895L;

    private static Map<String, Object> datas = new HashMap<String, Object>();
    public static ResultModel FAIL = new ResultModel("系统繁忙", 1404, false);
    public static ResultModel SUCCESS = new ResultModel(null);
    public static ResultModel MAP = new ResultModel(datas);
    public static ResultModel OBJECT = new ResultModel("", 1200, true);
    public static ResultModel REDIRECT = new ResultModel("", 1305, true);

    public ResultModel() {
    }

    public ResultModel(String message, int code, boolean success) {
        this.message = message;
        this.code = code;
        this.success = success;
    }

    public ResultModel(Object data) {
        this.message = "";
        this.code = 1200;
        this.success = true;
        this.data = data;
    }

    private String message = "系统繁忙";
    private int code = 1200;
    private boolean success = false;
    private Object data = null;
    private String url = "";

    public String getMessage() {
        return message;
    }

    public ResultModel setMessage(String message) {
        this.message = message;
        return this;
    }

    public int getCode() {
        return code;
    }

    public ResultModel setCode(int code) {
        this.code = code;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public ResultModel setUrl(String url) {
        this.url = url;
        return this;
    }

    public String setObject(Object data) {
        this.data = data;
        return this.toString();
    }

    public ResultModel put(String key, Object value) {
        datas.put(key, value);
        return this;
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