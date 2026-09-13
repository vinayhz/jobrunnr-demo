package com.vinay.jobrunnrdemo.config;

import org.jobrunr.storage.StorageProvider;
import org.jobrunr.storage.sql.common.SqlStorageProviderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@Configuration
public class JobRunrStorageConfig {

    @Bean
    public StorageProvider storageProvider(DataSource dataSource) {
        // Instructs JobRunr to write tables into H2
        return SqlStorageProviderFactory.using(dataSource);
    }
}
