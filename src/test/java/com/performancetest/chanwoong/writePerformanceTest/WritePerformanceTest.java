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
//    @Transactional
    public void MongoDbInsertTest() {
        // 테스트 삽입 횟수 지정
        int dataSizes = 100000;
        long mongoStartTime = System.currentTimeMillis();

        for (int i = 0; i < dataSizes; i++) {
            RoundDataDocument data = createMongoData();
            mongoDbRepository.save(data);
        }
        long mongoEndTime = System.currentTimeMillis();
        System.out.println("MongoDB - " + dataSizes + " records inserted in: " + (mongoEndTime - mongoStartTime) + "ms");
    }

    @Test
//    @Transactional
    public void postgreSqlInsertTest() {
        // 테스트 삽입 횟수 지정
        int dataSizes = 100000;
        long postgresStartTime = System.currentTimeMillis();

        for (int i = 0; i < dataSizes; i++) {
            RoundDataEntity data = createPostgreSQLData();
            postgreSqlRepository.save(data);
        }
        long postgresEndTime = System.currentTimeMillis();
        System.out.println("PostgreSQL - " + dataSizes + " records inserted in: " + (postgresEndTime - postgresStartTime) + "ms");
    }
}
