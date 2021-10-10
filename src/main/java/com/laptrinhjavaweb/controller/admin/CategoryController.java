package com.laptrinhjavaweb.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.SlideEntity;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.IProductService;
import com.laptrinhjavaweb.service.ISlideService;

@Controller(value = "categoryControllerOfAdmin")
@RequestMapping("/quan-tri/")
public class CategoryController {
	@Autowired
	ICategoryService category;
	
	@Autowired
	IProductService product;
	
	@Autowired
	ISlideService slide;
	
	@Autowired
	ServletContext context;
	
	@RequestMapping(value = "danh-muc", method = RequestMethod.GET)
	public ModelAndView pageListCategory() {
		ModelAndView mav = new ModelAndView("admin/category/index");
		List<CategoryEntity> list = category.findAll();
		mav.addObject("category", list);
		return mav;
	}
	
	@RequestMapping(value = "danh-muc/san-pham", method = RequestMethod.GET)
	public ModelAndView pageListProduct() {
		ModelAndView mav = new ModelAndView("admin/category/product");
		mav.addObject("product", product.findAll());
		return mav;
	}
	
	@RequestMapping(value = "danh-muc/trinh-chieu", method = RequestMethod.GET)
	public ModelAndView pageListSlide() {
		ModelAndView mav = new ModelAndView("admin/category/slide");
		List<SlideEntity> list = slide.findAll();
		list.get(0).getProduct();
		mav.addObject("slide", list);
		return mav;
	}
	
	@RequestMapping(value = "danh-muc/noi-bat", method = RequestMethod.GET)
	public ModelAndView pageListFeaturedProduct() {
		ModelAndView mav = new ModelAndView("admin/category/feature-product");
		mav.addObject("product", product.getListFeatureProduct());
		return mav;
	}
	
	@RequestMapping(value = "danh-muc/tao-moi", method = RequestMethod.GET)
	public ModelAndView createCategory() {
		ModelAndView mav = new ModelAndView("admin/category/create");
		List<CategoryEntity> list = category.findAll();
		mav.addObject("category", list);
		return mav;
	}
	
	@RequestMapping(value = "danh-muc/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editCategory(@RequestParam(value = "code", required=true)String code) {
		ModelAndView mav = new ModelAndView("admin/category/edit");
		CategoryEntity entity = category.findOneByCode(code);
		if(entity == null)
		{
			return new ModelAndView("redirect:/quan-tri/danh-muc").addObject("message", "Không tìm thấy danh mục");
		}
		mav.addObject("category", entity);
		return mav;
	}
	
	@RequestMapping(value = "danh-muc/xoa", method = RequestMethod.POST)
	public ModelAndView deleteCategory(@RequestParam("id")String id,
									@RequestParam("name")String name,
									@RequestParam("code")String code) 
	{
		CategoryEntity entity = category.findById(id);
		if(entity == null)
		{
			return new ModelAndView("admin/category/delete").addObject("message", "Không tìm thấy danh mục");
		}
		try {
			category.delete(entity);
			return new ModelAndView("redirect:/quan-tri/danh-muc").addObject("message", "Xóa thành công");
		}catch(Exception e) 
		{
			return new ModelAndView("admin/category/delete").addObject("message", "Không tìm thấy danh mục");
		}

	}
	
	@RequestMapping(value = "danh-muc/xoa", method = RequestMethod.GET)
	public ModelAndView deleteCategory(@RequestParam(value = "code", required=true)String code) {
		ModelAndView mav = new ModelAndView("admin/category/delete");
		CategoryEntity entity = category.findOneByCode(code);
		if(entity == null)
		{
			return new ModelAndView("redirect:/quan-tri/danh-muc").addObject("message", "Không tìm thấy danh mục");
		}
		mav.addObject("category", entity);
		return mav;
	}
	
	@RequestMapping(value = "danh-muc/chinh-sua", method = RequestMethod.POST)
	public ModelAndView editCategory(@RequestParam("id")String id,
									@RequestParam("name")String name,
									@RequestParam("code")String code) 
	{
		CategoryEntity entity = category.findById(id);
		if(entity == null)
		{
			return new ModelAndView("admin/category/edit").addObject("message", "Khﾃｴng tﾃｬm th蘯･y danh m盻･c");
		}
		try {
			entity.setCategoryCode(code);
			entity.setName(name);
			category.update(entity);
			return new ModelAndView("redirect:/quan-tri/danh-muc").addObject("message", "Khﾃｴng tﾃｬm th蘯･y danh m盻･c");
		}catch(Exception e) 
		{
			return new ModelAndView("admin/category/edit").addObject("message", "Ch盻穎h s盻ｭa thﾃ�nh cﾃｴng");
		}

	}
	
	@RequestMapping(value="danh-muc/tao-moi", method = RequestMethod.POST)
	public ModelAndView createCategory(
				@RequestParam("name")String name,
				@RequestParam("code")String code,
				@RequestParam("image")MultipartFile image)
	{
		if(name.trim().isEmpty() || code.trim().isEmpty())
		{
			return new ModelAndView("admin/category/create");
		}
		LocalDateTime now = LocalDateTime.now();  
		//String imagePath = context.getRealPath("/files/images/" + image.getOriginalFilename());
		
		CategoryEntity entity = new CategoryEntity();
		entity.setCategoryCode(code.trim());
		entity.setName(name.trim());
		//entity.setImagePath(imagePath);
		
		try {
			//image.transferTo(new File(imagePath));
			entity.setImagePath(write(image));
			entity.setImageSize(image.getSize());
			category.save(entity);
			return new ModelAndView("redirect:/quan-tri/danh-muc").addObject("message", "Thﾃｪm thﾃ�nh cﾃｴng");
		}
		catch(Exception ex)
		{
			ModelAndView mav = new ModelAndView("redirect:/quan-tri/danh-muc/tao-moi");
			mav.addObject("entity", entity);
			return mav;
		}
		
	}
	
	private String write(MultipartFile file) throws IOException {
	    String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"));
	    String fileName=date + file.getOriginalFilename();
	   
	    String folderPath = "D:/files/images/";
	    String filePath = folderPath + fileName;
	    
	    Files.copy(file.getInputStream(), Paths.get(filePath));
	    return filePath;
	}
}
