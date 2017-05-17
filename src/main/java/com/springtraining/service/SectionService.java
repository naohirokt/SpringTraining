package com.springtraining.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springtraining.model.MSection;
import com.springtraining.repository.MSectionRepository;

@Service
public class SectionService {

	@Autowired
	private MSectionRepository sectionRep;

	public List<MSection> getSectionAll() {
		return sectionRep.findAll();
	}

	public MSection getSection(String sectionId) {
		return sectionRep.findBySectionId(sectionId);
	}

	public void save(MSection user) {
		sectionRep.save(user);
	}

	public Map<String, String> getSectionMap() {
		List<MSection> list = getSectionAll();
		Map<String, String> map = new HashMap<String, String>();
		if (list.size() > 0) {
			for (MSection sec : list) {
				map.put(sec.getSectionId(), sec.getSectionName());
			}
		}
		return map;
	}
}
