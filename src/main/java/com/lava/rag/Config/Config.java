package com.lava.rag.Config;

import java.nio.file.Paths;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class Config{
    @Value("classpath:Budget_Speech.txt")
    private Resource budget;

    @Bean
    SimpleVectorStore simpleVectorStore(EmbeddingModel embeddingModel) { //requires embedded database
        return SimpleVectorStore.builder()
                .withEmbeddingModel(embeddingModel)
                .withStoragePath(Paths.get("vector-store-data")) // creates a folder if needed
                .withStoreName("budget-store") // optional name
                .build();
    }

}