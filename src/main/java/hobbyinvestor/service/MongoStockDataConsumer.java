package hobbyinvestor.service;

import hobbyinvestor.model.CompanyProfile;
import hobbyinvestor.repository.mongo.CompanyProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MongoStockDataConsumer {
    private final CompanyProfileRepository companyProfileRepository;

    /*@KafkaListener(topics = "${hobbyinvestor.topic-names.companyProfileUpdateTopic}")
    public void processCompanyProfileUpdateString(String data) {
        log.info(String.format("Processing company profile update string: %s", data));
    }*/

    @KafkaListener(
            topics = "${hobbyinvestor.topic-names.companyProfileUpdateTopic}",
            containerFactory = "mongoCompanyProfileKafkaListenerContainerFactory")
    public void processCompanyProfileUpdate(CompanyProfile companyProfile) {
        log.info(String.format("Processing company profile update: %s", companyProfile));
        companyProfileRepository.save(companyProfile);
        log.info("Done processing company profile update");
    }
}