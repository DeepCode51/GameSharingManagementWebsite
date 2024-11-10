package com.dao;

import com.entity.DiscussyouxiwenzhangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussyouxiwenzhangVO;
import com.entity.view.DiscussyouxiwenzhangView;


/**
 * 游戏文章评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-14 15:56:29
 */
public interface DiscussyouxiwenzhangDao extends BaseMapper<DiscussyouxiwenzhangEntity> {
	
	List<DiscussyouxiwenzhangVO> selectListVO(@Param("ew") Wrapper<DiscussyouxiwenzhangEntity> wrapper);
	
	DiscussyouxiwenzhangVO selectVO(@Param("ew") Wrapper<DiscussyouxiwenzhangEntity> wrapper);
	
	List<DiscussyouxiwenzhangView> selectListView(@Param("ew") Wrapper<DiscussyouxiwenzhangEntity> wrapper);

	List<DiscussyouxiwenzhangView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyouxiwenzhangEntity> wrapper);
	
	DiscussyouxiwenzhangView selectView(@Param("ew") Wrapper<DiscussyouxiwenzhangEntity> wrapper);
	

}
