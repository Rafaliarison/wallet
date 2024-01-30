package com.wallet.wallet.model;
import lombok.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Balance {
    private int balanceId;
    private LocalDateTime balanceDate;
    private float balanceAmount;
}
