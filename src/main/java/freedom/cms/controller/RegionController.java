package freedom.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import freedom.cms.Result;
import freedom.cms.domain.Region;
import freedom.cms.mapper.RegionMaaper;

@RestController
@RequestMapping("/region")
public class RegionController {

	@Autowired
	private RegionMaaper regionMapper;
	
	@RequestMapping("/cascade")
	public Result<?> cascade(String regionName)
	{
		Region region = regionMapper.get(regionName);
		return Result.ok(regionMapper.listCity(region.getCode()));
	}
}
