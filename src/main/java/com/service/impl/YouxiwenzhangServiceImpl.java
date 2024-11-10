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


import com.dao.YouxiwenzhangDao;
import com.entity.YouxiwenzhangEntity;
import com.service.YouxiwenzhangService;
import com.entity.vo.YouxiwenzhangVO;
import com.entity.view.YouxiwenzhangView;

@Service("youxiwenzhangService")
public class YouxiwenzhangServiceImpl extends ServiceImpl<YouxiwenzhangDao, YouxiwenzhangEntity> implements YouxiwenzhangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YouxiwenzhangEntity> page = this.selectPage(
                new Query<YouxiwenzhangEntity>(params).getPage(),
                new EntityWrapper<YouxiwenzhangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YouxiwenzhangEntity> wrapper) {
		  Page<YouxiwenzhangView> page =new Query<YouxiwenzhangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YouxiwenzhangVO> selectListVO(Wrapper<YouxiwenzhangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YouxiwenzhangVO selectVO(Wrapper<YouxiwenzhangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YouxiwenzhangView> selectListView(Wrapper<YouxiwenzhangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YouxiwenzhangView selectView(Wrapper<YouxiwenzhangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
