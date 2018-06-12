package com.project.capvi.model;

import java.io.Serializable;
import java.util.List;

import com.project.capvi.model.major.Major;
import com.project.capvi.model.module.Module;

public class MajorModuleResult implements Serializable{
	private Major major;
	private List<Module> modulesOptionel;
	private List<Integer> choixModule;
	private List<Module> modulesNonOptionel;
	private int score;
	
	public MajorModuleResult(Major major,List<Module> modulesOptionel,List<Integer> choixModule,List<Module> modulesNonOptionel,int score) {
		this.major=major;
		this.modulesOptionel=modulesOptionel;
		this.choixModule=choixModule;
		this.modulesNonOptionel=modulesNonOptionel;
		this.score=score;
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
