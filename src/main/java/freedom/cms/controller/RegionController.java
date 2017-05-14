package freedom.cms.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

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
	
	@RequestMapping(value = "/cascade")
	public Result<?> cascade(HttpServletRequest request,String regionName)
	{
		try {
			System.out.println("regionName : " + regionName);
			request.setCharacterEncoding("UTF-8");
			regionName = request.getParameter("regionName");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("regionName : " + regionName);
		Region region = regionMapper.get(regionName);
		return Result.ok(regionMapper.listCity(region.getCode()));
	}
}
