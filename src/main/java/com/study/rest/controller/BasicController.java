package com.study.rest.controller;

import com.study.rest.dto.*;
import com.study.rest.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Rest : 데이터만 요청하고 받는 형식(responsebody 없어도됨)
//REST API //뷰를 리턴하지 않고 데이터 응답만 한다.
@Slf4j
@RestController
public class BasicController {

    @Autowired
    private ProductService productService;
    /*
        REST API
        데이터 통신을 위한 HTTP 요청 방식
        HTTP(프로토콜)을 조금 더 잘 쓰기 위해서 정의된 개념
        1. 요청에 대한 동작은 무조건 메소드에 따라서 정의
        - 데이터 추가(등록)은 POST 요청 사용, POST 요청은 JSON 데이터로 요청
        - 데이터 조회는 GET 요청 사용, GET 요청은 QueryString(params) 으로 요청
            예) 주소?key1=value&key2=value2 => QueryString 형식
        - 데이터 수정은 PUT, Patch 요청 사용, JSON 으로 요청
            PUT과 PATCH의 차이점
            - put 요청: 공백 또는 NULL인 데이터도 수정
            - patch 요청: 공백 또는 NULL인 데이터는 수정하지 않음
        - 데이터 삭제는 DELETE 요청 사용, params 로 요청
        2. 주소(URL) 요청 메시지(Resource) 자원 작성법
        - URL은 가능한 동사를 사용하지 않는다.
        - 계층 구조로 작성한다.
            예) /집/주방/가스레인지, /식당/주방/가스레인지
        - 요청 메소드 마다 작성하는 방법이 다름
            상품등록(POST) /product
            상품 하나 조회(GET) /product/1(id, key)
            상품 여러개 조회(GET) /products(전체), /products?page=1&count=30(한페이지에 30개씩)
            상품 수정(PUT) /product/1
            상품 삭제(DELETE) /product/1
        3. 주소는 가능한 대문자를 사용하지 않는다.

     */

    //CRUD 형식은 메서드 사용
    //post : 추가
    @CrossOrigin
    @PostMapping("/basic/student")
    public ResponseEntity<?> basicPost(@RequestBody ReqStudentDto reqStudentDto) {
        //@RequestBody : json 데이터로 받을 경우
        log.info("reqStudent : {}",reqStudentDto);
        return ResponseEntity.ok().body(reqStudentDto); // ok : 상태코드 200 의미
    }

    @CrossOrigin
    @PostMapping("/api/v1/product")
    public ResponseEntity<?> registerProduct(@RequestBody ProductDto.Register register) {

        return ResponseEntity.ok().body(productService.registerProduct(register));
    }

    @CrossOrigin
    @GetMapping("/api/v1/sizes")
    public ResponseEntity<?> sizeListApi() {
        return ResponseEntity.ok().body(productService.getSizeListAll());
    }

    @CrossOrigin
    @GetMapping("/api/v1/colors")
    public ResponseEntity<?> colorListApi() {
        return ResponseEntity.ok().body(productService.getColorListAll());
    }

    @CrossOrigin
    @PostMapping("/api/v1/size")
    public ResponseEntity<?> registerSizeApi(@RequestBody ReqRegisterSizeDto reqRegisterSizeDto) {
        log.info("{}", reqRegisterSizeDto);
        return ResponseEntity.ok().body(productService.registerSize(reqRegisterSizeDto));
    }

    @CrossOrigin
    @PostMapping("/api/v1/color")
    public ResponseEntity<?> registerColorApi(@RequestBody ReqRegisterColorDto reqRegisterColorDto) {
        return ResponseEntity.ok().body(productService.registerColor(reqRegisterColorDto));
    }

}
