package com.demo.consumer.httpInterface ;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpInterfaceConfig {

//    @Bean
//    @LoadBalanced
//    public WebClient.Builder webClientBuilder() {
//        return WebClient.builder();
//    }  I commented this out because of the duplicate bean from the webclient package

    @Bean
    public ProviderHttpInterface webClientHttpInterface(WebClient.Builder webClientBuilder) {
        WebClient webClient = webClientBuilder
                .baseUrl("http://provider")
                .build();
        WebClientAdapter adapter = WebClientAdapter.create(webClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(adapter)
                .build();

        ProviderHttpInterface client = factory.createClient(ProviderHttpInterface.class);
        return client;
    }
}
