package com.performancetest.chanwoong.domain;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Document(collation = "round_info")
public class RoundDataPostgreSQL {

    @Id
    private String roundInfoId;

    private String auctionUuid;
    private Integer round;
    private LocalDateTime roundStartTime;
    private LocalDateTime roundEndTime;
    private BigDecimal incrementUnit;
    private BigDecimal price;
    private Boolean isActive;
    private int numberOfParticipants;
    private int leftNumberOfParticipants;
    private LocalDateTime createdAt;
    private LocalDateTime auctionEndTime;
    private Boolean isLastRound;
    private Boolean endStatus;
}
