package org.example.evaluacioncarlosmunoz.implementation2.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class UserDTO {

    private Long id;
    private String name;
    private String username;
    private String email;
    private AddressDTO address;
    private String phone;
    private String website;
    private CompanyDTO company;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class AddressDTO {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class CompanyDTO {
        private String name;
        private String catchPhrase;
        private String bs;
    }
}
