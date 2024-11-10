package com.dao;

import com.entity.YouxileixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YouxileixingVO;
import com.entity.view.YouxileixingView;


/**
 * 游戏类型
 * 
 * @author 
 * @email 
 * @date 2022-04-14 15:56:29
 */
public interface YouxileixingDao extends BaseMapper<YouxileixingEntity> {
	
	List<YouxileixingVO> selectListVO(@Param("ew") Wrapper<YouxileixingEntity> wrapper);
	
	YouxileixingVO selectVO(@Param("ew") Wrapper<YouxileixingEntity> wrapper);
	
	List<YouxileixingView> selectListView(@Param("ew") Wrapper<YouxileixingEntity> wrapper);

	List<YouxileixingView> selectListView(Pagination page,@Param("ew") Wrapper<YouxileixingEntity> wrapper);
	
	YouxileixingView selectView(@Param("ew") Wrapper<YouxileixingEntity> wrapper);
	

}
