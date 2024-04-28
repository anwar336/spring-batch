package com.kit.migrator.datamigrator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kit.migrator.datamigrator.dto.BeneficiaryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;

import java.util.List;
//import org.elasticsearch.action.admin.indices.refresh.RefreshRequest;
//import org.elasticsearch.action.index.IndexRequest;
//import org.elasticsearch.action.index.IndexResponse;
//import org.elasticsearch.client.RequestOptions;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.elasticsearch.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class BeneficiaryESWriter implements ItemWriter<BeneficiaryDto> {

    //@Autowired
    //private RestHighLevelClient client;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void write(List<? extends BeneficiaryDto> beneficiaryList) throws Exception {
        beneficiaryList.forEach(b -> {
            log.info(" >>> " + b.getApplicationId());
//            try {
//                IndexRequest indexRequest = new IndexRequest("index_beneficiary");
//                    indexRequest.id(b.getApplicationId());
//                indexRequest.source(this.objectMapper.writeValueAsString(b), XContentType.JSON);
//                IndexResponse response = this.client.index(indexRequest, RequestOptions.DEFAULT);
//                log.info("==INDEX RESULT:{}", response.status());
//                this.client.indices().refresh(new RefreshRequest("index_beneficiary"), RequestOptions.DEFAULT);
//            } catch (Throwable t) {
//                log.error("", t);
//            }
        });

    }
}
