package com.example.demo;

import org.apache.http.HttpResponse;
import org.springframework.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
/**
 * @program: bootdemo
 * @description:
 * @author: linxiaojiu
 * @create: 2018/11/11
 **/
public class Jiqiren {

    public static void main(String args[]) throws Exception{

         String WEBHOOK_TOKEN = "https://oapi.dingtalk.com/robot/send?access_token=08e883ffb1de18ddd62249446da6dc4b98deadd6fe258cdda2b825d7c6cf1065";

        HttpClient httpclient = HttpClients.createDefault();

        HttpPost httppost = new HttpPost(WEBHOOK_TOKEN);
        httppost.addHeader("Content-Type", "application/json; charset=utf-8");

        String textMsg = "{ \"msgtype\": \"text\", \"text\": {\"content\": \"我就是我, 是不一样的烟火\"}}";
        StringEntity se = new StringEntity(textMsg, "utf-8");
        httppost.setEntity(se);

        HttpResponse response = httpclient.execute(httppost);
        if (response.getStatusLine().getStatusCode()== 200){
            String result= EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(result);
        }
    }
}
