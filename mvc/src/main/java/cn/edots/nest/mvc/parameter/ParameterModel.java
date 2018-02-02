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
