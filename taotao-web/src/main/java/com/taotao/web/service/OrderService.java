package com.taotao.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taotao.web.pojo.Order;

@Service
public class OrderService {

    @Autowired
    private ApiService apiService;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 创建订单返回订单号
     * 
     * @param order
     * @return
     */
    public String createOrder(Order order) {
        try {
            String url = "http://order.taotao.com/order/create";
            String json = MAPPER.writeValueAsString(order);
            String jsonData = this.apiService.doPostJson(url, json);
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            if (jsonNode.get("status").intValue() == 200) {
                return jsonNode.get("data").asText();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Order queryOrderById(String id) {
        try {
            String url = "http://order.taotao.com/order/query/" + id;
            String jsonData = this.apiService.doGet(url);
            return MAPPER.readValue(jsonData, Order.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
