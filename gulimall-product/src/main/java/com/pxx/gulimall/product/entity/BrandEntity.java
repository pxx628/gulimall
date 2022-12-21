package com.pxx.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.pxx.gulimall.common.myValid.ListValue;
import com.pxx.gulimall.common.validator.group.AddGroup;
import com.pxx.gulimall.common.validator.group.UpdateGroup;
import com.pxx.gulimall.common.validator.group.UpdateStatusGroup;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Ʒ?
 * 
 * @author pxx
 * @email pxx@gmail.com
 * @date 2022-12-10 17:02:56
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Ʒ??id
	 */
	@TableId
	@Null(message = "新增的时候不能指定id",groups = {AddGroup.class})
	@NotNull(message = "修改的id不能为null",groups = {UpdateGroup.class})
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank(message = "品牌名不能为空",groups = {AddGroup.class, UpdateGroup.class})
	private String name;
	/**
	 * Ʒ??logo??ַ
	 */
	@URL(message = "logo必须是一个合法的url地址",groups = {AddGroup.class, UpdateGroup.class})
	@NotBlank(message = "logo不能为空",groups = {AddGroup.class})
	private String logo;
	/**
	 * ???
	 */
	private String descript;
	/**
	 * ??ʾ״̬[0-????ʾ??1-??ʾ]
	 */
	@NotNull(groups = {AddGroup.class, UpdateStatusGroup.class})
	 @ListValue(value = {0,1},message = "状态只能填写0或者1",groups = {AddGroup.class, UpdateStatusGroup.class})
	private Integer showStatus;
	/**
	 * ????????ĸ
	 */
	@Pattern(regexp = "/^[a-zA-Z]$/",message = "检索首字母必须是一个字母",groups = {AddGroup.class, UpdateGroup.class})
	@NotEmpty(message = "检索首字母不能为空",groups = {AddGroup.class})
	private String firstLetter;
	/**
	 * ???
	 */
	@NotNull(message = "排序字段不能为空",groups = {AddGroup.class})
	@Min(value = 0,message = "排序必须大于0",groups = {AddGroup.class, UpdateGroup.class})
	private Integer sort;

}
