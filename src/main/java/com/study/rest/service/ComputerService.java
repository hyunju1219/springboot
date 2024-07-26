package com.study.rest.service;

import com.study.rest.dto.*;

import java.util.List;

public interface ComputerService {
    CommonResponseDto registerComputer(ReqRegisterComputerDto reqRegisterComputerDto);
    List<?> getComputerList(ReqGetListDto reqDto);
    RespGetComputerDto getComputer(int computerId);
    int deleteComputer(int computerId);
    int updateComputer(ReqUpdateComputerDto reqUpdateComputerDto);

}
