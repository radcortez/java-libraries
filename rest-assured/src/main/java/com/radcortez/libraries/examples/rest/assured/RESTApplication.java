package com.radcortez.libraries.examples.rest.assured;

import com.sun.net.httpserver.HttpServer;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class RESTApplication {
    public static void main(String... args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/hello", exchange -> {
            List<NameValuePair> queryParameters =
                URLEncodedUtils.parse(exchange.getRequestURI(), StandardCharsets.UTF_8);

            String name = queryParameters.stream()
                                         .filter(nameValuePair -> nameValuePair.getName().equals("name"))
                                         .map(NameValuePair::getValue)
                                         .findFirst()
                                         .orElse("John Doe");

            String body = "Hello " + name + "!";
            exchange.sendResponseHeaders(200, body.length());
            exchange.getResponseBody().write(body.getBytes());
            exchange.getResponseBody().flush();
            exchange.getResponseBody().close();
        });

        server.start();
    }
}
