package com.study.rest.dto;

import com.study.rest.entity.Size;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

public class SizeDto {

    @Builder
    @Data
    public static class Info {
        private int sizeId;
        private String sizeName;
    }

    //entity리스트 => dto리스트
    //Size 타입을 담는 리스트를 Info 타입을 담는 리스트로 변환하는 메서드
    public static List<Info> toList(List<Size> sizeList) {
        return sizeList.stream().map(Size::toDto).collect(Collectors.toList());
    }
}
