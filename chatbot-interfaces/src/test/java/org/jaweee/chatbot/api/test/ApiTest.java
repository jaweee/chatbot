package org.jaweee.chatbot.api.test;

<<<<<<< HEAD
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
=======
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
>>>>>>> 23_jaweee_zsxq_api
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2023/2/23 18:59
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
public class ApiTest {

<<<<<<< HEAD
=======
    @Test
    public void query_unanswered_question() throws IOException {
        // 建立http客户端
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 设置url，id等参数在url上设置
        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/88885851885242/topics?scope=unanswered_questions&count=20");
        // 设置头
        get.addHeader("cookie", "zsxq_access_token=C28EF4D4-9DAF-F8AD-6612-7A9E02298004_665307D65BEA119D; zsxqsessionid=5c3c358a258ab816c161db1e9563801e; abtest_env=beta; sensorsdata2015jssdkcross={\"distinct_id\":\"215515852114851\",\"first_id\":\"17bbf4ad513658-0891bbdfb156bd-7a6b0055-1296000-17bbf4ad514347\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"$device_id\":\"17bbf4ad513658-0891bbdfb156bd-7a6b0055-1296000-17bbf4ad514347\",\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTgxMzk5OTE5ZTJlZDktMGJjYzc3NjU3Y2E5ZjctNjQ0NzI2NGEtMjA3MzYwMC0xODEzOTk5MTllMzExODYiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIyMTU1MTU4NTIxMTQ4NTEifQ==\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"215515852114851\"}}");
        get.addHeader("Content-type", "application/json;charset=utf8");
        // 执行请求，返回响应消息
        CloseableHttpResponse response = httpClient.execute(get);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        // 建立http客户端
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 获取post对象
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/412884248251548/answer");
        // 设置post头
        post.addHeader("cookie", "__cuid=5330a556392a4c5b8084b4cbc165e0f3; amp_fef1e8=930aec23-e22e-4f11-8864-0389bd5095d1R...1g55hl79m.1g55hl79t.1.1.2; UM_distinctid=183e61195d535b-0bddac94679c75-19525635-1aeaa0-183e61195d7c52; sensorsdata2015jssdkcross={\"distinct_id\":\"241858242255511\",\"first_id\":\"17ebd0b4317ecb-0b27f672c2d3af-133a6253-1296000-17ebd0b4318ba7\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"$device_id\":\"17ebd0b4317ecb-0b27f672c2d3af-133a6253-1296000-17ebd0b4318ba7\",\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTgwMmQ2YjZiOWIxZjMtMGQ4YzMzZjhmYTA3YmEtMzU3MzZhMDMtMTI5NjAwMC0xODAyZDZiNmI5YzEwODYiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIyNDE4NTgyNDIyNTU1MTEifQ==\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"241858242255511\"}}; abtest_env=product; zsxqsessionid=8fae9a083a4874ab833c2158a44deb82; zsxq_access_token=5D862869-1229-A9B6-1BC1-C662EC4B16DD_D625BA7FD9CBBDFA");
        post.addHeader("Content-Type", "application/json;charset=utf8");
        // 设置post所携带的内容json值
        String json = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"自己去百度！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";
        StringEntity stringEntity = new StringEntity(json, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);
        // 获取响应消息
        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void testHutoolHttp() {
        String s = HttpUtil.get("https://api.zsxq.com/v2/groups/88885851885242/topics?scope=unanswered_questions&count=20");
        System.out.println(s);

        String s2 = HttpRequest.get("https://api.zsxq.com/v2/groups/88885851885242/topics?scope=unanswered_questions&count=20")
                .header(Header.CONTENT_TYPE, "application/json;charset=utf8")
                .header(Header.COOKIE, "zsxq_access_token=C28EF4D4-9DAF-F8AD-6612-7A9E02298004_665307D65BEA119D; zsxqsessionid=5c3c358a258ab816c161db1e9563801e; abtest_env=beta; sensorsdata2015jssdkcross={\"distinct_id\":\"215515852114851\",\"first_id\":\"17bbf4ad513658-0891bbdfb156bd-7a6b0055-1296000-17bbf4ad514347\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"$device_id\":\"17bbf4ad513658-0891bbdfb156bd-7a6b0055-1296000-17bbf4ad514347\",\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTgxMzk5OTE5ZTJlZDktMGJjYzc3NjU3Y2E5ZjctNjQ0NzI2NGEtMjA3MzYwMC0xODEzOTk5MTllMzExODYiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIyMTU1MTU4NTIxMTQ4NTEifQ==\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"215515852114851\"}}")
                .execute().body();
        System.out.println(s2);

        String json = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"自己去百度！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        String s3 = HttpRequest.post("https://api.zsxq.com/v2/topics/412884248251548/answer")
                .header(Header.CONTENT_TYPE, "application/json;charset=utf8")
                .header(Header.COOKIE, "__cuid=5330a556392a4c5b8084b4cbc165e0f3; amp_fef1e8=930aec23-e22e-4f11-8864-0389bd5095d1R...1g55hl79m.1g55hl79t.1.1.2; UM_distinctid=183e61195d535b-0bddac94679c75-19525635-1aeaa0-183e61195d7c52; sensorsdata2015jssdkcross={\"distinct_id\":\"241858242255511\",\"first_id\":\"17ebd0b4317ecb-0b27f672c2d3af-133a6253-1296000-17ebd0b4318ba7\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"$device_id\":\"17ebd0b4317ecb-0b27f672c2d3af-133a6253-1296000-17ebd0b4318ba7\",\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTgwMmQ2YjZiOWIxZjMtMGQ4YzMzZjhmYTA3YmEtMzU3MzZhMDMtMTI5NjAwMC0xODAyZDZiNmI5YzEwODYiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIyNDE4NTgyNDIyNTU1MTEifQ==\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"241858242255511\"}}; abtest_env=product; zsxqsessionid=8fae9a083a4874ab833c2158a44deb82; zsxq_access_token=5D862869-1229-A9B6-1BC1-C662EC4B16DD_D625BA7FD9CBBDFA")
                .body(json)
                .execute().body();
        System.out.println(s3);
    }

    @Test
    public void testRestTemplate() {

    }
>>>>>>> 23_jaweee_zsxq_api
}
