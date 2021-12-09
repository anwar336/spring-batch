/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anwar.spring.springbatch.config;

import com.anwar.spring.springbatch.dto.ItemDto;
import com.anwar.spring.springbatch.repository.ItemRepository;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 *
 * @author anwar
 */
@Configuration
public class SpringBatchConfig {

    @Autowired
    private ItemRepository itemRepository;

    /*
    @Bean
    public ItemReader<ItemDto> itemReader(DataSource dataSource,
            PagingQueryProvider queryProvider) {
        return new JdbcPagingItemReaderBuilder<ItemDto>()
                .name("pagingItemReader")
                .dataSource(dataSource)
                .pageSize(1)
                .queryProvider(queryProvider)
                .rowMapper(new BeanPropertyRowMapper<>(ItemDto.class))
                .build();
    }

    @Bean
    public SqlPagingQueryProviderFactoryBean queryProvider(DataSource dataSource) {
        SqlPagingQueryProviderFactoryBean provider
                = new SqlPagingQueryProviderFactoryBean();

        provider.setDataSource(dataSource);
        provider.setSelectClause("SELECT groom_name, bride_name");
        provider.setFromClause("FROM marriage_register");
        provider.setSortKeys(sortByEmailAddressAsc());

        return provider;
    }

    private Map<String, Order> sortByEmailAddressAsc() {
        Map<String, Order> sortConfiguration = new HashMap<>();
        sortConfiguration.put("groom_name", Order.ASCENDING);
        return sortConfiguration;
    }
     */
    @Bean
    RepositoryItemReader<ItemDto> repositoryItemReader() {
        RepositoryItemReader<ItemDto> repositoryItemReader = new RepositoryItemReader<>();
        repositoryItemReader.setRepository(itemRepository);
        repositoryItemReader.setMethodName("findAll");
        repositoryItemReader.setPageSize(10);
        final HashMap<String, Sort.Direction> sorts = new HashMap<>();
        sorts.put("id", Sort.Direction.ASC);
        repositoryItemReader.setSort(sorts);
        return repositoryItemReader;
    }
}
