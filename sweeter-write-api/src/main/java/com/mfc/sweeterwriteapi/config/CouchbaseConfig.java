package com.mfc.sweeterwriteapi.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.mapping.CouchbaseMappingContext;

@Configuration
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Override
    public String getConnectionString() {
        return "couchbase://127.0.0.1";
    }

    @Override
    public String getUserName() {
        return "Administrator";
    }

    @Override
    public String getPassword() {
        return "password";
    }

    @Override
    public String getBucketName() {
        return "sweeter";
    }

    @Override
    @Bean
    public CouchbaseMappingContext couchbaseMappingContext(@Qualifier("couchbaseCustomConversions") CustomConversions customConversions) throws Exception {
        CouchbaseMappingContext mappingContext = new CouchbaseMappingContext();
        mappingContext.setInitialEntitySet(this.getInitialEntitySet());
        mappingContext.setSimpleTypeHolder(customConversions.getSimpleTypeHolder());
        mappingContext.setFieldNamingStrategy(this.fieldNamingStrategy());
        mappingContext.setAutoIndexCreation(this.autoIndexCreation());
        return mappingContext;
    }

    //    @Override
//    @Bean(name = "couchbaseCustomConversions")
//    @Primary
//    public CustomConversions customConversions() {
//        return new CouchbaseCustomConversions(Collections.emptyList());
//    }
}
