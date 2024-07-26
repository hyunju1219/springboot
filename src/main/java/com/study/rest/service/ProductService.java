package com.study.rest.service;

import com.study.rest.dto.*;
import com.study.rest.entity.Color;

import java.util.List;

public interface ProductService {
    List<SizeDto.Info> getSizeListAll();
    List<ColorDto.Info> getColorListAll();
    CommonResponseDto registerProduct(ProductDto.Register register);
    CommonResponseDto registerSize(ReqRegisterSizeDto reqRegisterSizeDto);
    CommonResponseDto registerColor(ReqRegisterColorDto reqRegisterColorDto);
}
