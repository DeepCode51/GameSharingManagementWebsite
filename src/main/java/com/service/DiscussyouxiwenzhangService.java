package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussyouxiwenzhangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussyouxiwenzhangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussyouxiwenzhangView;


/**
 * 游戏文章评论表
 *
 * @author 
 * @email 
 * @date 2022-04-14 15:56:29
 */
public interface DiscussyouxiwenzhangService extends IService<DiscussyouxiwenzhangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyouxiwenzhangVO> selectListVO(Wrapper<DiscussyouxiwenzhangEntity> wrapper);
   	
   	DiscussyouxiwenzhangVO selectVO(@Param("ew") Wrapper<DiscussyouxiwenzhangEntity> wrapper);
   	
   	List<DiscussyouxiwenzhangView> selectListView(Wrapper<DiscussyouxiwenzhangEntity> wrapper);
   	
   	DiscussyouxiwenzhangView selectView(@Param("ew") Wrapper<DiscussyouxiwenzhangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyouxiwenzhangEntity> wrapper);
   	

}

