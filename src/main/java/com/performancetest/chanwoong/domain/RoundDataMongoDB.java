package com.performancetest.chanwoong.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "round_info")
public class RoundDataMongoDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roundInfoId;

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
