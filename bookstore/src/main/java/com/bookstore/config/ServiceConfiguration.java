package com.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bookstore.contract.IBookApiService;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;


@Configuration
public class ServiceConfiguration {
	
	@Bean
	public IBookApiService bookApiService() {
		return Feign.builder()
				.client(new OkHttpClient())
				.encoder(new GsonEncoder())
				.decoder(new GsonDecoder())
				.logger(new Slf4jLogger(IBookApiService.class))
				.logLevel(Logger.Level.FULL)
				.target(IBookApiService.class, "http://api.walmartlabs.com/v1");
	}

}
