/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pc.wat.rswebservice;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author PC
 */
@Data
@Builder
@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
public class MyCustomResultClass {
    
    
    private String field1;
    private int field2;
}
