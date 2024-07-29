package hobbyinvestor.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.elasticsearch.support.HttpHeaders;
import org.springframework.kafka.annotation.EnableKafka;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.springframework.data.elasticsearch.client.elc.ElasticsearchClients.ElasticsearchHttpClientConfigurationCallback;

@Slf4j
@EnableKafka
@EnableElasticsearchRepositories(basePackages = "hobbyinvestor.repository.elasticsearch")
@Configuration
public class ElasticSearchConfig extends ElasticsearchConfiguration {
    @Value(value = "${hobbyinvestor.elastic-search.cluster-node}")
    private String elasticSearchClusterNode;

    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo(elasticSearchClusterNode)
                .withConnectTimeout(Duration.ofSeconds(5))
                .withSocketTimeout(Duration.ofSeconds(3))
                .withBasicAuth("elasticsearch", "changeme")
                .withHeaders(() -> {
                    HttpHeaders headers = new HttpHeaders();
                    headers.add("currentTime", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
                    return headers;
                })
                .withClientConfigurer(
                        ElasticsearchHttpClientConfigurationCallback.from(clientBuilder -> {
                            return clientBuilder;
                        })).build();
    }
}