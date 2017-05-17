package com.springtraining.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springtraining.form.KintaiListForm;
import com.springtraining.model.KintaiListEntity;
import com.springtraining.model.MSection;
import com.springtraining.repository.MSectionRepository;

@Controller
public class KintaiListController {

	@Autowired
	private MSectionRepository sectionRep;

	@Autowired
	private EntityManager entityManager;

	@ModelAttribute
	KintaiListForm kintaiListForm() {
		return new KintaiListForm();
	}

	@RequestMapping(value = "kintaiList", method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("sectionList", getSectionMap());
		return "kintaiList";
	}

	@RequestMapping(value = "kintaiList", params = "search", method = RequestMethod.POST)
	public String searchKintaiList(Model model, KintaiListForm form) {
		System.out.println("kintaiList");

		Query query = entityManager.createNativeQuery(getKintaiListSql(), KintaiListEntity.class);
		query.setParameter(1, form.getSectionId());

		@SuppressWarnings("unchecked")
		List<KintaiListEntity> result = query.getResultList();

		if (result.size() > 0) {
			model.addAttribute("kintaiListDispFlg", "1");
			model.addAttribute("kintaiList", result);
		}

		model.addAttribute("sectionList", getSectionMap());
		return "kintaiList";
	}

	@RequestMapping(value = "kintaiList", method = RequestMethod.POST)
	public String back(Model model) {
		return "top";
	}

	private Map<String, String> getSectionMap() {
		List<MSection> list = sectionRep.findAll();
		Map<String, String> map = new HashMap<String, String>();
		if (list.size() > 0) {
			for (MSection msec : list) {
				map.put(msec.getSectionId(), msec.getSectionName());
			}
		}
		return map;
	}

	private String getKintaiListSql() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append("	u.user_id AS userId ");
		sb.append("	,u.name AS userName ");
		sb.append("	,SUM((t2.attendance_date - t1.attendance_date) * 24) AS workHours ");
		sb.append("	,SUM((t2.attendance_date - TO_DATE(TO_CHAR(t2.attendance_date, 'YYYY/MM/DD') || ' 18:00:00', 'YYYY/MM/DD HH24:MI:SS')) * 24) AS overTime ");
		sb.append("	,COUNT(*) AS workingDay ");
		sb.append("	,SUM(t1.chikok) AS lateDays ");
		sb.append("	,SUM(t2.soutai) AS leaveEarlyDays ");
		sb.append("FROM ");
		sb.append("	m_user u ");
		sb.append("	,( ");
		sb.append("		SELECT ");
		sb.append("			 t.user_id ");
		sb.append("			,t.attendance_date ");
		sb.append("			,CASE  ");
		sb.append("			 WHEN TO_CHAR(t.attendance_date, 'HH24:MI') < '09:00' THEN ");
		sb.append("				1 ");
		sb.append("			 ELSE ");
		sb.append("				0 ");
		sb.append("			 END AS chikok ");
		sb.append("		FROM    ");
		sb.append("			t_time t ");
		sb.append("		WHERE ");
		sb.append("			t.attendance_type = '0' ");
		sb.append("	) t1 ");
		sb.append("	,( ");
		sb.append("		SELECT ");
		sb.append("			t.user_id ");
		sb.append("			,t.attendance_date ");
		sb.append("			,CASE  ");
		sb.append("			WHEN TO_CHAR(t.attendance_date, 'HH24:MI') < '18:00' THEN ");
		sb.append("				1 ");
		sb.append("			ELSE ");
		sb.append("				0 ");
		sb.append("			END AS soutai ");
		sb.append("		FROM    ");
		sb.append("			t_time t ");
		sb.append("		WHERE ");
		sb.append("			t.attendance_type = '1' ");
		sb.append("	) t2 ");
		sb.append("WHERE ");
		sb.append("	u.user_id = t1.user_id ");
		sb.append("AND t1.user_id = t2.user_id ");
		sb.append("AND trunc(t1.attendance_date) = trunc(t2.attendance_date) ");
		sb.append("AND u.section_id = ? ");
		sb.append("GROUP BY ");
		sb.append("	u.user_id ");
		sb.append("	,u.name ");
		return sb.toString();
	}
}
