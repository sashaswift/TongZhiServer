package com.example.tongzhiserver.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.tongzhiserver.conTongzhi.TongzhiInformation;
import com.example.tongzhiserver.mapper.TongzhiMapper;
import com.example.tongzhiserver.service.IPoiService;
import org.springframework.stereotype.Service;

@Service
public class PoiServiceImpl extends ServiceImpl<TongzhiMapper,TongzhiInformation> implements IPoiService {
}
