package com.performancetest.chanwoong.jsontest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

public class JsonTest {

    @Test
    public void jsonTest() throws Exception {
        String individualApiJsonData = """
                {
                  "msg": "Event Get Success",
                  "result": 
                  {
                    "eventSeq": 1,
                    "eventName": "노브랜드 생활용품 모음전",
                    "eventEndDate": "2024-04-29 16:04:24",
                    "eventLowestPrice": 800,
                    "eventThumnail": "https://sitem.ssgcdn.com/91/81/02/item/1000049028191_i1_750.jpg",
                    "eventVendor": "노브랜드"
                  }
                }
                """;

        String integratedApiJsonData = """
                {
                  "msg": "Event Get Success",
                  "result": [
                    {
                      "eventSeq": 1,
                      "eventName": "노브랜드 생활용품 모음전",
                      "eventEndDate": "2024-04-29 16:04:24",
                      "eventLowestPrice": 800,
                      "eventThumnail": "https://sitem.ssgcdn.com/91/81/02/item/1000049028191_i1_750.jpg",
                      "eventVendor": "노브랜드"
                    },
                    {
                      "eventSeq": 2,
                      "eventName": "노브랜드 생활용품 모음전",
                      "eventEndDate": "2024-04-29 16:04:24",
                      "eventLowestPrice": 800,
                      "eventThumnail": "https://sitem.ssgcdn.com/91/81/02/item/1000049028191_i1_750.jpg",
                      "eventVendor": "노브랜드"
                    },
                    {
                      "eventSeq": 3,
                      "eventName": "노브랜드 생활용품 모음전",
                      "eventEndDate": "2024-04-29 16:04:24",
                      "eventLowestPrice": 800,
                      "eventThumnail": "https://sitem.ssgcdn.com/91/81/02/item/1000049028191_i1_750.jpg",
                      "eventVendor": "노브랜드"
                    },
                    {
                      "eventSeq": 4,
                      "eventName": "노브랜드 생활용품 모음전",
                      "eventEndDate": "2024-04-29 16:04:24",
                      "eventLowestPrice": 800,
                      "eventThumnail": "https://sitem.ssgcdn.com/91/81/02/item/1000049028191_i1_750.jpg",
                      "eventVendor": "노브랜드"
                    },
                    {
                      "eventSeq": 5,
                      "eventName": "노브랜드 생활용품 모음전",
                      "eventEndDate": "2024-04-29 16:04:24",
                      "eventLowestPrice": 800,
                      "eventThumnail": "https://sitem.ssgcdn.com/91/81/02/item/1000049028191_i1_750.jpg",
                      "eventVendor": "노브랜드"
                    },
                    {
                      "eventSeq": 6,
                      "eventName": "노브랜드 생활용품 모음전",
                      "eventEndDate": "2024-04-29 16:04:24",
                      "eventLowestPrice": 800,
                      "eventThumnail": "https://sitem.ssgcdn.com/91/81/02/item/1000049028191_i1_750.jpg",
                      "eventVendor": "노브랜드"
                    },
                    {
                      "eventSeq": 7,
                      "eventName": "노브랜드 생활용품 모음전",
                      "eventEndDate": "2024-04-29 16:04:24",
                      "eventLowestPrice": 800,
                      "eventThumnail": "https://sitem.ssgcdn.com/91/81/02/item/1000049028191_i1_750.jpg",
                      "eventVendor": "노브랜드"
                    },
                    {
                      "eventSeq": 8,
                      "eventName": "노브랜드 생활용품 모음전",
                      "eventEndDate": "2024-04-29 16:04:24",
                      "eventLowestPrice": 800,
                      "eventThumnail": "https://sitem.ssgcdn.com/91/81/02/item/1000049028191_i1_750.jpg",
                      "eventVendor": "노브랜드"
                    },
                    {
                      "eventSeq": 9,
                      "eventName": "노브랜드 생활용품 모음전",
                      "eventEndDate": "2024-04-29 16:04:24",
                      "eventLowestPrice": 800,
                      "eventThumnail": "https://sitem.ssgcdn.com/91/81/02/item/1000049028191_i1_750.jpg",
                      "eventVendor": "노브랜드"
                    },{
                      "eventSeq": 10,
                      "eventName": "노브랜드 생활용품 모음전",
                      "eventEndDate": "2024-04-29 16:04:24",
                      "eventLowestPrice": 800,
                      "eventThumnail": "https://sitem.ssgcdn.com/91/81/02/item/1000049028191_i1_750.jpg",
                      "eventVendor": "노브랜드"
                    }
                  ]
                }
                """;

        // JSON 직렬화
        ObjectMapper objectMapper = new ObjectMapper();

        Object individualApiJsonObject = objectMapper.readValue(individualApiJsonData, Object.class);
        String individualApiSerializedJson = objectMapper.writeValueAsString(individualApiJsonObject);

        Object integratedApiJsonObject = objectMapper.readValue(integratedApiJsonData, Object.class);
        String integratedApiSerializedJson = objectMapper.writeValueAsString(integratedApiJsonObject);

        // JSON 문자열 크기 계산
        int individualApiJsonByteSize = individualApiSerializedJson.getBytes(StandardCharsets.UTF_8).length;
        int integratedApiJsonByteSize = integratedApiSerializedJson.getBytes(StandardCharsets.UTF_8).length;

        // 출력
//        System.out.println("개별 API Serialized JSON: " + individualApiSerializedJson);
        System.out.println("개별 API JSON 데이터 크기 * 10: " + individualApiJsonByteSize * 10 + " bytes");

//        System.out.println("통합 API Serialized JSON: " + integratedApiSerializedJson);
        System.out.println("통한 API JSON 데이터 크기: " + integratedApiJsonByteSize + " bytes");
    }
}
