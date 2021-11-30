/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anwar.spring.springbatch.dto;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author anwar
 */
@Data
public class ItemDto implements Serializable{
    private String name;
    private String role;
}
