package io.ezstudy.open.csq.config.auth.dto;

import io.ezstudy.open.csq.Role;
import io.ezstudy.open.csq.model.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String provider;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes,
                           String nameAttributeKey, String name,
                           String email, String provider) {
        this.attributes = attributes;
        this.nameAttributeKey= nameAttributeKey;
        this.name = name;
        this.email = email;
        this.provider = provider;
    }

    public static OAuthAttributes of(String registrationId,
                                     String userNameAttributeName,
                                     Map<String, Object> attributes) {
        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName,
                                            Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .provider("google")
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }


    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .provider(provider)
                .role(Role.USER)
                .build();
    }
}
