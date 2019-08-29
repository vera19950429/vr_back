package com.vera.trade.service;

import com.vera.trade.mapper.ModelMapper;
import com.vera.trade.model.Model;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname ModelServiceImpl
 * @Description TODO
 * @Date 2019/8/16 15:57
 */
@Transactional
@Service
public class ModelServiceImpl implements ModelService {
    @Resource
    private ModelMapper mModelMapper;
    @Override
    public int deleteByPrimaryKey(final String id) {
        return mModelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(final Model record) {
        return mModelMapper.insert(record);
    }

    @Override
    public Model selectByPrimaryKey(final String id) {
        return mModelMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Model> selectAll() {
        return mModelMapper.selectAll();
    }
    @Override
    public int updateByPrimaryKey(final Model record) {
        return mModelMapper.updateByPrimaryKey(record);
    }

    @Override
    public Model updateModelPath(final String id, final String url) {
        Model model=selectByPrimaryKey(id);
        if (model==null)return model;
        model.setModelPath(url);
        mModelMapper.updateByPrimaryKey(model);
        return model;
    }

    @Override
    public Model updateBackPath(final String id, final String url) {
        Model model=selectByPrimaryKey(id);
        if (model==null)return null ;
        model.setBackPath(url);
        updateByPrimaryKey(model);
        return model;
    }

    @Override
    public Model updatePhotoPath(final String id, final String url) {
        Model model=selectByPrimaryKey(id);
        if (model==null)return null ;
        model.setPhotoPath(url);
        updateByPrimaryKey(model);
        return model;
    }

    @Override
    public Model updateParams(final String id, final String params) {
        Model model=selectByPrimaryKey(id);
        if (model==null)return null ;
        model.setParams(params);
        updateByPrimaryKey(model);
        return model;
    }
}
