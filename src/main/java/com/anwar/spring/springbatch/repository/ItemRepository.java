/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anwar.spring.springbatch.repository;

import com.anwar.spring.springbatch.dto.ItemDto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 *
 * @author anwarul.islam
 */
public interface ItemRepository extends ElasticsearchRepository<ItemDto, String>{
    
}
