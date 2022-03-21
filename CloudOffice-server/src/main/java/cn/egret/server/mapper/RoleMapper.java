package cn.egret.server.mapper;

import cn.egret.server.pojo.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author egret
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据用户ID查询角色列表
     *
     * @param adminId
     * @return
     */
    List<Role> getRolesByAdminId(Integer adminId);
}
