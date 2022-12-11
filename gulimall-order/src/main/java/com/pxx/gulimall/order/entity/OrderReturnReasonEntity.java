package com.pxx.gulimall.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ?˻?ԭ?
 * 
 * @author pxx
 * @email pxx@gmail.com
 * @date 2022-12-11 15:33:23
 */
@Data
@TableName("oms_order_return_reason")
public class OrderReturnReasonEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * ?˻?ԭ?
	 */
	private String name;
	/**
	 * ???
	 */
	private Integer sort;
	/**
	 * ????״̬
	 */
	private Integer status;
	/**
	 * create_time
	 */
	private Date createTime;

}
