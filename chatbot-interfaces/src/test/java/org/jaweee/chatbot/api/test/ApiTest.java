package org.jaweee.chatbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
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

    @Test
    public void query_unanswered_question() throws IOException {
        // http客户端
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        //
        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/88885851885242/topics?scope=unanswered_questions&count=20");

        get.addHeader("cookie", "zsxq_access_token=C28EF4D4-9DAF-F8AD-6612-7A9E02298004_665307D65BEA119D; zsxqsessionid=5c3c358a258ab816c161db1e9563801e; abtest_env=beta; sensorsdata2015jssdkcross={\"distinct_id\":\"215515852114851\",\"first_id\":\"17bbf4ad513658-0891bbdfb156bd-7a6b0055-1296000-17bbf4ad514347\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"$device_id\":\"17bbf4ad513658-0891bbdfb156bd-7a6b0055-1296000-17bbf4ad514347\",\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTgxMzk5OTE5ZTJlZDktMGJjYzc3NjU3Y2E5ZjctNjQ0NzI2NGEtMjA3MzYwMC0xODEzOTk5MTllMzExODYiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIyMTU1MTU4NTIxMTQ4NTEifQ==\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"215515852114851\"}}");

        get.addHeader("Content-type", "application/json;charset=utf8");
        CloseableHttpResponse response = httpClient.execute(get);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

}
