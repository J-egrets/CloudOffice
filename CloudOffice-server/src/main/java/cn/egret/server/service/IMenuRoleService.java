package cn.egret.server.service;

import cn.egret.server.pojo.MenuRole;
import cn.egret.server.pojo.RespBean;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author egret
 */
public interface IMenuRoleService extends IService<MenuRole> {

    /**
     * 更新角色的菜单
     * @param rid
     * @param mids
     * @return
     */
    RespBean updateMenuRole(Integer rid, Integer[] mids);
}
