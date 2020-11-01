package com.magicbox.config;

import io.github.jhipster.config.JHipsterConstants;
import io.github.jhipster.config.h2.H2ConfigurationHelper;
import org.neo4j.springframework.data.repository.Neo4jRepository;
import org.neo4j.springframework.data.repository.config.EnableNeo4jRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Profile;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableNeo4jRepositories(
    basePackages = "com.magicbox.repository",
    includeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE, value = Neo4jRepository.class)
)
@EnableElasticsearchRepositories("com.magicbox.repository.search")
public class DatabaseConfiguration {
    private final Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);
}
