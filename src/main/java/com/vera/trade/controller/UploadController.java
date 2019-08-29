package com.vera.trade.controller;

import com.vera.trade.model.Model;
import com.vera.trade.service.ModelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * @Classname UploadController
 * @Description 文件上传
 * @Date 2019/8/16 11:40
 */
@RestController
@RequestMapping("/uploads")
public class UploadController {
//    private static String NignxUrl="http://192.168.43.169:2080/profile/";
    private static String NignxUrl="http://192.168.43.174:2080/profile/";
    private static Logger logger = LoggerFactory.getLogger(UploadController.class);
    @Autowired
    private ModelService mModelService;

    @GetMapping
    public String index() {
        return "index";
    }

    @PostMapping("/new/{id}")
    public Model newModel(@PathVariable("id")String id){
        if (mModelService.selectByPrimaryKey(id) !=null){
            return mModelService.selectByPrimaryKey(id);
        }
        Model model=new Model();
        model.setId(id);
        model.setCreateTime(new Date());
        mModelService.insert(model);
        return model;
    }
    @GetMapping("/getAll")
    public List<Model> getAll(){
        logger.info("getAll");
        return mModelService.selectAll();
    }
    @GetMapping("/search/{id}")
    public Model searchOne(@PathVariable("id")String id){
        Model model=mModelService.selectByPrimaryKey(id);
        return model;
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id")String id){
        Model model=mModelService.selectByPrimaryKey(id);
        if (model==null)return;
        mModelService.deleteByPrimaryKey(id);
    }

    @PostMapping("/{id}/photo_path")
    public Model photo_path(@PathVariable("id")String id, @RequestParam("file") MultipartFile file) throws IOException {
        if (id==null||file.isEmpty()){
            return null;
        }
        // TODO 将文件写入到指定目录（具体开发中有可能是将文件写入到云存储/或者指定目录通过 Nginx 进行 gzip 压缩和反向代理，此处只是为了演示故将地址写成本地电脑指定目录）
        String fileName=UUID.randomUUID().toString()+"_" +file.getOriginalFilename();
        String path="E:/profile/" + fileName;
        file.transferTo(new File(path));
//       String url="http://localhost:8090/myFile/"+fileName;//本地运行项目
       String url=NignxUrl+fileName;//本地运行项目
        Model model=mModelService.updatePhotoPath(id,url);
        return model;
    }
    @PostMapping("/{id}/back_path")
    public Model back_path(@PathVariable("id")String id, @RequestParam("file") MultipartFile file) throws IOException {

        if (id==null||file.isEmpty()){
            return null;
        }
        // TODO 将文件写入到指定目录（具体开发中有可能是将文件写入到云存储/或者指定目录通过 Nginx 进行 gzip 压缩和反向代理，此处只是为了演示故将地址写成本地电脑指定目录）
        String fileName=UUID.randomUUID().toString()+"_" +file.getOriginalFilename();
        String path="E:/profile/" + fileName;
        file.transferTo(new File(path));
//       String url="http://localhost:8090/myFile/"+fileName;//本地运行项目
        String url=NignxUrl+fileName;//本地运行项目

       Model model=mModelService.updateBackPath(id,url);
        return model;
    }
    @PostMapping("/{id}/model_path")
    public Model model_path(@PathVariable("id")String id, @RequestParam("file") MultipartFile file) throws IOException {
        if (id==null||file.isEmpty()){
            return null;
        }
        // TODO 将文件写入到指定目录（具体开发中有可能是将文件写入到云存储/或者指定目录通过 Nginx 进行 gzip 压缩和反向代理，此处只是为了演示故将地址写成本地电脑指定目录）
        String fileName=UUID.randomUUID().toString()+"_" +file.getOriginalFilename();
        String path="E:/profile/" + fileName;
        file.transferTo(new File(path));
//       String url="http://localhost:8090/myFile/"+fileName;//本地运行项目
        String url=NignxUrl+fileName;//本地运行项目

        Model model=mModelService.updateModelPath(id,url);

        return model;
    }


    @PutMapping("/submit")
    public Model submitModel(@RequestBody Model model){
        if (model==null){
            return null;
        }
        Model m=mModelService.selectByPrimaryKey(model.getId());
        if (m==null)return null;

        mModelService.updateByPrimaryKey(model);
        return model;
    }

    @PostMapping("/{id}/params")
    public Model params(@PathVariable("id")String id,@RequestBody String params){
        if (id==null||params==null){
            return null;
        }
        Model model=mModelService.updateParams(id,params);
        return model;
    }


}
