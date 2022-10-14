/**
 * 
 */
package com.duke.learn.recipe.config;

import java.io.IOException;
import java.util.concurrent.Executor;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @author Kazi
 *
 */
@Configuration
@EnableAsync
public class AppConfig {

    @Value("${resttemplate.timeout.general}")
    private int restTemplateTimeoutGeneral;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() throws IOException {
	PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
	propertyPlaceholderConfigurer.setLocations(new ClassPathResource("datasource.properties"));
	propertyPlaceholderConfigurer.setIgnoreResourceNotFound(false);
	propertyPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(false);
	return propertyPlaceholderConfigurer;
    }

    @Bean
    public Executor asyncExecutor() {
	ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	executor.setCorePoolSize(10);
	executor.setMaxPoolSize(10);
	executor.setAllowCoreThreadTimeOut(true);
	executor.setQueueCapacity(10);
	executor.setThreadNamePrefix("Async-Task=> ");
	executor.initialize();
	return executor;
    }

    @Bean
    public RestTemplate restTemplate() {
	return new RestTemplate(getClientHttpRequestFactory());
    }

    private ClientHttpRequestFactory getClientHttpRequestFactory() {
	int timeout = restTemplateTimeoutGeneral;
	RequestConfig config = RequestConfig.custom().setConnectTimeout(timeout).setConnectionRequestTimeout(timeout)
		.setSocketTimeout(timeout).build();
	CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
	return new HttpComponentsClientHttpRequestFactory(client);
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
	CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	multipartResolver.setMaxUploadSize(-1);
	return multipartResolver;
    }

}
