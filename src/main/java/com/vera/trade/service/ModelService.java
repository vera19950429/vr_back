package com.vera.trade.service;

import com.vera.trade.model.Model;

import java.util.List;

/**
 * @Classname ModelService
 * @Description TODO
 * @Date 2019/8/16 15:56
 */
public interface ModelService {
    int deleteByPrimaryKey(String id);

    int insert(Model record);

    Model selectByPrimaryKey(String id);

    List<Model> selectAll();

    int updateByPrimaryKey(Model record);

    Model updateModelPath(String id,String url);

    Model updateBackPath(String id, String url);

    Model updatePhotoPath(String id, String url);

    Model updateParams(String id, String params);
}
