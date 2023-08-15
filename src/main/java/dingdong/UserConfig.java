/*
package dingdong;

import java.util.HashMap;
import java.util.Map;

*/
/**
 * 用户信息
 * 通过小程序抓包购物车接口获取headers和body中的数据填入
 *//*

public class UserConfig {

    //收货地址id
    public static final String addressId = "61cdd81656d86b00013d021e";

    */
/**
     * 提前获取收货地址id 填写到addressId上 规则为该站点可送达的默认收货地址  如果没有请自行去APP中设置好再运行
     * 每天抢之前先允许一下此接口 确认登录信息是否有效 如果失效了重新抓一次包
     *//*

    public static void main(String[] args) {
        String addressId = Api.getAddressId();
        System.out.println("addressId：" + addressId);
    }

    */
/**
     * 抓包后参考项目中的image/headers.jpeg 把信息一行一行copy到下面 没有的key不需要复制
     *//*

    public static Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("ddmc-city-number", "0101");
        headers.put("ddmc-build-version", "2.82.0");
        headers.put("ddmc-device-id", "osP8I0XAxehO7JUYUypYnaP5TdiE");
        headers.put("ddmc-station-id", "5f0d8d4d8782cc000151d34e");//这个是站点id 请仔细检查和确认这个参数 进入小程序之后首页左上角是不是你所在的站点
        // 如果不是先选择好站点再抓包 不要把站点搞错了 否则不能下单
        headers.put("ddmc-channel", "applet");
        headers.put("ddmc-os-version", "[object Undefined]");
        headers.put("ddmc-app-client-id", "4");
        headers.put("cookie", "DDXQSESSID=4d94ed8e4fa9945a267000fab8e4530a");
        headers.put("ddmc-ip", "");
        headers.put("ddmc-longitude", "121.362963");
        headers.put("ddmc-latitude", "31.219111");
        headers.put("ddmc-api-version", "9.49.2");
        headers.put("ddmc-uid", "61cdd7b559e7120001bb6c54");
        headers.put("user-agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 15_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148 MicroMessenger/8.0.18(0x1800123c) NetType/WIFI Language/zh_CN");
        headers.put("referer", "https://servicewechat.com/wx1e113254eda17715/422/page-frame.html");
        return headers;
    }

    */
/**
     * 抓包后参考项目中的image/body.jpeg 把信息一行一行copy到下面 没有的key不需要复制
     *
     * 这里不能加泛型 有些接口是params  泛型必须要求<String,String> 有些是form表单 泛型要求<String,Object> 无法统一
     *//*

    public static Map getBody() {
        ///advert/getAd?uid=61cdd7b559e7120001bb6c54&
        // longitude=121.362963&latitude=31.219111&
        // station_id=5f0d8d4d8782cc000151d34e&city_number=0101
        // &api_version=9.49.1&app_version=2.81.4
        // &applet_source=&channel=applet&app_client_id=4
        // &sharer_uid=&s_id=4d94ed8e4fa9945a267000fab8e4530a
        // &openid=osP8I0XAxehO7JUYUypYnaP5TdiE&h5_source=&
        // device_token=WFWVc5eQ20p7KRo9sUbVoHTmS%2BadSblopNSTUguyRBD88Kk88%2FrQFH1x04NrBAcM98Pr8kZqXG%2FELo0Hf%2BBm5xwZRuf1aM1etLQ2FUPCwgjG%2Fw8gZjQgjCg%3D%3D1487577677129
        // &ad_id=5091%2C5092&nars=a744de176be79f0a60d22e48ac4856a3&sesi=BbFtMR3eeb0a18b927891dc436e40f729f0d603
        Map body = new HashMap<>();
        body.put("uid", "61cdd7b559e7120001bb6c54");
        body.put("longitude", "121.362963");
        body.put("latitude", "31.219111");
        body.put("station_id", "5f0d8d4d8782cc000151d34e");//这个是站点id 请仔细检查和确认这个参数 进入小程序之后首页左上角是不是你所在的站点 如果不是先选择好站点再抓包 不要把站点搞错了 否则不能下单
        body.put("city_number", "0101");
        body.put("api_version", "9.49.2");
        body.put("app_version", "2.82.0");
        body.put("applet_source", "");
        body.put("channel", "applet");
        body.put("app_client_id", "4");
        body.put("sharer_uid", "");
        body.put("openid", "osP8I0XAxehO7JUYUypYnaP5TdiE");
        body.put("h5_source", "");
        body.put("device_token", "WHJMrwNw1k/FKPjcOOgRd+C5Klb3PcmNKFY03X//QneEB6TQo+yR1ziCdHDm6lClQhR2IPV+um+BnvAJVjIpvhs2q0p23FZ5ddCW1tldyDzmauSxIJm5Txg==1487582755342");

        return body;
    }

}
*/
