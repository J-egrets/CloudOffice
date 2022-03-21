package cn.egret.server.service.impl;

import cn.egret.server.mapper.NationMapper;
import cn.egret.server.pojo.Nation;
import cn.egret.server.service.INationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author egret
 */
@Service
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation> implements INationService {

}
