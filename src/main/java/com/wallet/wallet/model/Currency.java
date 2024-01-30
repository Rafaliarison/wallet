package com.wallet.wallet.model;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Currency {
    private int currencyId;
    private String curreencyName;
    private String currencyCode;

}
