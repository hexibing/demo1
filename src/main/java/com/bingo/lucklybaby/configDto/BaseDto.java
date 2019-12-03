package com.bingo.lucklybaby.configDto;

import lombok.Data;

import java.io.Serializable;
@Data
public class BaseDto implements Serializable {

    private static final long serialVersionUID = 3987718850100615358L;

    private String code;

    private String message;

    public BaseDto() {
        super();
    }

    public BaseDto(boolean success) {
        if(success) {
            this.code = "0";
            this.message = "OK";
        }else {
            this.code = "500";
            this.message = "";
        }
    }

    public BaseDto(boolean success, String message) {
        if(success) {
            this.code = "0";
        }else {
            this.code = "500";
        }
        this.message = message;
    }

    public BaseDto(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public void generateBaseDTO(boolean success) {
        if(success) {
            this.code = "0";
            this.message = "OK";
        }else {
            this.code = "500";
            this.message = "";
        }
    }
}
