package cn.edots.nest.mvc.parameter;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;

/**
 * @Author ParckLee.
 * @Company wemoons.com
 * @Date 2017/6/17.
 */
public class ParameterModel implements Serializable {

    private static final long serialVersionUID = 8451098364352725403L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        String JSON = null;
        try {
            JSON = objectMapper.writeValueAsString(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JSON;
    }
}
