package com.project.capvi.model;

import java.io.Serializable;
import java.util.List;

import com.project.capvi.model.concept.Concept;
import com.project.capvi.model.major.Major;
import com.project.capvi.model.module.Module;

public class MajorModuleConceptResult implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4175975191178511886L;
	private Major major;
	private List<Module> modulesVert;
	private List<Module> modulesOrange;
	private List<Module> modulesRouge;
	
	private List<Concept> conceptsVert;
	private List<Concept> conceptsOrange;
	private List<Concept> conceptsRouge;
	
	private int score;
	
	public MajorModuleConceptResult(Major major,List<Module> modulesVert, List<Module> modulesOrange,List<Module> modulesRouge,
			List<Concept> conceptsVert,List<Concept> conceptsOrange,List<Concept> conceptsRouge,int score) {
		this.major=major;
		this.modulesVert=modulesVert;
		this.modulesOrange=modulesOrange;
		this.modulesRouge=modulesRouge;
		
		this.conceptsVert=conceptsVert;
		this.conceptsOrange=conceptsOrange;
		this.conceptsRouge=conceptsRouge;
		
		this.score=score;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public List<Module> getModulesVert() {
		return modulesVert;
	}

	public void setModulesVert(List<Module> modulesVert) {
		this.modulesVert = modulesVert;
	}

	public List<Module> getModulesOrange() {
		return modulesOrange;
	}

	public void setModulesOrange(List<Module> modulesOrange) {
		this.modulesOrange = modulesOrange;
	}

	public List<Module> getModulesRouge() {
		return modulesRouge;
	}

	public void setModulesRouge(List<Module> modulesRouge) {
		this.modulesRouge = modulesRouge;
	}

	public List<Concept> getConceptsVert() {
		return conceptsVert;
	}

	public void setConceptsVert(List<Concept> conceptsVert) {
		this.conceptsVert = conceptsVert;
	}

	public List<Concept> getConceptsOrange() {
		return conceptsOrange;
	}

	public void setConceptsOrange(List<Concept> conceptsOrange) {
		this.conceptsOrange = conceptsOrange;
	}

	public List<Concept> getConceptsRouge() {
		return conceptsRouge;
	}

	public void setConceptsRouge(List<Concept> conceptsRouge) {
		this.conceptsRouge = conceptsRouge;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
