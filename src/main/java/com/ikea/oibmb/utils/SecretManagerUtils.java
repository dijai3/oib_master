package com.ikea.oibmb.utils;

import java.io.IOException;

import com.google.cloud.secretmanager.v1.AccessSecretVersionResponse;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretVersionName;
import com.ikea.oibmb.constants.OIBConstants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecretManagerUtils {

    @Value("${spring.cloud.gcp.project-id}")
    private String projectId;

    public String getSecretValue(String secretId) {
		String secretValue = null;
		try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {
            SecretVersionName secretVersionName = SecretVersionName.of(projectId, secretId,OIBConstants.SECRET_VERSION);
            AccessSecretVersionResponse response = client.accessSecretVersion(secretVersionName);
            secretValue = response.getPayload().getData().toStringUtf8();		
		} catch (IOException e) {		
			e.printStackTrace();
		}
		return secretValue;
	}
}
