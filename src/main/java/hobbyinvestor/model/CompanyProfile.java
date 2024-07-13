
package hobbyinvestor.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "companyProfile")
public class CompanyProfile {
    @MongoId
    @JsonProperty("ticker")
    private String ticker;

    @JsonProperty("country")
    private String country;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("estimateCurrency")
    private String estimateCurrency;
    @JsonProperty("exchange")
    private String exchange;
    @JsonProperty("finnhubIndustry")
    private String finnhubIndustry;
    @JsonProperty("ipo")
    private String ipo;
    @JsonProperty("logo")
    private String logo;
    @JsonProperty("marketCapitalization")
    private Double marketCapitalization;
    @JsonProperty("name")
    private String name;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("shareOutstanding")
    private Double shareOutstanding;
    @JsonProperty("weburl")
    private String weburl;
}
