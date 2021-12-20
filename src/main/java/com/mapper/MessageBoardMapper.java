package com.mapper;

import team.community.bean.MessageBoard;

public interface MessageBoardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MessageBoard record);

    int insertSelective(MessageBoard record);

    MessageBoard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MessageBoard record);

    int updateByPrimaryKey(MessageBoard record);
}