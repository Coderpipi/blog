package site.lbw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.lbw.constant.RedisKeyConstants;
import site.lbw.constant.SiteSettingConstants;
import site.lbw.exception.PersistenceException;
import site.lbw.entity.SiteSetting;
import site.lbw.mapper.SiteSettingMapper;
import site.lbw.model.vo.Badge;
import site.lbw.model.vo.Copyright;
import site.lbw.model.vo.Favorite;
import site.lbw.model.vo.Introduction;
import site.lbw.service.RedisService;
import site.lbw.service.SiteSettingService;
import site.lbw.util.JacksonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SiteSettingServiceImpl implements SiteSettingService {
	@Autowired
	SiteSettingMapper siteSettingMapper;
	@Autowired
	RedisService redisService;

	private static final Pattern PATTERN = Pattern.compile("\"(.*?)\"");

	@Override
	public Map<String, List<SiteSetting>> getList() {
		List<SiteSetting> siteSettings = siteSettingMapper.getList();
		Map<String, List<SiteSetting>> map = new HashMap<>();
		List<SiteSetting> type1 = new ArrayList<>();
		List<SiteSetting> type2 = new ArrayList<>();
		List<SiteSetting> type3 = new ArrayList<>();
		for (SiteSetting s : siteSettings) {
			switch (s.getType()) {
				case 1:
					type1.add(s);
					break;
				case 2:
					type2.add(s);
					break;
				case 3:
					type3.add(s);
					break;
				default:
					break;
			}
		}
		map.put("type1", type1);
		map.put("type2", type2);
		map.put("type3", type3);
		return map;
	}

	@Override
	public Map<String, Object> getSiteInfo() {
		String redisKey = RedisKeyConstants.SITE_INFO_MAP;
		Map<String, Object> siteInfoMapFromRedis = redisService.getMapByValue(redisKey);
		if (siteInfoMapFromRedis != null) {
			return siteInfoMapFromRedis;
		}
		List<SiteSetting> siteSettings = siteSettingMapper.getList();
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> siteInfo = new HashMap<>();
		List<Badge> badges = new ArrayList<>();
		Introduction introduction = new Introduction();
		List<Favorite> favorites = new ArrayList<>();
		List<String> rollTexts = new ArrayList<>();
		for (SiteSetting s : siteSettings) {
			switch (s.getType()) {
				case 1:
					if (SiteSettingConstants.COPYRIGHT.equals(s.getNameEn())) {
						Copyright copyright = JacksonUtils.readValue(s.getValue(), Copyright.class);
						siteInfo.put(s.getNameEn(), copyright);
					} else {
						siteInfo.put(s.getNameEn(), s.getValue());
					}
					break;
				case 2:
					switch (s.getNameEn()) {
						case SiteSettingConstants.AVATAR:
							introduction.setAvatar(s.getValue());
							break;
						case SiteSettingConstants.NAME:
							introduction.setName(s.getValue());
							break;
						case SiteSettingConstants.GITHUB:
							introduction.setGithub(s.getValue());
							break;
						case SiteSettingConstants.TELEGRAM:
							introduction.setTelegram(s.getValue());
							break;
						case SiteSettingConstants.QQ:
							introduction.setQq(s.getValue());
							break;
						case SiteSettingConstants.BILIBILI:
							introduction.setBilibili(s.getValue());
							break;
						case SiteSettingConstants.NETEASE:
							introduction.setNetease(s.getValue());
							break;
						case SiteSettingConstants.EMAIL:
							introduction.setEmail(s.getValue());
							break;
						case SiteSettingConstants.FAVORITE:
							Favorite favorite = JacksonUtils.readValue(s.getValue(), Favorite.class);
							favorites.add(favorite);
							break;
						case SiteSettingConstants.ROLL_TEXT:
							Matcher m = PATTERN.matcher(s.getValue());
							while (m.find()) {
								rollTexts.add(m.group(1));
							}
							break;
						default:
							break;
					}
					break;
				case 3:
					Badge badge = JacksonUtils.readValue(s.getValue(), Badge.class);
					badges.add(badge);
					break;
				default:
					break;
			}
		}
		introduction.setFavorites(favorites);
		introduction.setRollText(rollTexts);
		map.put("introduction", introduction);
		map.put("siteInfo", siteInfo);
		map.put("badges", badges);
		redisService.saveMapToValue(redisKey, map);
		return map;
	}

	@Override
	public String getWebTitleSuffix() {
		return siteSettingMapper.getWebTitleSuffix();
	}

	@Override
	public void updateSiteSetting(List<LinkedHashMap> siteSettings, List<Integer> deleteIds) {
		for (Integer id : deleteIds) {
			//??????
			deleteOneSiteSettingById(id);
		}
		for (LinkedHashMap s : siteSettings) {
			SiteSetting siteSetting = JacksonUtils.convertValue(s, SiteSetting.class);
			if (siteSetting.getId() != null) {
				//??????
				updateOneSiteSetting(siteSetting);
			} else {
				//??????
				saveOneSiteSetting(siteSetting);
			}
		}
		deleteSiteInfoRedisCache();
	}

	@Transactional
	public void saveOneSiteSetting(SiteSetting siteSetting) {
		if (siteSettingMapper.saveSiteSetting(siteSetting) != 1) {
			throw new PersistenceException("??????????????????");
		}
	}

	@Transactional
	public void updateOneSiteSetting(SiteSetting siteSetting) {
		if (siteSettingMapper.updateSiteSetting(siteSetting) != 1) {
			throw new PersistenceException("??????????????????");
		}
	}

	@Transactional
	public void deleteOneSiteSettingById(Integer id) {
		if (siteSettingMapper.deleteSiteSettingById(id) != 1) {
			throw new PersistenceException("??????????????????");
		}
	}

	/**
	 * ????????????????????????
	 */
	private void deleteSiteInfoRedisCache() {
		redisService.deleteCacheByKey(RedisKeyConstants.SITE_INFO_MAP);
	}
}
