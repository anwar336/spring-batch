/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anwar.spring.springbatch.config;

import com.anwar.spring.springbatch.dto.ItemDto;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 *
 * @author anwar
 */
@Configuration
public class SpringBatchConfig {
    
//    @Bean
//    public ItemReader<ItemDto> itemReader()
//      throws UnexpectedInputException, ParseException {
//        FlatFileItemReader<Transaction> reader = new FlatFileItemReader<Transaction>();
//        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
//        String[] tokens = { "username", "userid", "transactiondate", "amount" };
//        tokenizer.setNames(tokens);
//        reader.setResource(inputCsv);
//        DefaultLineMapper<Transaction> lineMapper = 
//          new DefaultLineMapper<Transaction>();
//        lineMapper.setLineTokenizer(tokenizer);
//        lineMapper.setFieldSetMapper(new RecordFieldSetMapper());
//        reader.setLineMapper(lineMapper);
//        return reader;
//    }
    
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
        SqlPagingQueryProviderFactoryBean provider =
                new SqlPagingQueryProviderFactoryBean();
 
        provider.setDataSource(dataSource);
        provider.setSelectClause("SELECT email_address, name, purchased_package");
        provider.setFromClause("FROM students");
        provider.setSortKeys(sortByEmailAddressAsc());
 
        return provider;
    }
    
    private Map<String, Order> sortByEmailAddressAsc() {
        Map<String, Order> sortConfiguration = new HashMap<>();
        sortConfiguration.put("email_address", Order.ASCENDING);
        return sortConfiguration;
    }

}
