/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kit.migrator.datamigrator.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;


/**
 *
 * @author USER
 */

public class ESConfig {
    
    @Value("${elastic.host}")
    private static String host;

    @Value("${elastic.port}")
    private static int port;

    private static ESConfig esClient = null;
    private static ElasticsearchClient client = null;
    private ESConfig() {
    }

    public static ElasticsearchClient instance() {
        if (esClient == null) {
            esClient = new ESConfig();
            client = esClient.init();
        }
        return client;
    }

    private static ElasticsearchClient init() {
        RestClient restClient = RestClient.builder(
                new HttpHost(host, port)).build();

        // Create the transport with a Jackson mapper
        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());

        // And create the API client
        return new ElasticsearchClient(transport);
    }
}
