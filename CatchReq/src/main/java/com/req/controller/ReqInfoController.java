package com.req.controller;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.req.entity.ReqDto;
import com.req.entity.SaveEntity;

/**
 *  ReqInfo 控制层
 * @author liyuhui
 *
 */
@RestController
public class ReqInfoController {

	SaveEntity mapper = SaveEntity.Instance();

	@GetMapping("reqCatchGetAll")
	public ArrayList<ReqDto> getReqList() {
		ArrayList<ReqDto> all = mapper.getAll();
		Collections.reverse(all);
		return all;
	}
	
	@GetMapping("sendReqCatchReq")
	public String sendReqCatchReq() {
		return "访问成功";
	}
	
}
