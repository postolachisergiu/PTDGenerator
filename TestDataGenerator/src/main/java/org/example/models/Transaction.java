package org.example.models;


import lombok.Builder;
import lombok.Data;
import lombok.NonNull;


@Builder
@Data
public class Transaction {

    private @NonNull Long id;
    private @NonNull String number;
    private @NonNull String currency;
    private String validFrom;
    private String validTo;

}
