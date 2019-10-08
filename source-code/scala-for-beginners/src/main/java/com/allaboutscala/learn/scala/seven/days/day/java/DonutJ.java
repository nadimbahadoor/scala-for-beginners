package com.allaboutscala.learn.scala.seven.days.day.java;

/**
 * Created by Nadim Bahadoor on 15/10/2018.
 *
 * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
 *
 *
 * Copyright 2016 - 2019 Nadim Bahadoor (http://allaboutscala.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *  [http://www.apache.org/licenses/LICENSE-2.0]
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
public class DonutJ {
    private String name;
    private Long productCode;

    public DonutJ(String name, Long productCode) {
        this.name = name;
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProductCode() {
        return productCode;
    }

    public void setProductCode(Long productCode) {
        this.productCode = productCode;
    }

    public void print() {
        System.out.println("Donut name = " + name + ", productCode = " + productCode);
    }
}


