package com.study.rest.dto;

import com.study.rest.entity.Product;
import lombok.Builder;
import lombok.Data;


public class ProductDto {

    @Builder
    public static class CommonResponse {
        private String message;
        private int count;

        public ProductDto.CommonResponse ofDefault(int count) {
            return CommonResponse.builder()
                    .message("Successfully")
                    .count(count)
                    .build();
        }
    }

    //dto를 받을 객체
    @Data
    public static class Register {
        private String productName;
        private int price;
        private int sizeId;
        private int colorId;

        //dto => entity(product)
        public Product toEntity() {
            return Product.builder()
                    .productName(productName)
                    .price(price)
                    .sizeId(sizeId)
                    .colorId(colorId)
                    .build();
        }
    }
}
