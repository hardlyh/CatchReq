package com.req.entity;

import java.util.ArrayList;

import com.req.vars.Vars;

public class SaveEntity {

	private static ArrayList<ReqDto> REQLIST = new ArrayList<ReqDto>();

	private static SaveEntity SaveEntity;

	public static SaveEntity Instance() {
		if (SaveEntity == null) {
			SaveEntity = new SaveEntity();
		}

		return SaveEntity;
	}

	public void save(ReqDto req) {
		//TODO 未解决线程安全问题,暂时搁置
		if (REQLIST.size() > Vars.LIST_SIZE) {
			REQLIST.remove(REQLIST.size() - 1);
		}
		this.REQLIST.add(req);
	}
	
	public ArrayList<ReqDto> getAll() {
		return REQLIST;
	}
}
