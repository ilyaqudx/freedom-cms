package freedom.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import freedom.cms.domain.Region;
import freedom.cms.mapper.RegionMaaper;

@RestController
@RequestMapping("/region")
public class RegionController {

	@Autowired
	private RegionMaaper regionMapper;
	
	@RequestMapping("/cascade")
	public List<String> cascade(String regionName)
	{
		Region region = regionMapper.get(regionName);
		return regionMapper.listCity(region.getCode());
	}
}
