package com.vera.trade.mapper;

import com.vera.trade.model.Model;
import java.util.List;

public interface ModelMapper {
    int deleteByPrimaryKey(String id);

    int insert(Model record);

    Model selectByPrimaryKey(String id);

    List<Model> selectAll();

    int updateByPrimaryKey(Model record);
}