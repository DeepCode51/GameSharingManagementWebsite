package com.entity.view;

import com.entity.YouxileixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 游戏类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-14 15:56:29
 */
@TableName("youxileixing")
public class YouxileixingView  extends YouxileixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YouxileixingView(){
	}
 
 	public YouxileixingView(YouxileixingEntity youxileixingEntity){
 	try {
			BeanUtils.copyProperties(this, youxileixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
