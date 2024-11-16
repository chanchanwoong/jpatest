package com.performancetest.chanwoong.writePerformanceTest;

import com.performancetest.chanwoong.domain.RoundDataDocument;
import com.performancetest.chanwoong.domain.RoundDataEntity;
import com.performancetest.chanwoong.repository.MongoDbRepository;
import com.performancetest.chanwoong.repository.PostgreSqlRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootTest
public class WritePerformanceTest {

    @Autowired
    private PostgreSqlRepository postgreSqlRepository;

    @Autowired
    private MongoDbRepository mongoDbRepository;

    private RoundDataDocument createMongoData() {
        RoundDataDocument data = new RoundDataDocument();
        data.setAuctionUuid("auction-uuid");
        data.setRound(1);
        data.setRoundStartTime(LocalDateTime.now());
        data.setRoundEndTime(LocalDateTime.now().plusMinutes(10));
        data.setIncrementUnit(BigDecimal.valueOf(10));
        data.setPrice(BigDecimal.valueOf(1000));
        data.setActive(true);
        data.setNumberOfParticipants(100);
        data.setLeftNumberOfParticipants(50);
        data.setCreatedAt(LocalDateTime.now());
        data.setAuctionEndTime(LocalDateTime.now().plusMinutes(30));
        data.setLastRound(false);
        data.setEndStatus(false);
        return data;
    }

    private RoundDataEntity createPostgreSQLData() {
        RoundDataEntity data = new RoundDataEntity();
        data.setAuctionUuid("auction-uuid");
        data.setRound(1);
        data.setRoundStartTime(LocalDateTime.now());
        data.setRoundEndTime(LocalDateTime.now().plusMinutes(10));
        data.setIncrementUnit(BigDecimal.valueOf(10));
        data.setPrice(BigDecimal.valueOf(1000));
        data.setActive(true);
        data.setNumberOfParticipants(100);
        data.setLeftNumberOfParticipants(50);
        data.setCreatedAt(LocalDateTime.now());
        data.setAuctionEndTime(LocalDateTime.now().plusMinutes(30));
        data.setLastRound(false);
        data.setEndStatus(false);
        return data;
    }

    @Test
    @Transactional
    public void testInsertData() {
        // 테스트 삽입 횟수 지정
//        int[] dataSizes = {1000, 10000, 100000};
        int[] dataSizes = {100000};

        for (int dataSize : dataSizes) {
            // MongoDB 테스트
            long mongoStartTime = System.currentTimeMillis();
            IntStream.range(0, dataSize).forEach(i -> mongoDbRepository.save(createMongoData()));
            long mongoEndTime = System.currentTimeMillis();
            System.out.println("MongoDB - " + dataSize + " records inserted in: " + (mongoEndTime - mongoStartTime) + "ms");

            // PostgreSQL 테스트
            long postgresStartTime = System.currentTimeMillis();
            IntStream.range(0, dataSize).forEach(i -> postgreSqlRepository.save(createPostgreSQLData()));
            long postgresEndTime = System.currentTimeMillis();
            System.out.println("PostgreSQL - " + dataSize + " records inserted in: " + (postgresEndTime - postgresStartTime) + "ms");
        }
    }
}
