package com.blank.ymcbox.Util;
import com.blank.ymcbox.Bean.Player;
import com.google.gson.Gson;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import android.util.Base64;
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


public class SkinUtils {
	static String url;
	static String base64Url;
	static final Gson gson=new Gson();
	static final OkHttpClient client=new OkHttpClient.Builder().sslSocketFactory(createSSLSocketFactory()).hostnameVerifier(new TrustAllHostname()).build();
 	static String uuid;
	public static String getUUID(String id){
		Request request=new Request.Builder().url("https://api.mojang.com/users/profiles/minecraft/"+id).build();
		Call call=client.newCall(request);
		call.enqueue(new Callback(){
				@Override
				public void onFailure(Call p1, IOException p2) {
				}
				@Override
				public void onResponse(Call p1, Response p2) throws IOException {
					String uuid0=p2.body().string();
					if(!uuid0.isEmpty()){
					uuid=gson.fromJson(uuid0,Player.class).getId();
				}}
			});
		return uuid;
	}
    
	
	public static String getUrl(String uuid){
		Request request=new Request.Builder().url("https://sessionserver.mojang.com/session/minecraft/profile/"+uuid).build();
		Call call=client.newCall(request);
		call.enqueue(new Callback(){
				@Override
				public void onFailure(Call p1, IOException p2) {
				}
				@Override
				public void onResponse(Call p1, Response p2) throws IOException {
					String s=p2.body().string();
					base64Url=gson.fromJson(s,Player.PlayerProperties.class).getProperties().get(0).getValue();
					url=(new Gson()).fromJson(new String(Base64.decode(base64Url,1)),Player.PlayerTextures.class).getTextures().getSKIN().getUrl();
				}
			});
			return url;
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
