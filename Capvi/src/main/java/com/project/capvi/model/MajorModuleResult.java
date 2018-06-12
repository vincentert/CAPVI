package com.project.capvi.model;

import java.io.Serializable;
import java.util.List;

import com.project.capvi.model.major.Major;
import com.project.capvi.model.module.Module;

public class MajorModuleResult implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1357724419195142761L;
	private Major major;
	private List<Module> modulesOptionel;
	private List<Integer> choixModule;
	private List<Module> modulesNonOptionel;
	private List<Module> modulesVoulusOptionel;
	private List<Module> modulesVoulusNonOptionel;
	private List<Module> modulesNonVoulusOptionel;
	private List<Module> modulesNonVoulusNonOptionel;
	private int score;
	
	public MajorModuleResult(Major major,List<Module> modulesOptionel,List<Integer> choixModule,List<Module> modulesNonOptionel,int score,
			List<Module> modulesVoulusOptionel,List<Module> modulesVoulusNonOptionel,List<Module> modulesNonVoulusOptionel,List<Module> modulesNonVoulusNonOptionel) {
		this.major=major;
		this.modulesOptionel=modulesOptionel;
		this.choixModule=choixModule;
		this.modulesNonOptionel=modulesNonOptionel;
		this.score=score;
		this.modulesVoulusOptionel=modulesVoulusOptionel;
		this.modulesVoulusNonOptionel=modulesVoulusOptionel;
		this.modulesNonVoulusOptionel=modulesVoulusOptionel;
		this.modulesNonVoulusNonOptionel=modulesVoulusOptionel;
	}

	public List<Module> getModulesVoulusOptionel() {
		return modulesVoulusOptionel;
	}

	public void setModulesVoulusOptionel(List<Module> modulesVoulusOptionel) {
		this.modulesVoulusOptionel = modulesVoulusOptionel;
	}

	public List<Module> getModulesVoulusNonOptionel() {
		return modulesVoulusNonOptionel;
	}

	public void setModulesVoulusNonOptionel(List<Module> modulesVoulusNonOptionel) {
		this.modulesVoulusNonOptionel = modulesVoulusNonOptionel;
	}

	public List<Module> getModulesNonVoulusOptionel() {
		return modulesNonVoulusOptionel;
	}

	public void setModulesNonVoulusOptionel(List<Module> modulesNonVoulusOptionel) {
		this.modulesNonVoulusOptionel = modulesNonVoulusOptionel;
	}

	public List<Module> getModulesNonVoulusNonOptionel() {
		return modulesNonVoulusNonOptionel;
	}

	public void setModulesNonVoulusNonOptionel(List<Module> modulesNonVoulusNonOptionel) {
		this.modulesNonVoulusNonOptionel = modulesNonVoulusNonOptionel;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public List<Module> getModulesOptionel() {
		return modulesOptionel;
	}

	public void setModulesOptionel(List<Module> modulesOptionel) {
		this.modulesOptionel = modulesOptionel;
	}

	public List<Integer> getChoixModule() {
		return choixModule;
	}

	public void setChoixModule(List<Integer> choixModule) {
		this.choixModule = choixModule;
	}

	public List<Module> getModulesNonOptionel() {
		return modulesNonOptionel;
	}

	public void setModulesNonOptionel(List<Module> modulesNonOptionel) {
		this.modulesNonOptionel = modulesNonOptionel;
	}
	
}
