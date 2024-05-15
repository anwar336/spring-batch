package com.kit.migrator.datamigrator.gateway;

import com.kit.migrator.datamigrator.gateway.model.MisRequestModel;
import com.kit.migrator.datamigrator.gateway.model.MisResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class MisGateway {

    @Autowired
    RestTemplate restTemplate;

    @Value("${mis.api.base.url}")
    private String baseUrl;

    @Value("${mis.api.auth.token}")
    private String authToken;

    public MisResponseModel syncData(MisRequestModel request){
        log.info("[{}]", request.toString());
        String url = baseUrl + "api/v1/addBeneficiarySNSOP";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + authToken);
        HttpEntity<MisRequestModel> httpRequest = new HttpEntity<>(request, headers);
        return restTemplate.postForObject(url, httpRequest, MisResponseModel.class);
    }

}
