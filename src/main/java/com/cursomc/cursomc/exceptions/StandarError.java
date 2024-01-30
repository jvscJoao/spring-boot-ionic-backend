package com.cursomc.cursomc.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StandarError {

    private Integer status;
    private String msg;
    private Long timeStamp;
    
}
