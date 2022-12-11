package com.pxx.gulimall.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ?˿???Ϣ
 * 
 * @author pxx
 * @email pxx@gmail.com
 * @date 2022-12-11 15:33:23
 */
@Data
@TableName("oms_refund_info")
public class RefundInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * ?˿??Ķ???
	 */
	private Long orderReturnId;
	/**
	 * ?˿??
	 */
	private BigDecimal refund;
	/**
	 * ?˿????ˮ?
	 */
	private String refundSn;
	/**
	 * ?˿?״̬
	 */
	private Integer refundStatus;
	/**
	 * ?˿?????[1-֧??????2-΢?ţ?3-??????4-???
	 */
	private Integer refundChannel;
	/**
	 * 
	 */
	private String refundContent;

}
