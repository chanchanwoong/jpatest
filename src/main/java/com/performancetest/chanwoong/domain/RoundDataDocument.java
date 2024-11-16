package com.performancetest.chanwoong.domain;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
//@Setter
@NoArgsConstructor
@Document(collection = "round_info")
public class RoundDataDocument {

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

    public void setRoundInfoId(String roundInfoId) {
        this.roundInfoId = roundInfoId;
    }

    public void setAuctionUuid(String auctionUuid) {
        this.auctionUuid = auctionUuid;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public void setRoundStartTime(LocalDateTime roundStartTime) {
        this.roundStartTime = roundStartTime;
    }

    public void setRoundEndTime(LocalDateTime roundEndTime) {
        this.roundEndTime = roundEndTime;
    }

    public void setIncrementUnit(BigDecimal incrementUnit) {
        this.incrementUnit = incrementUnit;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public void setLeftNumberOfParticipants(int leftNumberOfParticipants) {
        this.leftNumberOfParticipants = leftNumberOfParticipants;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setAuctionEndTime(LocalDateTime auctionEndTime) {
        this.auctionEndTime = auctionEndTime;
    }

    public void setLastRound(Boolean lastRound) {
        isLastRound = lastRound;
    }

    public void setEndStatus(Boolean endStatus) {
        this.endStatus = endStatus;
    }
}
