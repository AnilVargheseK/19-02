
package com.service.notisfo;

import com.util.notisfo.Util;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.util.notisfo.PropertiesLoader;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.JSONException;
import org.json.JSONObject;

public class TokenService {
    
//    PropertiesLoader.

    private static final String GRANT_TYPE_URL_DATA = "grant_type=client_credentials";

    public String login() throws IOException, Exception {

        String authorization = Util.getTokenAuthorization();
        String nonce = Util.getinstance().getNonce();

//        String tokenRequestHost = "www.devconnect2nse.com";
        String tokenRequestHost = PropertiesLoader.getProperty("token.host");
        String tokenRequestEndpoint = PropertiesLoader.getProperty("token.endpoint");
        String tokenRequestContentType = "application/x-www-form-urlencoded";
        String urlString = "https://" + tokenRequestHost + tokenRequestEndpoint;
        System.out.println(urlString);

        URL url = new URL(urlString);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {

                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(
                        java.security.cert.X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(
                        java.security.cert.X509Certificate[] certs, String authType) {
                }
            }
        };
        try {
            SSLContext sc = SSLContext.getInstance("TLSv1.2");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", tokenRequestContentType);
        connection.setRequestProperty("Authorization", authorization);
        connection.setRequestProperty("nonce", nonce);

        byte[] postData = GRANT_TYPE_URL_DATA.getBytes(StandardCharsets.UTF_8);

        int postDataLength = postData.length;
        connection.setRequestProperty("charset", "utf-8");
        connection.setRequestProperty("Content-Length", Integer.toString(postDataLength));
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            os.write(postData);
            os.flush();
            os.close();
            // For POST only - END
        }

        int responseCode = connection.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);
        String postTokenRequest = postTokenRequest(connection);
        return postTokenRequest;
        //     return null;
    }

    private String postTokenRequest(HttpsURLConnection connection) {

        String input;
        String accessToken = "";
        StringBuffer sb = new StringBuffer();
        if (connection != null) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((input = br.readLine()) != null) {
                    sb = sb.append(input);
                    System.out.println("data recived :" + input);
                }
                br.close();
                JSONObject j = new JSONObject(sb.toString());
                System.out.println("Json response :" + j);

                System.out.println("access_token :" + j.getString("access_token"));
                System.out.println("token_type :" + j.getString("token_type"));
                System.out.println("expires_in :" + j.getString("expires_in"));
                accessToken = j.getString("access_token");
              
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException ex) {
                Logger.getLogger(TokenService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return accessToken;
    }
}
