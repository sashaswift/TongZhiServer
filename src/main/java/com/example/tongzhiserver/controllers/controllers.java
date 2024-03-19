package com.example.tongzhiserver.controllers;

import com.example.tongzhiserver.conTongzhi.TongzhiInformation;
import com.example.tongzhiserver.mapper.TongzhiMapper;
import com.example.tongzhiserver.service.IPoiService;
import com.example.tongzhiserver.vo.Result;
import com.example.tongzhiserver.vo.TongzhiVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/tongzhi")
@Slf4j
public class controllers {
    @Autowired
    private TongzhiMapper tongzhiMapper;

    @Autowired
    private IPoiService poiService;

    @GetMapping("/getfivetongzhi")
    public Result GetFiveTongzhi(){
        List<TongzhiInformation> r=tongzhiMapper.getAllTongzhi();
        List voList=new ArrayList();
        int i=0;
        //tongzhiMapper.
        for(TongzhiInformation tongzhiInformation:r){
            TongzhiVo tongzhiVo=new TongzhiVo();
            BeanUtils.copyProperties(tongzhiInformation,tongzhiVo);
            if(tongzhiInformation.getStatus().equals("已发布")) {
                voList.add(tongzhiVo);
                i++;
            }

            if(i==5){
                return Result.success(voList);
            }
        }
        return Result.success(voList);
    }

    @GetMapping("/getonetongzhi")
    public Result GetOneTongzhi(){
        List<TongzhiInformation> r=tongzhiMapper.getAllTongzhi();
        List voList=new ArrayList();
        int i=0;
        //tongzhiMapper.
        for(TongzhiInformation tongzhiInformation:r){
            TongzhiVo tongzhiVo=new TongzhiVo();
            BeanUtils.copyProperties(tongzhiInformation,tongzhiVo);
            //voList.add(tongzhiVo);

            if(tongzhiInformation.getStatus().equals("已发布")) {
                voList.add(tongzhiVo);
                i++;
            }
            if(i==1){
                return Result.success(voList);
            }
        }
        return Result.success(voList);
    }

    @GetMapping("/getalltongzhi")
    public Result GetAllTongzhi(){
        List<TongzhiInformation> r=tongzhiMapper.getAllTongzhi();
        List voList=new ArrayList();

        //tongzhiMapper.
        for(TongzhiInformation tongzhiInformation:r){
            TongzhiVo tongzhiVo=new TongzhiVo();
            BeanUtils.copyProperties(tongzhiInformation,tongzhiVo);
            voList.add(tongzhiVo);
        }
        return Result.success(voList);
    }

    @PutMapping("/update")
    public Result Update(@RequestBody TongzhiInformation tongzhiInformation){
           poiService.updateById(tongzhiInformation);
           return Result.success();
    }

    @PostMapping("/inserttongzhi")
    public Result InsertTongzhi(@RequestBody TongzhiInformation tongzhiInformation){
        long times=System.currentTimeMillis();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        long oriId=0-times;
        String date_string=sdf.format(new Date(times));
        String newId=oriId+" ";
       tongzhiInformation.setDatetime(date_string);
        tongzhiInformation.setId(newId);
        poiService.save(tongzhiInformation);
        TongzhiVo tongzhiVo=new TongzhiVo();
        BeanUtils.copyProperties(tongzhiInformation,tongzhiVo);
        return Result.success(tongzhiVo);
    }

    @DeleteMapping("/deleteservice")
    public Result deleteTongzhi(String id){
        tongzhiMapper.deleteById(id);
        return Result.success();
    }

    @GetMapping("/gettongzhibyid")
    public Result GetTongzhiByID(String id){
        List<TongzhiInformation> r=tongzhiMapper.getTongzhiByID(id);
        List voList=new ArrayList();

        for(TongzhiInformation tongzhiInformation:r){
            TongzhiVo tongzhiVo=new TongzhiVo();
            BeanUtils.copyProperties(tongzhiInformation,tongzhiVo);
            voList.add(tongzhiVo);
        }
        return Result.success(voList);
    }
    @GetMapping("/getwaittosubmit")
    public Result GetWaitToSubmit(){
        List<TongzhiInformation> r=tongzhiMapper.getAllTongzhi();

        //tongzhiMapper.
        int num=0;
        for(TongzhiInformation tongzhiInformation:r){
           if (tongzhiInformation.getStatus().equals("未发布")){
               num++;
           }
        }
        return Result.success(num);
    }

}
