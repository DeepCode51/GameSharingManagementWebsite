package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YouxiwenzhangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YouxiwenzhangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YouxiwenzhangView;


/**
 * 游戏文章
 *
 * @author 
 * @email 
 * @date 2022-04-14 15:56:29
 */
public interface YouxiwenzhangService extends IService<YouxiwenzhangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YouxiwenzhangVO> selectListVO(Wrapper<YouxiwenzhangEntity> wrapper);
   	
   	YouxiwenzhangVO selectVO(@Param("ew") Wrapper<YouxiwenzhangEntity> wrapper);
   	
   	List<YouxiwenzhangView> selectListView(Wrapper<YouxiwenzhangEntity> wrapper);
   	
   	YouxiwenzhangView selectView(@Param("ew") Wrapper<YouxiwenzhangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YouxiwenzhangEntity> wrapper);
   	

}

