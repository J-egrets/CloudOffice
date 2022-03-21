package cn.egret.server.controller;

import cn.egret.server.pojo.Position;
import cn.egret.server.pojo.RespBean;
import cn.egret.server.service.IPositionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author egret
 */
@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {

    @Autowired
    private IPositionService positionService;

    @ApiOperation(value = "获取职位信息")
    @GetMapping("/")
    private List<Position> getAllPosition(){
        return positionService.list();
    }

    @ApiOperation(value = "添加职位信息")
    @PostMapping("/")
    private RespBean addPosition(@RequestBody Position position){
        position.setCreateDate(LocalDateTime.now());
        if (positionService.save(position)){
            return RespBean.success("添加职位成功");
        }
        return RespBean.error("添加职位失败");
    }

    @ApiOperation(value = "修改职位信息")
    @PutMapping("/")
    private RespBean updatePosition(@RequestBody Position position){
        if (positionService.updateById(position)){
            return RespBean.success("修改职位成功");
        }
        return RespBean.error("修改职位失败");
    }

    @ApiOperation(value = "删除职位信息")
    @DeleteMapping("/{id}")
    private RespBean deletePosition(@PathVariable Integer id){
        if (positionService.removeById(id)){
            return RespBean.success("删除职位成功");
        }
        return RespBean.error("删除职位失败");
    }

    @ApiOperation(value = "批量删除职位信息")
    @DeleteMapping("/")
    public RespBean deletePositionByIds(Integer[] ids){
        if (positionService.removeByIds(Arrays.asList(ids))){
            return RespBean.success("批量删除职位成功");
        }
        return RespBean.error("批量删除职位失败");
    }

}
