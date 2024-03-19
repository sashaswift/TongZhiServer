package com.example.tongzhiserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.tongzhiserver.conTongzhi.TongzhiInformation;

import java.util.List;

public interface TongzhiMapper extends BaseMapper<TongzhiInformation> {
    List<TongzhiInformation> getAllTongzhi();
    void deleteById(String id);
    List<TongzhiInformation> getTongzhiByID(String id);
}
