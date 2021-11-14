package com.zackliu02.nio01;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        final String url = "http://localhost:8801";
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            System.out.println(response.body().string());
        }
    }
}
