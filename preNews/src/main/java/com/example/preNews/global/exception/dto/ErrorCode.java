package com.example.preNews.global.exception.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // Method Not Allowed Error
    METHOD_NOT_ALLOWED(40500, HttpStatus.METHOD_NOT_ALLOWED, "지원하지 않는 HTTP 메소드입니다."),

    // Not Found Error
    NOT_FOUND_END_POINT(40400, HttpStatus.NOT_FOUND, "존재하지 않는 API 엔드포인트입니다."),
    NOT_FOUND_RESOURCE(40400, HttpStatus.NOT_FOUND, "해당 리소스가 존재하지 않습니다."),
    NOT_FOUND_LOGIN_USER(40401, HttpStatus.NOT_FOUND, "로그인한 사용자가 존재하지 않습니다."),
    NOT_FOUND_AUTHORIZATION_HEADER(40401, HttpStatus.NOT_FOUND, "Authorization 헤더가 존재하지 않습니다."),
    NOT_FOUND_USER(40401, HttpStatus.NOT_FOUND, "해당 사용자가 존재하지 않습니다."),
    NOT_FOUND_BRANCH(40402, HttpStatus.NOT_FOUND, "해당 브랜치가 존재하지 않습니다."),
    NOT_FOUND_REGION(40403, HttpStatus.NOT_FOUND, "해당 지역이 존재하지 않습니다."),
    NOT_FOUND_HISTORY(40404, HttpStatus.NOT_FOUND, "해당 코디 기록이 존재하지 않습니다."),


    // Invalid Argument Error
    MISSING_REQUEST_PARAMETER(40000, HttpStatus.BAD_REQUEST, "필수 요청 파라미터가 누락되었습니다."),
    INVALID_ARGUMENT(40001, HttpStatus.BAD_REQUEST, "요청에 유효하지 않은 인자입니다."),
    INVALID_PARAMETER_FORMAT(40002, HttpStatus.BAD_REQUEST, "요청에 유효하지 않은 인자 형식입니다."),
    INVALID_HEADER_ERROR(40003, HttpStatus.BAD_REQUEST, "유효하지 않은 헤더입니다."),
    MISSING_REQUEST_HEADER(40004, HttpStatus.BAD_REQUEST, "필수 요청 헤더가 누락되었습니다."),
    BAD_REQUEST_PARAMETER(40005, HttpStatus.BAD_REQUEST, "잘못된 요청 파라미터입니다."),
    BAD_REQUEST_JSON(40006, HttpStatus.BAD_REQUEST, "잘못된 JSON 형식입니다."),

    // Gone Error
    GONE_SHARED_URL(41001, HttpStatus.GONE, "해당 공유 URL이 만료되었습니다."),

    // Access Denied Error
    ACCESS_DENIED(40300, HttpStatus.FORBIDDEN, "접근 권한이 없습니다."),
    NOT_MATCH_AUTH_CODE(40301, HttpStatus.FORBIDDEN, "인증 코드가 일치하지 않습니다."),
    NOT_MATCH_USER(40302, HttpStatus.FORBIDDEN, "해당 사용자가 일치하지 않습니다."),


    // Unauthorized Error
    FAILURE_LOGIN(40100, HttpStatus.UNAUTHORIZED, "잘못된 아이디 또는 비밀번호입니다."),
    EXPIRED_TOKEN_ERROR(40101, HttpStatus.UNAUTHORIZED, "만료된 토큰입니다."),
    INVALID_TOKEN_ERROR(40102, HttpStatus.UNAUTHORIZED, "유효하지 않은 토큰입니다."),
    TOKEN_MALFORMED_ERROR(40103, HttpStatus.UNAUTHORIZED, "토큰이 올바르지 않습니다."),
    TOKEN_TYPE_ERROR(40104, HttpStatus.UNAUTHORIZED, "토큰 타입이 일치하지 않거나 비어있습니다."),
    TOKEN_UNSUPPORTED_ERROR(40105, HttpStatus.UNAUTHORIZED, "지원하지않는 토큰입니다."),
    TOKEN_GENERATION_ERROR(40106, HttpStatus.UNAUTHORIZED, "토큰 생성에 실패하였습니다."),
    TOKEN_UNKNOWN_ERROR(40107, HttpStatus.UNAUTHORIZED, "알 수 없는 토큰입니다."),

    // Internal Server Error
    INTERNAL_SERVER_ERROR(50000, HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 에러입니다."),
    UPLOAD_FILE_ERROR(50001, HttpStatus.INTERNAL_SERVER_ERROR, "파일 업로드에 실패하였습니다."),
    THIRD_PARTY_API_ERROR(50002, HttpStatus.INTERNAL_SERVER_ERROR, "외부 API 호출에 실패하였습니다."),
    ALREADY_VOTED(50003, HttpStatus.INTERNAL_SERVER_ERROR, "이미 투표한 지역입니다."),
    ;

    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;

}
