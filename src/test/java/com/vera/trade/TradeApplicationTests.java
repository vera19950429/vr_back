package com.vera.trade;

import com.vera.trade.service.AsyncService;
import com.vera.trade.service.ModelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TradeApplicationTests {

    @Autowired
    private ModelService mModelService;
    @Autowired
    private AsyncService mAsyncService;
    @Test
    public void t1(){
        mAsyncService.t1();
        mAsyncService.t2();
    }



}
