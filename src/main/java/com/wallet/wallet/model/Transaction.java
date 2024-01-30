package com.wallet.wallet.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Transaction {
    private int transactionId;
    private String transactionLabel;
    private float transactionAmount;
    private String transactionType;
    private LocalDateTime transactionDate;
}
