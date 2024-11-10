package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.YouxiwenzhangEntity;
import com.entity.view.YouxiwenzhangView;

import com.service.YouxiwenzhangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 游戏文章
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-14 15:56:29
 */
@RestController
@RequestMapping("/youxiwenzhang")
public class YouxiwenzhangController {
    @Autowired
    private YouxiwenzhangService youxiwenzhangService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YouxiwenzhangEntity youxiwenzhang,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			youxiwenzhang.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YouxiwenzhangEntity> ew = new EntityWrapper<YouxiwenzhangEntity>();
		PageUtils page = youxiwenzhangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youxiwenzhang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YouxiwenzhangEntity youxiwenzhang, 
		HttpServletRequest request){
        EntityWrapper<YouxiwenzhangEntity> ew = new EntityWrapper<YouxiwenzhangEntity>();
		PageUtils page = youxiwenzhangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youxiwenzhang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YouxiwenzhangEntity youxiwenzhang){
       	EntityWrapper<YouxiwenzhangEntity> ew = new EntityWrapper<YouxiwenzhangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( youxiwenzhang, "youxiwenzhang")); 
        return R.ok().put("data", youxiwenzhangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YouxiwenzhangEntity youxiwenzhang){
        EntityWrapper< YouxiwenzhangEntity> ew = new EntityWrapper< YouxiwenzhangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( youxiwenzhang, "youxiwenzhang")); 
		YouxiwenzhangView youxiwenzhangView =  youxiwenzhangService.selectView(ew);
		return R.ok("查询游戏文章成功").put("data", youxiwenzhangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YouxiwenzhangEntity youxiwenzhang = youxiwenzhangService.selectById(id);
		youxiwenzhang.setClicktime(new Date());
		youxiwenzhangService.updateById(youxiwenzhang);
        return R.ok().put("data", youxiwenzhang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YouxiwenzhangEntity youxiwenzhang = youxiwenzhangService.selectById(id);
		youxiwenzhang.setClicktime(new Date());
		youxiwenzhangService.updateById(youxiwenzhang);
        return R.ok().put("data", youxiwenzhang);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        YouxiwenzhangEntity youxiwenzhang = youxiwenzhangService.selectById(id);
        if(type.equals("1")) {
        	youxiwenzhang.setThumbsupnum(youxiwenzhang.getThumbsupnum()+1);
        } else {
        	youxiwenzhang.setCrazilynum(youxiwenzhang.getCrazilynum()+1);
        }
        youxiwenzhangService.updateById(youxiwenzhang);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YouxiwenzhangEntity youxiwenzhang, HttpServletRequest request){
    	youxiwenzhang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(youxiwenzhang);
        youxiwenzhangService.insert(youxiwenzhang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YouxiwenzhangEntity youxiwenzhang, HttpServletRequest request){
    	youxiwenzhang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(youxiwenzhang);
        youxiwenzhangService.insert(youxiwenzhang);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody YouxiwenzhangEntity youxiwenzhang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(youxiwenzhang);
        youxiwenzhangService.updateById(youxiwenzhang);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        youxiwenzhangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<YouxiwenzhangEntity> wrapper = new EntityWrapper<YouxiwenzhangEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = youxiwenzhangService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,YouxiwenzhangEntity youxiwenzhang, HttpServletRequest request,String pre){
        EntityWrapper<YouxiwenzhangEntity> ew = new EntityWrapper<YouxiwenzhangEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = youxiwenzhangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youxiwenzhang), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,YouxiwenzhangEntity youxiwenzhang, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "youxileixing";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "youxiwenzhang").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<YouxiwenzhangEntity> youxiwenzhangList = new ArrayList<YouxiwenzhangEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                youxiwenzhangList.addAll(youxiwenzhangService.selectList(new EntityWrapper<YouxiwenzhangEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<YouxiwenzhangEntity> ew = new EntityWrapper<YouxiwenzhangEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = youxiwenzhangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youxiwenzhang), params), params));
        List<YouxiwenzhangEntity> pageList = (List<YouxiwenzhangEntity>)page.getList();
        if(youxiwenzhangList.size()<limit) {
            int toAddNum = (limit-youxiwenzhangList.size())<=pageList.size()?(limit-youxiwenzhangList.size()):pageList.size();
            for(YouxiwenzhangEntity o1 : pageList) {
                boolean addFlag = true;
                for(YouxiwenzhangEntity o2 : youxiwenzhangList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    youxiwenzhangList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(youxiwenzhangList.size()>limit) {
            youxiwenzhangList = youxiwenzhangList.subList(0, limit);
        }
        page.setList(youxiwenzhangList);
        return R.ok().put("data", page);
    }





}
