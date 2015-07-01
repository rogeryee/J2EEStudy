package com.yee.study.jersey;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;


/**
 * Author: RogerYee
 */
public class RestfulServiceAuthorizationTest
{

    public static void main(String [] args) throws Exception
    {
        String name = "rogeryee";
        String password = "12345678";
        String authString = name + ":" + password;
        String authStringEnc = new BASE64Encoder().encode(authString.getBytes());
        System.out.println("Base64 encoded auth string: " + authStringEnc);

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8888/jersey/services/json/jaxb");
        Response response = target
                .request()
                .header("Authorization", authStringEnc)
                .get();
        System.out.println("response: "+ response.readEntity(String.class));
        response.close();

        String key = "AB487CA53162B396EA5142F6";

        String inputs = "username is rogeryee";

        String signature = HMACSHA1Util.getSignature(inputs, key);

        System.out.println("signature = " + signature);
    }
}

class HMACSHA1Util
{
    private static final String HMAC_SHA1 = "HmacSHA1";

    /**
     * 生成签名数据
     *
     * @param data 待加密的数据
     * @param key  加密使用的key
     */
    public static String getSignature(String data,String key) throws Exception{
        byte[] keyBytes=key.getBytes();
        SecretKeySpec signingKey = new SecretKeySpec(keyBytes, HMAC_SHA1);
        Mac mac = Mac.getInstance(HMAC_SHA1);
        mac.init(signingKey);
        byte[] rawHmac = mac.doFinal(data.getBytes());
        StringBuilder sb=new StringBuilder();
        for(byte b:rawHmac){
            sb.append(byteToHexString(b));
        }
        return sb.toString();
    }

    private static String byteToHexString(byte ib){
        char[] Digit={
                '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'
        };
        char[] ob=new char[2];
        ob[0]=Digit[(ib>>>4)& 0X0f];
        ob[1]=Digit[ib & 0X0F];
        String s=new String(ob);
        return s;
    }

}
