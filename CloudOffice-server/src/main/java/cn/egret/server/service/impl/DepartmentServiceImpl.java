package cn.egret.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.egret.server.mapper.DepartmentMapper;
import cn.egret.server.pojo.Department;
import cn.egret.server.pojo.RespBean;
import cn.egret.server.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author egret
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 查询所有部门
     * @return
     */
    @Override
    public List<Department> getAllDepartments() {

        return departmentMapper.getAllDepartmentsByParentId(-1);
    }

    /**
     * 添加部门
     * @param dep
     * @return
     */
    @Override
    public RespBean addDep(Department dep) {
        dep.setEnabled(true);
        departmentMapper.addDep(dep);
        if (1 == dep.getResult()){
            return RespBean.success("添加部门成功",dep);
        }

        return RespBean.error("添加部门失败");
    }

    /**
     * 删除部门
     * @param id
     * @return
     */
    @Override
    public RespBean deleteDep(Integer id) {
        Department department = new Department();
        department.setId(id);
        departmentMapper.deleteDep(department);
        if (-2 == department.getResult()){
            return RespBean.error("该部门下有子部门或该部门不存在，删除部门失败！");
        }
        if (-1 == department.getResult()){
            return RespBean.error("该部门下有员工，删除部门失败！");
        }
        if (1 == department.getResult()){
            return RespBean.success("删除部门成功！");
        }
        return RespBean.error("删除部门失败");
    }
}
