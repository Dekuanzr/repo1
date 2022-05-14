package com.dekuan.domain;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class QueryVo {

    private String keyword;
    private User user;
    private List<User> userList;
    private Map<String,User> userMap;
}
