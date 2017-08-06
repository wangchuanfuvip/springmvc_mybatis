package com.taotao.web.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taotao.common.spring.exetend.PropertyConfig;
import com.taotao.common.vo.TaotaoResult;
import com.taotao.web.pojo.User;

@Service
public class UserService {

    @Autowired
    private ApiService apiService;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @PropertyConfig
    private String SSO_TAOTAO;

    /**
     * 注册
     * 
     * @param username
     * @param password
     * @param phone
     * @return
     */
    public boolean doRegister(String username, String password, String phone) {
        String url = SSO_TAOTAO + "/user/register";
        Map<String, String> params = new HashMap<String, String>();
        params.put("username", username);
        params.put("password", password);
        params.put("phone", phone);
        try {
            String jsonData = this.apiService.doPost(url, params);
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            if (jsonNode.get("status").intValue() == 200) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 登录
     * 
     * @param username
     * @param password
     * @return
     */
    public String doLogin(String username, String password) {
        String url = SSO_TAOTAO + "/user/login";
        Map<String, String> params = new HashMap<String, String>();
        params.put("u", username);
        params.put("p", password);
        try {
            String jsonData = this.apiService.doPost(url, params);
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            if (jsonNode.get("status").intValue() == 200) {
                return jsonNode.get("data").asText();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public User queryUserByTicket(String ticket) {
        try {
            String url = SSO_TAOTAO + "/user/query/" + ticket;
            String jsonData = this.apiService.doGet(url);
            TaotaoResult taotaoResult = TaotaoResult.formatToPojo(jsonData, User.class);
            return (User) taotaoResult.getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
