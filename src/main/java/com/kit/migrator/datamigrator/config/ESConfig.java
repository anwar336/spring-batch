/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kit.migrator.datamigrator.config;

//import org.apache.http.Header;
//import org.apache.http.HttpHost;
//import org.apache.http.message.BasicHeader;
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestClientBuilder;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Base64;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.http.auth.AuthScope;
//import org.apache.http.auth.UsernamePasswordCredentials;
//import org.apache.http.client.CredentialsProvider;
//import org.apache.http.impl.client.BasicCredentialsProvider;
//import org.elasticsearch.client.RequestOptions;
//import org.elasticsearch.client.indices.CreateIndexRequest;
//import org.elasticsearch.client.indices.CreateIndexResponse;
//import org.elasticsearch.client.indices.GetIndexRequest;
//import org.elasticsearch.xcontent.XContentType;

/**
 *
 * @author USER
 */
//@Configuration
//@Slf4j
public class ESConfig {
/*
    @Value("${elastic.hosts}")
    private String hosts;

    @Value("${elastic.port}")
    private int port;

    @Value("${elastic.username}")
    private String username;

    @Value("${elastic.password}")
    private String password;

    @Bean
    public RestHighLevelClient client() throws Throwable {
        String[] esHosts = hosts.split(",");
        HttpHost[] oHosts = new HttpHost[esHosts.length];
        for (int i = 0; i < esHosts.length; i++) {
            String[] hostProto = esHosts[i].split("://");
            oHosts[i] = new HttpHost(hostProto[1], port, hostProto[0]);
        }
        RestClientBuilder builder = RestClient.builder(oHosts);

        final CredentialsProvider credentialsProvider
                = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials(username, password));
        builder.setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder
                .setDefaultCredentialsProvider(credentialsProvider));
        return new RestHighLevelClient(builder);
    }
    */
}
