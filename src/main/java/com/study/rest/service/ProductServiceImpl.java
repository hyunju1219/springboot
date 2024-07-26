package com.study.rest.service;

import com.study.rest.dto.*;
import com.study.rest.entity.Color;
import com.study.rest.entity.Size;
import com.study.rest.repository.ColorMapper;
import com.study.rest.repository.ProductMapper;
import com.study.rest.repository.SizeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductMapper productMapper; //인터페이스를 구현한 클래스(xml)을 찾아 주입
    @Autowired
    private SizeMapper sizeMapper;
    @Autowired
    private ColorMapper colorMapper;

    @Override
    public List<SizeDto.Info> getSizeListAll() {
        return SizeDto.toList(sizeMapper.findAll());
    }

    @Override
    public List<ColorDto.Info> getColorListAll() {
        return ColorDto.toList(colorMapper.findAll());
    }

    @Override
    public CommonResponseDto registerProduct(ProductDto.Register register) {
        //dto를 entity로 변환해서 mapper를 통해 db에 저장 후 반환된값을 확인하고 결과리턴
        return CommonResponseDto.ofDefault(productMapper.save(register.toEntity()));
    }

    @Override
    public CommonResponseDto registerSize(ReqRegisterSizeDto reqRegisterSizeDto) {
        return CommonResponseDto.ofDefault(sizeMapper.save(reqRegisterSizeDto.toEntity()));
    }

    @Override
    public CommonResponseDto registerColor(ReqRegisterColorDto reqRegisterColorDto) {
        return CommonResponseDto.ofDefault(colorMapper.save(reqRegisterColorDto.toEntity()));
    }
}
