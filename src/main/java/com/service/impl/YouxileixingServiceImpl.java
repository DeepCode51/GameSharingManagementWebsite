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


import com.dao.YouxileixingDao;
import com.entity.YouxileixingEntity;
import com.service.YouxileixingService;
import com.entity.vo.YouxileixingVO;
import com.entity.view.YouxileixingView;

@Service("youxileixingService")
public class YouxileixingServiceImpl extends ServiceImpl<YouxileixingDao, YouxileixingEntity> implements YouxileixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YouxileixingEntity> page = this.selectPage(
                new Query<YouxileixingEntity>(params).getPage(),
                new EntityWrapper<YouxileixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YouxileixingEntity> wrapper) {
		  Page<YouxileixingView> page =new Query<YouxileixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YouxileixingVO> selectListVO(Wrapper<YouxileixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YouxileixingVO selectVO(Wrapper<YouxileixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YouxileixingView> selectListView(Wrapper<YouxileixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YouxileixingView selectView(Wrapper<YouxileixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
