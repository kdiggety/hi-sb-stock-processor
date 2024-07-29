package hobbyinvestor.repository.mongo;

import hobbyinvestor.model.CompanyProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyProfileRepository extends MongoRepository<CompanyProfile, String> {
}
