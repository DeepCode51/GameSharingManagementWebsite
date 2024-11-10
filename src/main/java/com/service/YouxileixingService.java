package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YouxileixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YouxileixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YouxileixingView;


/**
 * 游戏类型
 *
 * @author 
 * @email 
 * @date 2022-04-14 15:56:29
 */
public interface YouxileixingService extends IService<YouxileixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YouxileixingVO> selectListVO(Wrapper<YouxileixingEntity> wrapper);
   	
   	YouxileixingVO selectVO(@Param("ew") Wrapper<YouxileixingEntity> wrapper);
   	
   	List<YouxileixingView> selectListView(Wrapper<YouxileixingEntity> wrapper);
   	
   	YouxileixingView selectView(@Param("ew") Wrapper<YouxileixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YouxileixingEntity> wrapper);
   	

}

