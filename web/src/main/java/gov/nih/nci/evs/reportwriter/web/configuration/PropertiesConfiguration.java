package gov.nih.nci.evs.reportwriter.web.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import gov.nih.nci.evs.reportwriter.web.properties.WebProperties;



@Configuration
@EnableConfigurationProperties
public class PropertiesConfiguration {

    /** The logger. */
    private static final Logger log = LoggerFactory.getLogger(PropertiesConfiguration.class);

    public PropertiesConfiguration() {
        log.debug("Creating instance of class PropertiesConfiguration");
    }


    /*
     * Stardog  Properties
     */
    @Bean
    @ConfigurationProperties(prefix = "gov.nih.nci.evs.reportwriter.web", ignoreUnknownFields = false)
    WebProperties webProperties() {
        return new WebProperties();
    }
    
    

   

}
