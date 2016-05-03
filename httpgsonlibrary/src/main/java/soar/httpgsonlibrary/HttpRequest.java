package soar.httpgsonlibrary;

import android.content.Context;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

/**
 * Created by gaofei on 2016/4/29.
 */
public class HttpRequest {

    private static AsyncHttpClient client = null;

    public static AsyncHttpClient getInstance(){

        if(client == null){
            client = new AsyncHttpClient();
        }
        return client;
    }

    public static <T> T requestGet(final Class<T> tClass , Context context , final RequestListener listener , RequestParams params){

        RequestParams paramss = new RequestParams();
        params.add("name", "黄豆猪脚汤");

            getInstance().get(context, "http://www.tngou.net/api/cook/name",params ,new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    Gson gson = new Gson();
                    listener.ok(gson.fromJson(new String(responseBody) , tClass));
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                }
            });

        return null;
    }

    public static <T> T requestPost(final Class<T> tClass , Context context , final RequestListener listener , RequestParams params){
        getInstance().get(context, "http://www.tngou.net/api/cook/name", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Gson gson = new Gson();
                listener.ok(gson.fromJson(new String(responseBody), tClass));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            }
        });

        return null;
    }




}
