package com.springtraining.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springtraining.model.Kbnch;
import com.springtraining.repository.KbnchRepository;

@Service
public class KbnchService {

	@Autowired
	private KbnchRepository rep;

	public List<Kbnch> getKbnchAll() {
		return rep.findAll();
	}

	public Kbnch getKbnch(String kbnch, Object kbnchCd) {
		return rep.findById(kbnch, kbnchCd);
	}

	public List<Kbnch> getKbnch(String kbnch) {
		return rep.findByIdKbnchOrderBySortNo(kbnch);
	}

	public Map<Object, String> getKbnchMap(String kbnch) {
		List<Kbnch> list = getKbnch(kbnch);
		Map<Object, String> map = new HashMap<Object, String>();
		if (list.size() > 0) {
			for (Kbnch k : list) {
				map.put(k.getId().getKbnchCd(), k.getKbnchMesho());
			}
		}
		return map;
	}
}
