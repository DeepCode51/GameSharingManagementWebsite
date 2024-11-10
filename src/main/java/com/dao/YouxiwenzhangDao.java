package com.dao;

import com.entity.YouxiwenzhangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YouxiwenzhangVO;
import com.entity.view.YouxiwenzhangView;


/**
 * 游戏文章
 * 
 * @author 
 * @email 
 * @date 2022-04-14 15:56:29
 */
public interface YouxiwenzhangDao extends BaseMapper<YouxiwenzhangEntity> {
	
	List<YouxiwenzhangVO> selectListVO(@Param("ew") Wrapper<YouxiwenzhangEntity> wrapper);
	
	YouxiwenzhangVO selectVO(@Param("ew") Wrapper<YouxiwenzhangEntity> wrapper);
	
	List<YouxiwenzhangView> selectListView(@Param("ew") Wrapper<YouxiwenzhangEntity> wrapper);

	List<YouxiwenzhangView> selectListView(Pagination page,@Param("ew") Wrapper<YouxiwenzhangEntity> wrapper);
	
	YouxiwenzhangView selectView(@Param("ew") Wrapper<YouxiwenzhangEntity> wrapper);
	

}
