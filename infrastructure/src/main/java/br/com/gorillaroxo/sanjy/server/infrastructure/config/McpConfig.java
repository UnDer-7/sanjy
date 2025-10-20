package br.com.gorillaroxo.sanjy.server.infrastructure.config;

import br.com.gorillaroxo.sanjy.server.infrastructure.adapter.controller.DietPlanController;
import br.com.gorillaroxo.sanjy.server.infrastructure.adapter.controller.MealRecordController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class McpConfig {

    private final Set<McpToolMarker> tools;

    @Bean
    public ToolCallbackProvider weatherTools() {
        return MethodToolCallbackProvider.builder()
            .toolObjects(tools.toArray(McpToolMarker[]::new))
            .build();
    }
}
