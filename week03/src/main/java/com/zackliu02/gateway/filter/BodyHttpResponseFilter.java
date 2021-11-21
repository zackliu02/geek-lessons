package com.zackliu02.gateway.filter;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.FullHttpResponse;

public class BodyHttpResponseFilter implements HttpResponseFilter {
    @Override
    public void filter(FullHttpResponse response) {
        ByteBuf buf = response.content();
        for (int i = 0; i < buf.array().length; i++) {
            byte b = buf.getByte(i);
            if (b >= 'a' && b <= 'z') {
                buf.setByte(i, Character.toUpperCase(b));
            }
        }
        response.replace(buf);
    }
}
