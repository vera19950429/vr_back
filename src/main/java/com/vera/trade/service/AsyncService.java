package com.vera.trade.service;

import com.vera.trade.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Classname AsyncService
 * @Description TODO
 * @Date 2019/8/26 14:27
 */
@Component
public class AsyncService {

    @Autowired
    private ModelService mModelService;
    @Async
    public void t1(){
                Model model=mModelService.selectByPrimaryKey("555");
                model.setBackPath("1111111111");
                mModelService.updateByPrimaryKey(model);
                System.out.println(mModelService.selectByPrimaryKey("555"));

    }
    @Async
    public void t2(){
                Model model=mModelService.selectByPrimaryKey("555");
                model.setPhotoPath("22222222222");
                mModelService.updateByPrimaryKey(model);
                System.out.println(mModelService.selectByPrimaryKey("555"));
    }
}
