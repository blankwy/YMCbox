package com.blank.ymcbox.Util;
import com.blank.ymcbox.Bean.ServerBean;
import com.google.gson.Gson;
import java.io.IOException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.SSLContext;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.TrustManager;
import java.security.SecureRandom;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;
import java.security.cert.CertificateException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ServerUtils {
    static ServerBean server=new ServerBean();
    public static ServerBean ping(String host,String port){
		String url="https://motdbe.blackbe.xyz/api?host="+host+"&port="+port;
		OkHttpClient client=new OkHttpClient.Builder().build();
		Request request=new Request.Builder().url(url).build();
		Call call=client.newCall(request);
		call.enqueue(new Callback(){
				@Override
				public void onFailure(Call p1, IOException p2) {
				}
				@Override
				public void onResponse(Call p1, Response p2) throws IOException {
					String json=p2.body().string();
					try{
					server=(new Gson()).fromJson(json,ServerBean.class);
					}catch(Exception e){
						server.setStatus("失败");
					}
				}
			});
		return server;
	}
    private static class TrustAllHostname implements HostnameVerifier {
		@Override
		public boolean verify(String p1, SSLSession p2) {
			return true;
		}
	}

	private static SSLSocketFactory createSSLSocketFactory(){
		SSLSocketFactory ssf=null;
		try {
			SSLContext sc=SSLContext.getInstance("TLS");
			sc.init(null,new TrustManager[]{new TrustAllCerts()},new SecureRandom());
			ssf=sc.getSocketFactory();
		} catch (Exception e) {}
		return ssf;
	}

	private static class TrustAllCerts implements X509TrustManager {
		@Override
		public void checkClientTrusted(X509Certificate[] p1, String p2)  {
		}

		@Override
		public void checkServerTrusted(X509Certificate[] p1, String p2)  {
		}
		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return new X509Certificate[0];
		}
	}
	
}
