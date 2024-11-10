package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussyouxiwenzhangDao;
import com.entity.DiscussyouxiwenzhangEntity;
import com.service.DiscussyouxiwenzhangService;
import com.entity.vo.DiscussyouxiwenzhangVO;
import com.entity.view.DiscussyouxiwenzhangView;

@Service("discussyouxiwenzhangService")
public class DiscussyouxiwenzhangServiceImpl extends ServiceImpl<DiscussyouxiwenzhangDao, DiscussyouxiwenzhangEntity> implements DiscussyouxiwenzhangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyouxiwenzhangEntity> page = this.selectPage(
                new Query<DiscussyouxiwenzhangEntity>(params).getPage(),
                new EntityWrapper<DiscussyouxiwenzhangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyouxiwenzhangEntity> wrapper) {
		  Page<DiscussyouxiwenzhangView> page =new Query<DiscussyouxiwenzhangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussyouxiwenzhangVO> selectListVO(Wrapper<DiscussyouxiwenzhangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussyouxiwenzhangVO selectVO(Wrapper<DiscussyouxiwenzhangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussyouxiwenzhangView> selectListView(Wrapper<DiscussyouxiwenzhangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyouxiwenzhangView selectView(Wrapper<DiscussyouxiwenzhangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
