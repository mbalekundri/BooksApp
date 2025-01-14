package com.k8s.booksapp;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;

public class SecretDisplayApplication {

    public static void main(String[] args) throws InterruptedException, IllegalArgumentException {
        String keyVaultName = "my-key-vault-1979";
        String keyVaultUri = "https://" + keyVaultName + ".vault.azure.net";

        System.out.printf("key vault name = %s and key vault URI = %s \n", keyVaultName, keyVaultUri);

        SecretClient secretClient = new SecretClientBuilder()
                .vaultUrl(keyVaultUri)
                .credential(new DefaultAzureCredentialBuilder().build())
                .buildClient();

        String[] secrets = {"H2-DB-USERNAME", "H2-DB-PASSWORD"};

        printSecret(secretClient, secrets);

//        String secretName = "H2-DB-USERNAME";
//		String secretValue = "SECRET_VALUE";

//		System.out.print("Creating a secret in " + keyVaultName + " called '" + secretName + "' with value '" + secretValue + " ... ");
//
//		secretClient.setSecret(new KeyVaultSecret(secretName, secretValue));
//
//		System.out.println("done.");
//        System.out.println("Forgetting your secret.");

//		secretValue = "";
//		System.out.println("Your secret's value is '" + secretValue + "'.");

//        System.out.println("Retrieving your secret from " + keyVaultName + ".");
//
//        KeyVaultSecret retrievedSecret = secretClient.getSecret(secretName);
//
//        System.out.println("Your secret's value is '" + retrievedSecret.getValue() + "'.");
//		System.out.print("Deleting your secret from " + keyVaultName + " ... ");
//
//		SyncPoller<DeletedSecret, Void> deletionPoller = secretClient.beginDeleteSecret(secretName);
//		deletionPoller.waitForCompletion();
//
//		System.out.println("done.");
    }

    private static void printSecret(SecretClient secretClient, String[] secrets) {
        for (String secret : secrets) {
            KeyVaultSecret retrievedSecret = secretClient.getSecret(secret);
            System.out.println(secret+ "'s value is '" + retrievedSecret.getValue() + "'.");
        }
    }
}
