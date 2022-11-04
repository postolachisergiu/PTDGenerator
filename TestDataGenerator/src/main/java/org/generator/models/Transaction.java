package org.generator.models;


import lombok.Builder;
import lombok.Data;
import lombok.NonNull;


@Builder
@Data
public class Transaction {

    private @NonNull String id;
    private @NonNull String tNumber;
    private @NonNull String currency;
    private String validFrom;
    private String validTo;

}
