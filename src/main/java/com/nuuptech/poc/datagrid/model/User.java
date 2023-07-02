package com.nuuptech.poc.datagrid.model;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private Long id;
    private String name;
    private List<String> accounts;

}
